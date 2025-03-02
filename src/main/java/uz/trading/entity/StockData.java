package uz.trading.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "stocks")
public class StockData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stock_name", nullable = false)
    private String stockName;

    @Column(name = "stock_price", nullable = false)
    private Double stockPrice;

    @Column(name = "stock_volume", nullable = false)
    private String stockVolume;

    @Column(name = "stock_open", nullable = false)
    private Double stockOpen;

    @Column(name = "today_date", nullable = false)
    private LocalDateTime todayDate;

    public StockData() {
    }
}
