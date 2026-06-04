package nl.novi.vinylshop.services;

import nl.novi.vinylshop.dtos.artist.ArtistResponseDTO;
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
}
