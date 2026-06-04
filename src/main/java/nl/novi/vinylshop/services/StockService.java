package nl.novi.vinylshop.services;

import nl.novi.vinylshop.dtos.stock.StockResponseDTO;
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
}
