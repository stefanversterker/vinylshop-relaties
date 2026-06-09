package nl.novi.vinylshop.dtos.stock;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class StockRequestDTO {

    private String condition;

    @NotNull
    @DecimalMin(value = "0.01", message = "Prijs moet groter zijn dan 0")
    private double price;

    //Getters en setters

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
