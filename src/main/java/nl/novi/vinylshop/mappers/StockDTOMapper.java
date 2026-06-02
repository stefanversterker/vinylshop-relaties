package nl.novi.vinylshop.mappers;

import nl.novi.vinylshop.dtos.stock.StockRequestDTO;
import nl.novi.vinylshop.dtos.stock.StockResponseDTO;
import nl.novi.vinylshop.entities.StockEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StockDTOMapper implements DTOMapper<StockResponseDTO, StockRequestDTO, StockEntity> {

    @Override
    public StockResponseDTO mapToDto(StockEntity model) {
        return null;
    }

    @Override
    public List<StockResponseDTO> mapToDto(List<StockEntity> models) {
        return List.of();
    }

    @Override
    public StockEntity mapToEntity(StockRequestDTO genreModel) {
        return null;
    }
}
