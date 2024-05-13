package com.example.MarketAnalizeSite.models.stocks;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataItem {
    @JsonProperty("s")
    private String S;

    @JsonProperty("d")
    private List<Object> D;

}
