package com.example.MarketAnalizeSite.models.bonds;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NewBondResponse{

    @JsonProperty("NewBondResponse")
    private List<NewBondResponseItem> newBondResponse;
}
