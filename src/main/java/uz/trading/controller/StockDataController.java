package uz.trading.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.trading.payload.response.GetStockDataResponse;
import uz.trading.service.StockDataService;

import java.util.List;

@RestController
@RequestMapping("/api/trading")
@RequiredArgsConstructor
@Tag(name = "Trading api", description = "API for trading product")
public class StockDataController {
    private final StockDataService stockDataService;

    @Operation(summary = "API to get stock data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Completed successfully!",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = GetStockDataResponse.class))})})
    @GetMapping(path = "/stock-data")
    public HttpEntity<?> getStockData() {
        return ResponseEntity.ok().body(stockDataService.getAllStockData());
    }

    @Operation(summary = "API to get stock data by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Completed successfully!",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = GetStockDataResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request!"),
            @ApiResponse(responseCode = "404", description = "Stock data not found!")
    })

    @GetMapping(path = "/stock-data-by-name")
    public ResponseEntity<?> getStockDataByName(
            @Parameter(description = "Stock name to filter data", example = "AAPL")
            @RequestParam String stockName) {

        List<GetStockDataResponse> stockData = stockDataService.getStockDataByName(stockName);

        if (stockData.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stock data not found!");
        }

        return ResponseEntity.ok().body(stockData);
    }
}
