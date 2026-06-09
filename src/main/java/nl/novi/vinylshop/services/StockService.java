package nl.novi.vinylshop.services;

import jakarta.persistence.EntityNotFoundException;
import nl.novi.vinylshop.dtos.stock.StockRequestDTO;
import nl.novi.vinylshop.dtos.stock.StockResponseDTO;
import nl.novi.vinylshop.entities.StockEntity;
import nl.novi.vinylshop.exceptions.RecordNotFoundException;
import nl.novi.vinylshop.mappers.StockDTOMapper;
import nl.novi.vinylshop.repositories.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;
    private final StockDTOMapper stockDTOMapper;

    public StockService(StockRepository stockRepository, StockDTOMapper stockDTOMapper) {
        this.stockRepository = stockRepository;
        this.stockDTOMapper = stockDTOMapper;
    }

    public List<StockResponseDTO> findAllStock() {
        return stockDTOMapper.mapToDto(stockRepository.findAll());
    }

    public StockResponseDTO findStockById(Long id) throws EntityNotFoundException {
        nl.novi.vinylshop.entities.StockEntity stockEntity = getStockEntity(id);
        return stockDTOMapper.mapToDto(stockEntity);
    }

    public StockResponseDTO createStock(StockRequestDTO stockDTO) {
        StockEntity stockEntity = stockDTOMapper.mapToEntity(stockDTO);
        stockEntity = stockRepository.save(stockEntity);
        return stockDTOMapper.mapToDto(stockEntity);
    }

    public StockResponseDTO updateStock(Long id, StockRequestDTO requestDto) throws EntityNotFoundException {
        StockEntity existingStockEntity = getStockEntity(id);

        existingStockEntity.setCondition(requestDto.getCondition());
        existingStockEntity.setPrice(requestDto.getPrice());

        existingStockEntity = stockRepository.save(existingStockEntity);
        return stockDTOMapper.mapToDto(existingStockEntity);
    }

    private StockEntity getStockEntity(Long id) {
        StockEntity existingStockEntity = stockRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Stock " + id +" not found"));
        return existingStockEntity;
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
