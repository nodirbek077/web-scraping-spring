package uz.trading.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseInlineDTO {

    @JsonProperty("preMarketChange")
    private BigDecimal preMarketChange;

    @JsonProperty("preMarketChangePercent")
    private BigDecimal preMarketChangePercent;

    @JsonProperty("esgPopulated")
    private Boolean esgPopulated;

    @JsonProperty("corporateActions")
    private List<String> corporateActions;

    @JsonProperty("preMarketPrice")
    private BigDecimal preMarketPrice;

    @JsonProperty("preMarketTime")
    private Long preMarketTime;

    @JsonProperty("postMarketChange")
    private BigDecimal postMarketChange;

    @JsonProperty("postMarketChangePercent")
    private BigDecimal postMarketChangePercent;

    @JsonProperty("postMarketPrice")
    private BigDecimal postMarketPrice;

    @JsonProperty("postMarketTime")
    private Long postMarketTime;

    @JsonProperty("language")
    private String language;

    @JsonProperty("region")
    private String region;

    @JsonProperty("quoteType")
    private String quoteType;

    @JsonProperty("typeDisp")
    private String typeDisp;

    @JsonProperty("quoteSourceName")
    private String quoteSourceName;

    @JsonProperty("triggerable")
    private Boolean triggerable;

    @JsonProperty("customPriceAlertConfidence")
    private String customPriceAlertConfidence;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("marketState")
    private String marketState;

    @JsonProperty("shortName")
    private String shortName;

    @JsonProperty("longName")
    private String longName;

    @JsonProperty("regularMarketChangePercent")
    private BigDecimal regularMarketChangePercent;

    @JsonProperty("regularMarketPrice")
    private BigDecimal regularMarketPrice;

    @JsonProperty("regularMarketTime")
    private Long regularMarketTime;

    @JsonProperty("exchange")
    private String exchange;

    @JsonProperty("exchangeTimezoneName")
    private String exchangeTimezoneName;

    @JsonProperty("exchangeTimezoneShortName")
    private String exchangeTimezoneShortName;

    @JsonProperty("gmtOffSetMilliseconds")
    private Long gmtOffSetMilliseconds;

    @JsonProperty("market")
    private String market;

    @JsonProperty("marketCap")
    private BigDecimal marketCap;

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("regularMarketChange")
    private BigDecimal regularMarketChange;

    @JsonProperty("regularMarketDayHigh")
    private BigDecimal regularMarketDayHigh;

    @JsonProperty("regularMarketDayRange")
    private String regularMarketDayRange;

    @JsonProperty("regularMarketDayLow")
    private BigDecimal regularMarketDayLow;

    @JsonProperty("regularMarketVolume")
    private Long regularMarketVolume;

    @JsonProperty("regularMarketPreviousClose")
    private BigDecimal regularMarketPreviousClose;

    @JsonProperty("bid")
    private BigDecimal bid;

    @JsonProperty("ask")
    private BigDecimal ask;

    @JsonProperty("bidSize")
    private Integer bidSize;

    @JsonProperty("askSize")
    private Integer askSize;

    @JsonProperty("fullExchangeName")
    private String fullExchangeName;

    @JsonProperty("financialCurrency")
    private String financialCurrency;

    @JsonProperty("regularMarketOpen")
    private BigDecimal regularMarketOpen;

    @JsonProperty("tradeable")
    private Boolean tradeable;

    @JsonProperty("cryptoTradeable")
    private Boolean cryptoTradeable;

    @JsonProperty("averageDailyVolume3Month")
    private Long averageDailyVolume3Month;

    @JsonProperty("averageDailyVolume10Day")
    private Long averageDailyVolume10Day;

    @JsonProperty("fiftyTwoWeekLow")
    private BigDecimal fiftyTwoWeekLow;

    @JsonProperty("fiftyTwoWeekHigh")
    private BigDecimal fiftyTwoWeekHigh;

    @JsonProperty("fiftyTwoWeekRange")
    private String fiftyTwoWeekRange;

    @JsonProperty("dividendDate")
    private Long dividendDate;

    @JsonProperty("earningsTimestamp")
    private Long earningsTimestamp;

    @JsonProperty("earningsTimestampStart")
    private Long earningsTimestampStart;

    @JsonProperty("earningsTimestampEnd")
    private Long earningsTimestampEnd;

    @JsonProperty("trailingAnnualDividendRate")
    private BigDecimal trailingAnnualDividendRate;

    @JsonProperty("trailingPE")
    private BigDecimal trailingPE;

    @JsonProperty("dividendRate")
    private BigDecimal dividendRate;

    @JsonProperty("trailingAnnualDividendYield")
    private BigDecimal trailingAnnualDividendYield;

    @JsonProperty("dividendYield")
    private BigDecimal dividendYield;

    @JsonProperty("epsTrailingTwelveMonths")
    private BigDecimal epsTrailingTwelveMonths;

    @JsonProperty("epsForward")
    private BigDecimal epsForward;

    @JsonProperty("epsCurrentYear")
    private BigDecimal epsCurrentYear;

    @JsonProperty("priceEpsCurrentYear")
    private BigDecimal priceEpsCurrentYear;

    @JsonProperty("sharesOutstanding")
    private Long sharesOutstanding;

    @JsonProperty("bookValue")
    private BigDecimal bookValue;

    @JsonProperty("fiftyDayAverage")
    private BigDecimal fiftyDayAverage;

    @JsonProperty("twoHundredDayAverage")
    private BigDecimal twoHundredDayAverage;

    @JsonProperty("forwardPE")
    private BigDecimal forwardPE;

    @JsonProperty("priceToBook")
    private BigDecimal priceToBook;

    @JsonProperty("sourceInterval")
    private Integer sourceInterval;

    @JsonProperty("exchangeDataDelayedBy")
    private Integer exchangeDataDelayedBy;

    @JsonProperty("averageAnalystRating")
    private String averageAnalystRating;

    @JsonProperty("displayName")
    private String displayName;

    @JsonProperty("hasPrePostMarketData")
    private Boolean hasPrePostMarketData;
}
