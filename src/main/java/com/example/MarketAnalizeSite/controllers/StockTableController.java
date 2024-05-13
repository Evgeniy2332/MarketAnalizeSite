package com.example.MarketAnalizeSite.controllers;

import com.example.MarketAnalizeSite.models.stocks.StockData;
import org.jetbrains.annotations.NotNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.MarketAnalizeSite.service.StockTableService.*;

public class StockTableController {

    // метод для всех поисков на странице

    @GetMapping("/searchResultTab")
    public String showResultsTab(
            @RequestParam(value = "market", required = false, defaultValue = "russia") String market,
            @RequestParam(value = "searchKey", required = false) String searchKey,
            @RequestParam(value = "sector", required = false) String sector,
            @RequestParam(value = "frame", required = false) String frame,
            Model model) throws Exception {
        /*
Добавляем список секторов в модель
         */
        List<String> sectors = Arrays.asList("Utilities", "Transportation", "Technology Services", "Retail Trade",
                "Producer Manufacturing", "Process Industries", "Non-Energy Minerals",
                "Miscellaneous", "Industrial Services", "Health Technology", "Finance", "Energy Minerals",
                "Electronic Technology", "Distribution Services", "Consumer Services", "Consumer Non-Durables",
                "Consumer Durables", "Communications", "Commercial Services");
        model.addAttribute("sectors", sectors);
        /*
Добавляем список фреймов в модель
         */
        List<String> frames = Arrays.asList("День", "Неделя", "Месяц");
        model.addAttribute("frame", frames);

        String marketName;
        if ("russia".equalsIgnoreCase(market)) {
            marketName = "России";
        } else {
            marketName = "S&P500";
        }

/*
Получаем нужные данные по фильтрам (фрейм и рынок)
 */
        List<StockData> stocks = getStockData(market, frame);

        // Если предоставлен searchKey, отфильтруйте список акций
        if (searchKey != null && !searchKey.isEmpty()) {
            String searchKeyLower = searchKey.toLowerCase();
            stocks = stocks.stream()
                    .filter(stock ->
                            stock.getTiker().toLowerCase().contains(searchKeyLower) ||
                                    stock.getSector().toLowerCase().contains(searchKeyLower) ||
                                    stock.getFullName().toLowerCase().contains(searchKeyLower))
                    .collect(Collectors.toList());
        }
        if (sector != null && !sector.isEmpty()) {
            String sectorLower = sector.toLowerCase();
            stocks = stocks.stream()
                    .filter(stock -> stock.getSector().toLowerCase().contains(sectorLower))
                    .collect(Collectors.toList());
        }
        model.addAttribute("stocks", stocks);
        model.addAttribute("marketName", marketName);

        return "searchResultTab";
    }

    /**
     * Проверить как работает метод
     */
    private List<StockData> getStockData(String market, String frame) throws Exception {
        List<String> dataBySelectFrameAndMarket = getInfoTab(market, frame);
        List<StockData> stocks = new ArrayList<>();
        for (String s : dataBySelectFrameAndMarket) {
            try {
                StockData sd = new StockData(s);
//                        dataWeekly.get(i),
//                        dataMonthly.get(i));  //assuming the constructor to adapt to three
                stocks.add(sd);
            } catch (NumberFormatException e) {
                // обрабатываете ситуацию.
            }
        }
        return stocks;
    }

    private @NotNull List<String> getInfoTab(String market, String frame) throws Exception {
        if ("russia".equalsIgnoreCase(market) && "День".equalsIgnoreCase(frame)) {
            return getStockDataFromJson(getRussiaURL(), getDay());
        } else if ("america".equalsIgnoreCase(market) && "День".equalsIgnoreCase(frame)) {
            return getStockDataFromJson(getAmerURL(), getRsi_day_sp500());
        } else if ("america".equalsIgnoreCase(market) && "Неделя".equalsIgnoreCase(frame)) {
            return getStockDataFromJson(getAmerURL(), getRsi_week_sp500());
        } else if ("russia".equalsIgnoreCase(market) && "Неделя".equalsIgnoreCase(frame)) {
            return getStockDataFromJson(getRussiaURL(), getWeek());
        } else if ("russia".equalsIgnoreCase(market) && "Месяц".equalsIgnoreCase(frame)) {
            return getStockDataFromJson(getRussiaURL(), getMonth());
        } else if ("america".equalsIgnoreCase(market) && "Месяц".equalsIgnoreCase(frame)) {
            return getStockDataFromJson(getAmerURL(), getRsi_month_sp500());
        } else {
            throw new IllegalArgumentException(STR."Invalid market: \{market}");
        }
    }
}
