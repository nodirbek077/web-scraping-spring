package uz.trading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.trading.entity.StockData;

import java.util.List;

public interface StockRepository extends JpaRepository<StockData, Integer> {

    @Query(value = "SELECT * FROM STOCKS ORDER BY STOCK_ID DESC", nativeQuery = true)
    List<StockData> findAllStockData();
}