package nl.novi.vinylshop.mappers;

import nl.novi.vinylshop.dtos.album.AlbumRequestDTO;
import nl.novi.vinylshop.dtos.album.AlbumResponseDTO;
import nl.novi.vinylshop.entities.AlbumEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Primary
@Component
public class AlbumDTOMapper implements DTOMapper<AlbumResponseDTO, AlbumRequestDTO, AlbumEntity> {

    //Inject genreMapper en publisherMapper
    private final GenreDTOMapper genreMapper;
    private final PublisherDTOMapper publisherMapper;

    public AlbumDTOMapper(
            GenreDTOMapper genreMapper,
            PublisherDTOMapper publisherMapper) {

        this.genreMapper = genreMapper;
        this.publisherMapper = publisherMapper;
    }

    @Override
    public AlbumResponseDTO mapToDto(AlbumEntity model) {

        var result = new AlbumResponseDTO();
        result.setId(model.getId());
        result.setTitle(model.getTitle());
        result.setReleaseYear(model.getReleaseYear());
        //Relationship mapping
        result.setGenre(genreMapper.mapToDto(model.getGenre()));
        result.setPublisher(publisherMapper.mapToDto(model.getPublisher()));
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
