package nl.novi.vinylshop.mappers;

import nl.novi.vinylshop.dtos.artist.ArtistRequestDTO;
import nl.novi.vinylshop.dtos.artist.ArtistResponseDTO;
import nl.novi.vinylshop.dtos.genre.GenreRequestDTO;
import nl.novi.vinylshop.entities.ArtistEntity;
import nl.novi.vinylshop.entities.GenreEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArtistDTOMapper implements DTOMapper<ArtistResponseDTO, ArtistRequestDTO, ArtistEntity> {

    @Override
    public ArtistResponseDTO mapToDto(ArtistEntity model) {

        var result = new ArtistResponseDTO();
        result.setName(model.getName());
        result.setBiography(model.getBiography());
        return result;
    }

    @Override
    public List<ArtistResponseDTO> mapToDto(List<ArtistEntity> models) {
        var result = new ArrayList<ArtistResponseDTO>();
        for (ArtistEntity model : models) {
            result.add(mapToDto(model));
        }
        return result;
    }

    @Override
    public ArtistEntity mapToEntity(ArtistRequestDTO artistModel) {
        var result = new ArtistEntity();
        result.setName(artistModel.getName());
        result.setBiography(artistModel.getBiography());
        return result;
    }
}
