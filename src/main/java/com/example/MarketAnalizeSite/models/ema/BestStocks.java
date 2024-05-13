package com.example.MarketAnalizeSite.models.ema;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
public class BestStocks {

    private  String ticker;
    private String fullName;
    private String shortName;
    private Double price;
    private Double EMA50D;
    private Double EMA50N;
    private Double EMA50M;
    private Double EMA100D;
    private Double EMA100N;
    private Double EMA100M;
    private Double EMA200D;
    private Double EMA200N;
    private Double EMA200M;

    public BestStocks(@NotNull String respD){
        List<String> splitResp = Arrays.stream(respD.split(",")).toList();
        try {
            ticker = splitResp.get(0).substring(1);
            fullName=splitResp.get(1);
            shortName =splitResp.get(2);
            try {
                price = Double.parseDouble(splitResp.get(6));
                EMA50D=Double.parseDouble(splitResp.get(12));
                EMA50N=Double.parseDouble(splitResp.get(13));
                EMA50M=Double.parseDouble(splitResp.get(14));
                EMA100D=Double.parseDouble(splitResp.get(15));
                EMA100N=Double.parseDouble(splitResp.get(16));
                EMA100M = Double.parseDouble(splitResp.get(17));
                EMA200D=Double.parseDouble(splitResp.get(18));
                EMA200N = Double.parseDouble(splitResp.get(19));
                EMA200M=Double.parseDouble(splitResp.get(20));
            } catch (NumberFormatException nfe) {
                System.err.println("Не верный числовой формат в JSON: ");
            }
        } catch (IndexOutOfBoundsException ie) {
            System.out.printf("Ответ пришёл в неверном формате:%s%n", respD);
        }
    }
}

