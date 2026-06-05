package nl.novi.vinylshop.services;

import jakarta.persistence.EntityNotFoundException;
import nl.novi.vinylshop.dtos.artist.ArtistRequestDTO;
import nl.novi.vinylshop.dtos.artist.ArtistResponseDTO;
import nl.novi.vinylshop.entities.ArtistEntity;
import nl.novi.vinylshop.exceptions.RecordNotFoundException;
import nl.novi.vinylshop.mappers.ArtistDTOMapper;
import nl.novi.vinylshop.repositories.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;
    private final ArtistDTOMapper artistDTOMapper;

    public ArtistService(ArtistRepository artistRepository, ArtistDTOMapper artistDTOMapper) {
        this.artistRepository = artistRepository;
        this.artistDTOMapper = artistDTOMapper;
    }

    public List<ArtistResponseDTO> findAllArtists() {
        return artistDTOMapper.mapToDto(artistRepository.findAll());
    }

    public ArtistResponseDTO findArtistById(Long id) throws EntityNotFoundException {
        nl.novi.vinylshop.entities.ArtistEntity artistEntity = getArtistEntity(id);
        return artistDTOMapper.mapToDto(artistEntity);
    }

    public ArtistResponseDTO createArtist(ArtistRequestDTO artistDTO) {
        ArtistEntity artistEntity = artistDTOMapper.mapToEntity(artistDTO);
        artistEntity = artistRepository.save(artistEntity);
        return artistDTOMapper.mapToDto(artistEntity);
    }

    public ArtistResponseDTO updateArtist(Long id, ArtistRequestDTO requestDto) throws EntityNotFoundException {
        ArtistEntity existingArtistEntity = getArtistEntity(id);

        existingArtistEntity.setName(requestDto.getName());
        existingArtistEntity.setBiography(requestDto.getBiography());

        existingArtistEntity = artistRepository.save(existingArtistEntity);
        return artistDTOMapper.mapToDto(existingArtistEntity);
    }

    private ArtistEntity getArtistEntity(Long id) {
        ArtistEntity existingArtistEntity = artistRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Artist " + id +" not found"));
        return existingArtistEntity;
    }

    public void deleteArtist(Long id) {
        artistRepository.deleteById(id);
    }
}
