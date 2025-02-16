package uz.trading.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "stocks")
public class StockData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockId;

    @Column(nullable = false)
    private String stockName;

    @Column(nullable = false)
    private Double stockPrice;

    @Column(nullable = false)
    private String stockVolume;

    @Column(nullable = false)
    private Double stockOpen;

    @Column(nullable = false)
    private String currentDate;

    public StockData() {
    }
}
