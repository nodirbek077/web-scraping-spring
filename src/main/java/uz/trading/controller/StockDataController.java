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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.trading.payload.response.GetStockDataResponse;
import uz.trading.service.StockDataService;

@RestController
@RequestMapping("/api/trading")
@RequiredArgsConstructor
@Tag(name = "Trading", description = "API for trading product")
public class StockDataController {
    private final StockDataService stockDataService;

    @Operation(summary = "API to get stock data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Completed successfully!",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = GetStockDataResponse.class))})})
    @GetMapping(path = "/stocks")
    public HttpEntity<?> getStockData() {
        return ResponseEntity.ok().body(stockDataService.getAllStockData());
    }

    @Operation(summary = "API to get stock data by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Completed successfully!",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = GetStockDataResponse.class))})})
    @GetMapping("/stocks/{stockName}")
    public ResponseEntity<?> getStockDataByName(
            @Parameter(description = "Stock name to filter data", example = "AAPL")
            @PathVariable String stockName) {
        return ResponseEntity.ok().body(stockDataService.getStockDataByName(stockName));
    }
}
