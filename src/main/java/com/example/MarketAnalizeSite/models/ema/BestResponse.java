package com.example.MarketAnalizeSite.models.ema;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BestResponse{

    @JsonProperty("data")
    private List<DataBest> data;

    @JsonProperty("totalCount")
    private Integer totalCount;
}