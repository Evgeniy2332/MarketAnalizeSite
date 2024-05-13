package com.example.MarketAnalizeSite.models.stocks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {

    @JsonProperty("data")
    private List<DataItem> data;

    @JsonProperty("totalCount")
    private int totalCount;

    @JsonIgnoreProperties("params")
    private Params params;

}

