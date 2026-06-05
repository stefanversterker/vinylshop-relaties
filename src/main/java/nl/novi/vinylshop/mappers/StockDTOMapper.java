package nl.novi.vinylshop.mappers;

import nl.novi.vinylshop.dtos.stock.StockRequestDTO;
import nl.novi.vinylshop.dtos.stock.StockResponseDTO;
import nl.novi.vinylshop.entities.StockEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StockDTOMapper implements DTOMapper<StockResponseDTO, StockRequestDTO, StockEntity> {

    @Override
    public StockResponseDTO mapToDto(StockEntity model) {

        var result = new StockResponseDTO();
        result.setId(model.getId());
        result.setCondition(model.getCondition());
        result.setPrice(model.getPrice());
        return result;
    }

    @Override
    public List<StockResponseDTO> mapToDto(List<StockEntity> models) {
        var result = new ArrayList<StockResponseDTO>();
        for (StockEntity model : models) {
            result.add(mapToDto(model));
        }
        return result;
    }


    @Override
    public StockEntity mapToEntity(StockRequestDTO stockModel) {
        var result = new StockEntity();
        result.setCondition(stockModel.getCondition());
        result.setPrice(stockModel.getPrice());
        return result;
    }
}
