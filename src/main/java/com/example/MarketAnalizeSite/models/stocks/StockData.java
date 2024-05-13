package com.example.MarketAnalizeSite.models.stocks;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
public class StockData {

    private  String tiker;
    private String fullName;
    private Double RsiD;
    private Double price;
    private Double signalMacd;
    private Double urovenMacd;
    private Double izmYTD;
    private Double izmYear;
    private Double izmMonth;
    private Double izmWeek;
    private String sector;
    private Double RsiW;
    private Double RsiM;

    public StockData(String respD){
        List<String> splitResp = Arrays.stream(respD.split(",")).toList();

        try {
            tiker = splitResp.get(1);
            fullName=splitResp.get(11);
            try {
                price = Double.parseDouble(splitResp.get(2));
                urovenMacd = Double.parseDouble(splitResp.get(4));
                signalMacd = Double.parseDouble(splitResp.get(5));
                RsiD = Double.parseDouble(splitResp.get(3));

                izmYTD = Double.parseDouble(splitResp.get(9));
                izmYear = Double.parseDouble(splitResp.get(6));
                izmMonth = Double.parseDouble(splitResp.get(7));
                izmWeek = Double.parseDouble(splitResp.get(8));
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid number format in JSON: ");
            }

            sector = splitResp.get(10);

        } catch (IndexOutOfBoundsException ie) {
            System.out.printf("Ответ пришёл в неверном формате:%s%n", respD);
        }
    }
}

