package uz.trading.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MetaDTO {

    @JsonProperty("version")
    private String version;

    @JsonProperty("status")
    private int status;

    @JsonProperty("copywrite")
    private String copywrite;

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("processedTime")
    private String processedTime;
}
