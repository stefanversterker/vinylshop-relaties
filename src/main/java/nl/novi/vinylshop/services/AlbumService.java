package nl.novi.vinylshop.services;

import jakarta.persistence.EntityNotFoundException;
import nl.novi.vinylshop.dtos.album.AlbumRequestDTO;
import nl.novi.vinylshop.dtos.album.AlbumResponseDTO;
import nl.novi.vinylshop.entities.AlbumEntity;
import nl.novi.vinylshop.exceptions.RecordNotFoundException;
import nl.novi.vinylshop.mappers.AlbumDTOMapper;
import nl.novi.vinylshop.repositories.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumDTOMapper albumDTOMapper;

    public AlbumService(AlbumRepository albumRepository, AlbumDTOMapper albumDTOMapper) {
        this.albumRepository = albumRepository;
        this.albumDTOMapper = albumDTOMapper;
    }

    public List<AlbumResponseDTO> findAllAlbums() {
        return albumDTOMapper.mapToDto(albumRepository.findAll());
    }

    public AlbumResponseDTO findAlbumById(Long id) throws EntityNotFoundException {
        nl.novi.vinylshop.entities.AlbumEntity albumEntity = getAlbumEntity(id);
        return albumDTOMapper.mapToDto(albumEntity);
    }

    public AlbumResponseDTO createAlbum(AlbumRequestDTO albumDTO) {
        AlbumEntity albumEntity = albumDTOMapper.mapToEntity(albumDTO);
        albumEntity = albumRepository.save(albumEntity);
        return albumDTOMapper.mapToDto(albumEntity);
    }

    public AlbumResponseDTO updateAlbum(Long id, AlbumRequestDTO requestDto) throws EntityNotFoundException {
        AlbumEntity existingAlbumEntity = getAlbumEntity(id);

        existingAlbumEntity.setTitle(requestDto.getTitle());
        existingAlbumEntity.setReleaseYear(requestDto.getReleaseYear());

        existingAlbumEntity = albumRepository.save(existingAlbumEntity);
        return albumDTOMapper.mapToDto(existingAlbumEntity);
    }

    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }

    private AlbumEntity getAlbumEntity(Long id) {
        AlbumEntity existingAlbumEntity = albumRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Album " + id +" not found"));
        return existingAlbumEntity;
    }
}
