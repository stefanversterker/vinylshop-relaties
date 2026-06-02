package nl.novi.vinylshop.mappers;

import nl.novi.vinylshop.dtos.artist.ArtistRequestDTO;
import nl.novi.vinylshop.dtos.artist.ArtistResponseDTO;
import nl.novi.vinylshop.entities.ArtistEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArtistDTOMapper implements DTOMapper<ArtistResponseDTO, ArtistRequestDTO, ArtistEntity> {

    @Override
    public ArtistResponseDTO mapToDto(ArtistEntity model) {
        return null;
    }

    @Override
    public List<ArtistResponseDTO> mapToDto(List<ArtistEntity> models) {
        return List.of();
    }

    @Override
    public ArtistEntity mapToEntity(ArtistRequestDTO genreModel) {
        return null;
    }
}
