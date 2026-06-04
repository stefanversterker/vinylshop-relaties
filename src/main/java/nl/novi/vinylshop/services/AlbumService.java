package nl.novi.vinylshop.services;

import nl.novi.vinylshop.dtos.album.AlbumResponseDTO;
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
}
