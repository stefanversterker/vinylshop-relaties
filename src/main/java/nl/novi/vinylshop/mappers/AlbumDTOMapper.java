package nl.novi.vinylshop.mappers;

import nl.novi.vinylshop.dtos.album.AlbumRequestDTO;
import nl.novi.vinylshop.dtos.album.AlbumResponseDTO;
import nl.novi.vinylshop.entities.AlbumEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlbumDTOMapper implements DTOMapper<AlbumResponseDTO, AlbumRequestDTO, AlbumEntity> {

    @Override
    public AlbumResponseDTO mapToDto(AlbumEntity model) {

        var result = new AlbumResponseDTO();
        result.setId(model.getId());
        result.setTitle(model.getTitle());
        result.setReleaseYear(model.getReleaseYear());
        return result;
    }

    @Override
    public List<AlbumResponseDTO> mapToDto(List<AlbumEntity> models) {
        var result = new ArrayList<AlbumResponseDTO>();
        for (AlbumEntity model : models) {
            result.add(mapToDto(model));
        }
        return result;
    }

    @Override
    public AlbumEntity mapToEntity(AlbumRequestDTO albumModel) {
        var result = new AlbumEntity();
        result.setTitle(albumModel.getTitle());
        result.setReleaseYear(albumModel.getReleaseYear());
        return result;
    }
}
