package com.example.MarketAnalizeSite.models.stocks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Futures {
    @JsonProperty("filter")
    private List<FilterItem> filter;

    @JsonProperty("options")
    private Options options;

    @JsonProperty("sort")
    private Sort sort;

    @JsonProperty("symbols")
    private Symbols symbols;
}
