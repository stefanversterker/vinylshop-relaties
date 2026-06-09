package nl.novi.vinylshop.dtos.album;

import nl.novi.vinylshop.dtos.stock.StockResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class AlbumExtendedResponseDto extends AlbumResponseDTO {

    private List<StockResponseDTO> stockItems = new ArrayList<>();

    //Getters en setters
    public List<StockResponseDTO> getStockItems() {
        return stockItems;
    }

    public void setStockItems(List<StockResponseDTO> stockItems) {
        this.stockItems = stockItems;
    }
}
