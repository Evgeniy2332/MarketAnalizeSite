package com.example.MarketAnalizeSite.models.stocks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sort{

    @JsonProperty("sortOrder")
    private String sortOrder;

    @JsonProperty("sortBy")
    private String sortBy;

    @JsonProperty("nullsFirst")
    private boolean nullsFirst;
}
