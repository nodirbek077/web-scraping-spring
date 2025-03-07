package uz.trading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.trading.entity.Stock;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    @Query(value = "SELECT * FROM STOCKS ORDER BY id DESC", nativeQuery = true)
    List<Stock> findAllStockData();

    List<Stock> findByStockNameOrderByIdDesc(String stockName);
}