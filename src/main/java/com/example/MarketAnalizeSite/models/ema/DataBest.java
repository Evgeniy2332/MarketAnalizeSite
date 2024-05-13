package com.example.MarketAnalizeSite.models.ema;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataBest{

    @JsonProperty("s")
    private String S;

    @JsonProperty("d")
    private List<String> D;
}