package com.example.MarketAnalizeSite.models.stocks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Options {
    @JsonProperty("lang")
    private String lang;
}
