package nl.novi.vinylshop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock")
public class StockEntity extends BaseEntity {

    private String condition;
    private double price;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private AlbumEntity album;

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