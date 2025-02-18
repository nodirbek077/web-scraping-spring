package uz.trading.payload.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.trading.entity.StockData;

import java.util.List;

@Data
@NoArgsConstructor
public class GetStockDataResponse {

    @Schema(description = "Response error code", example = "0")
    private Integer errorCode;

    @Schema(description = "Response error message", example = "Successfully completed!")
    private String errorMessage;

    @Schema(description = "Stock data", example = "")
    private List<StockData> stockData;

    public GetStockDataResponse(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public GetStockDataResponse(Integer errorCode, String errorMessage, List<StockData> stockData) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.stockData = stockData;
    }


}
