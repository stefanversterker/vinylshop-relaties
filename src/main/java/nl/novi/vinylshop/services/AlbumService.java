package nl.novi.vinylshop.services;

import jakarta.persistence.EntityNotFoundException;
import nl.novi.vinylshop.dtos.album.AlbumExtendedResponseDto;
import nl.novi.vinylshop.dtos.album.AlbumRequestDTO;
import nl.novi.vinylshop.dtos.album.AlbumResponseDTO;
import nl.novi.vinylshop.entities.AlbumEntity;
import nl.novi.vinylshop.entities.ArtistEntity;
import nl.novi.vinylshop.entities.GenreEntity;
import nl.novi.vinylshop.entities.PublisherEntity;
import nl.novi.vinylshop.exceptions.RecordNotFoundException;
import nl.novi.vinylshop.mappers.AlbumDTOMapper;
import nl.novi.vinylshop.mappers.AlbumExtendedDTOMapper;
import nl.novi.vinylshop.repositories.AlbumRepository;
import nl.novi.vinylshop.repositories.ArtistRepository;
import nl.novi.vinylshop.repositories.GenreRepository;
import nl.novi.vinylshop.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Service
public class AlbumService {

    //Field declarations
    private final AlbumRepository albumRepository;
    private final AlbumDTOMapper albumDTOMapper;
    private final AlbumExtendedDTOMapper albumExtendedDTOMapper;
    private final GenreRepository genreRepository;
    private final PublisherRepository publisherRepository;
    private final ArtistRepository artistRepository;

    public AlbumService(AlbumRepository albumRepository,
                        AlbumDTOMapper albumDTOMapper,
                        AlbumExtendedDTOMapper albumExtendedDTOMapper,
                        GenreRepository genreRepository,
                        PublisherRepository publisherRepository,
                        ArtistRepository artistRepository) {
        this.albumRepository = albumRepository;
        this.albumDTOMapper = albumDTOMapper;
        this.albumExtendedDTOMapper = albumExtendedDTOMapper;
        this.genreRepository = genreRepository;
        this.publisherRepository = publisherRepository;
        this.artistRepository = artistRepository;
    }

    public List<AlbumResponseDTO> findAllAlbums() {
        return albumDTOMapper.mapToDto(albumRepository.findAll());
    }

    public AlbumExtendedResponseDto findAlbumById(Long id) throws EntityNotFoundException {
        nl.novi.vinylshop.entities.AlbumEntity albumEntity = getAlbumEntity(id);
        return albumExtendedDTOMapper.mapToDto(albumEntity);
    }

    public AlbumResponseDTO createAlbum(AlbumRequestDTO albumDTO) {

        AlbumEntity albumEntity = albumDTOMapper.mapToEntity(albumDTO);

        if (albumDTO.getGenreId() != null) {
            albumEntity.setGenre(getGenreEntity(albumDTO.getGenreId()));
        }

        if (albumDTO.getPublisherId() != null) {
            albumEntity.setPublisher(getPublisherEntity(albumDTO.getPublisherId()));
        }

        albumEntity = albumRepository.save(albumEntity);

        return albumDTOMapper.mapToDto(albumEntity);
    }

    public AlbumResponseDTO updateAlbum(Long id, AlbumRequestDTO requestDto) throws EntityNotFoundException {
        AlbumEntity existingAlbumEntity = getAlbumEntity(id);

        existingAlbumEntity.setTitle(requestDto.getTitle());
        existingAlbumEntity.setReleaseYear(requestDto.getReleaseYear());
        existingAlbumEntity.setGenre(getGenreEntity(requestDto.getGenreId()));
        existingAlbumEntity.setPublisher(getPublisherEntity(requestDto.getPublisherId()));

        existingAlbumEntity = albumRepository.save(existingAlbumEntity);
        return albumDTOMapper.mapToDto(existingAlbumEntity);
    }

    public void deleteAlbum(Long id) {
        AlbumEntity album = getAlbumEntity(id);

        if (album.getStockItems().isEmpty()) {
            albumRepository.deleteById(id);
        }
    }

    public void linkArtist(Long albumId, Long artistId) {
        AlbumEntity album = getAlbumEntity(albumId);
        ArtistEntity artist = getArtistEntity(artistId);
        album.getArtists().add(artist);
        albumRepository.save(album);
    }

    public void unlinkArtist(Long albumId, Long artistId) {
        AlbumEntity album = getAlbumEntity(albumId);
        ArtistEntity artist = getArtistEntity(artistId);
        album.getArtists().remove(artist);
        albumRepository.save(album);
    }

    private AlbumEntity getAlbumEntity(Long id) {
        AlbumEntity existingAlbumEntity = albumRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Album " + id + " not found"));
        return existingAlbumEntity;
    }

    private GenreEntity getGenreEntity(Long id) {
        GenreEntity existingGenreEntity = genreRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Genre " + id + " not found"));
        return existingGenreEntity;
    }

    private PublisherEntity getPublisherEntity(Long id) {
        PublisherEntity existingPublisherEntity = publisherRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Publisher " + id + " not found"));
        return existingPublisherEntity;
    }

    private ArtistEntity getArtistEntity(Long id) {
        ArtistEntity existingArtistEntity = artistRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Artist " + id + " not found"));
        return existingArtistEntity;
    }


}
