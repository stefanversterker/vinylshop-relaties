package nl.novi.vinylshop.mappers;

import nl.novi.vinylshop.dtos.album.AlbumExtendedResponseDto;
import nl.novi.vinylshop.dtos.album.AlbumResponseDTO;
import nl.novi.vinylshop.entities.AlbumEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class AlbumExtendedDTOMapper extends AlbumDTOMapper {

    private final StockDTOMapper stockMapper;

    public AlbumExtendedDTOMapper(GenreDTOMapper genreMapper,
                                  PublisherDTOMapper publisherMapper,
                                  StockDTOMapper stockMapper) {

        //Super roept AlbumDTOMapper constructor aan
        super(genreMapper, publisherMapper);

        this.stockMapper = stockMapper;
    }


    @Override
    public AlbumExtendedResponseDto mapToDto(AlbumEntity model) {

        var result = new AlbumExtendedResponseDto();
        AlbumResponseDTO baseDto = super.mapToDto(model);
        result.setStockItems(
                stockMapper.mapToDto(
                        new ArrayList<>(model.getStockItems())));
        return result;
    }


}
