package com.example.MarketAnalizeSite.service;

import com.example.MarketAnalizeSite.models.stocks.DataItem;
import com.example.MarketAnalizeSite.models.stocks.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
public class StockTableService {
    @Getter
    private static final String RussiaURL = "https://scanner.tradingview.com/russia/scan";
    @Getter
    private static final String AmerURL = "https://scanner.tradingview.com/america/scan";
    @Getter
    public static final String rsi_day_sp500 = "{\"filter\":[{\"left\":\"type\",\"operation\":\"in_range\",\"right\":[\"stock\",\"dr\",\"fund\"]},{\"left\":\"subtype\",\"operation\":\"in_range\",\"right\":[\"common\",\"foreign-issuer\",\"\",\"etf\",\"etf,odd\",\"etf,otc\",\"etf,cfd\"]},{\"left\":\"exchange\",\"operation\":\"in_range\",\"right\":[\"AMEX\",\"NASDAQ\",\"NYSE\"]},{\"left\":\"is_primary\",\"operation\":\"equal\",\"right\":true},{\"left\":\"active_symbol\",\"operation\":\"equal\",\"right\":true}],\"options\":{\"lang\":\"ru\"},\"markets\":[\"america\"],\"symbols\":{\"query\":{\"types\":[]},\"tickers\":[],\"groups\":[{\"type\":\"index\",\"values\":[\"SP:SPX\"]}]},\"columns\":[\"logoid\",\"name\",\"close\",\"RSI\",\"MACD.macd\",\"MACD.signal\",\"Perf.Y\",\"Perf.1M\",\"Perf.W\",\"Perf.YTD\",\"sector\",\"description\",\"type\",\"subtype\",\"update_mode\",\"pricescale\",\"minmov\",\"fractional\",\"minmove2\",\"RSI[1]\",\"currency\",\"fundamental_currency_code\"],\"sort\":{\"sortBy\":\"market_cap_basic\",\"sortOrder\":\"desc\"},\"range\":[0,600]}";
    @Getter
    public static final String rsi_week_sp500 = "{\"filter\":[{\"left\":\"type\",\"operation\":\"in_range\",\"right\":[\"stock\",\"dr\",\"fund\"]},{\"left\":\"subtype\",\"operation\":\"in_range\",\"right\":[\"common\",\"foreign-issuer\",\"\",\"etf\",\"etf,odd\",\"etf,otc\",\"etf,cfd\"]},{\"left\":\"exchange\",\"operation\":\"in_range\",\"right\":[\"AMEX\",\"NASDAQ\",\"NYSE\"]},{\"left\":\"is_primary\",\"operation\":\"equal\",\"right\":true},{\"left\":\"active_symbol\",\"operation\":\"equal\",\"right\":true}],\"options\":{\"lang\":\"ru\"},\"markets\":[\"america\"],\"symbols\":{\"query\":{\"types\":[]},\"tickers\":[],\"groups\":[{\"type\":\"index\",\"values\":[\"SP:SPX\"]}]},\"columns\":[\"logoid\",\"name\",\"close|1W\",\"RSI|1W\",\"MACD.macd|1W\",\"MACD.signal|1W\",\"Perf.Y\",\"Perf.1M\",\"Perf.W\",\"Perf.YTD\",\"sector\",\"description\",\"type\",\"subtype\",\"update_mode|1W\",\"pricescale\",\"minmov\",\"fractional\",\"minmove2\",\"RSI[1]|1W\",\"currency\",\"fundamental_currency_code\"],\"sort\":{\"sortBy\":\"market_cap_basic\",\"sortOrder\":\"desc\"},\"range\":[0,600]}";
    @Getter
    public static final String rsi_month_sp500 = "{\"filter\":[{\"left\":\"type\",\"operation\":\"in_range\",\"right\":[\"stock\",\"dr\",\"fund\"]},{\"left\":\"subtype\",\"operation\":\"in_range\",\"right\":[\"common\",\"foreign-issuer\",\"\",\"etf\",\"etf,odd\",\"etf,otc\",\"etf,cfd\"]},{\"left\":\"exchange\",\"operation\":\"in_range\",\"right\":[\"AMEX\",\"NASDAQ\",\"NYSE\"]},{\"left\":\"is_primary\",\"operation\":\"equal\",\"right\":true},{\"left\":\"active_symbol\",\"operation\":\"equal\",\"right\":true}],\"options\":{\"lang\":\"ru\"},\"markets\":[\"america\"],\"symbols\":{\"query\":{\"types\":[]},\"tickers\":[],\"groups\":[{\"type\":\"index\",\"values\":[\"SP:SPX\"]}]},\"columns\":[\"logoid\",\"name\",\"close|1M\",\"RSI|1M\",\"MACD.macd|1M\",\"MACD.signal|1M\",\"Perf.Y\",\"Perf.1M\",\"Perf.W\",\"Perf.YTD\",\"sector\",\"description\",\"type\",\"subtype\",\"update_mode|1M\",\"pricescale\",\"minmov\",\"fractional\",\"minmove2\",\"RSI[1]|1M\",\"currency\",\"fundamental_currency_code\"],\"sort\":{\"sortBy\":\"market_cap_basic\",\"sortOrder\":\"desc\"},\"range\":[0,600]}";
    @Getter
    public static final String day = "{\"filter\":[{\"left\":\"type\",\"operation\":\"in_range\",\"right\":[\"stock\",\"dr\"]},{\"left\":\"subtype\",\"operation\":\"in_range\",\"right\":[\"common\",\"foreign-issuer\",\"\",\"preferred\"]},{\"left\":\"active_symbol\",\"operation\":\"equal\",\"right\":true}],\"options\":{\"lang\":\"ru\"},\"markets\":[\"russia\"],\"symbols\":{\"query\":{\"types\":[]},\"tickers\":[]},\"columns\":[\"logoid\",\"name\",\"close\",\"RSI\",\"MACD.macd\",\"MACD.signal\",\"Perf.Y\",\"Perf.1M\",\"Perf.W\",\"Perf.YTD\",\"sector\",\"description\",\"type\",\"subtype\",\"update_mode\",\"pricescale\",\"minmov\",\"fractional\",\"minmove2\",\"RSI[1]\",\"currency\",\"fundamental_currency_code\"],\"sort\":{\"sortBy\":\"sector\",\"sortOrder\":\"desc\"},\"price_conversion\":{\"to_symbol\":false},\"range\":[0,300]}";
    @Getter
    public static final String week = "{\"filter\":[{\"left\":\"type\",\"operation\":\"in_range\",\"right\":[\"stock\",\"dr\"]},{\"left\":\"subtype\",\"operation\":\"in_range\",\"right\":[\"common\",\"foreign-issuer\",\"\",\"preferred\"]},{\"left\":\"active_symbol\",\"operation\":\"equal\",\"right\":true}],\"options\":{\"lang\":\"ru\"},\"markets\":[\"russia\"],\"symbols\":{\"query\":{\"types\":[]},\"tickers\":[]},\"columns\":[\"logoid\",\"name\",\"close|1W\",\"RSI|1W\",\"MACD.macd|1W\",\"MACD.signal|1W\",\"Perf.Y\",\"Perf.1M\",\"Perf.W\",\"Perf.YTD\",\"sector\",\"description\",\"type\",\"subtype\",\"update_mode|1W\",\"pricescale\",\"minmov\",\"fractional\",\"minmove2\",\"RSI[1]|1W\",\"currency\",\"fundamental_currency_code\"],\"sort\":{\"sortBy\":\"sector\",\"sortOrder\":\"desc\"},\"price_conversion\":{\"to_symbol\":false},\"range\":[0,300]}";
    @Getter
    private static final String month = "{\"filter\":[{\"left\":\"type\",\"operation\":\"in_range\",\"right\":[\"stock\",\"dr\"]},{\"left\":\"subtype\",\"operation\":\"in_range\",\"right\":[\"common\",\"foreign-issuer\",\"\",\"preferred\"]},{\"left\":\"active_symbol\",\"operation\":\"equal\",\"right\":true}],\"options\":{\"lang\":\"ru\"},\"markets\":[\"russia\"],\"symbols\":{\"query\":{\"types\":[]},\"tickers\":[]},\"columns\":[\"logoid\",\"name\",\"close|1M\",\"RSI|1M\",\"MACD.macd|1M\",\"MACD.signal|1M\",\"Perf.Y\",\"Perf.1M\",\"Perf.W\",\"Perf.YTD\",\"sector\",\"description\",\"type\",\"subtype\",\"update_mode|1M\",\"pricescale\",\"minmov\",\"fractional\",\"minmove2\",\"RSI[1]|1M\",\"currency\",\"fundamental_currency_code\"],\"sort\":{\"sortBy\":\"sector\",\"sortOrder\":\"desc\"},\"price_conversion\":{\"to_symbol\":false},\"range\":[0,300]}";

    /***
     * Отправка запросов получение и обработка ответов
     */
    private static final OkHttpClient CLIENT = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build();
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // метод для получения всего массива json //

    public static Response sendPostRequest(String url, String jsonData) throws Exception {
        RequestBody body = RequestBody.create(jsonData.getBytes());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (okhttp3.Response response = CLIENT.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new Exception(STR."Unexpected HTTP code: \{response}");
            }
            return parseResponse(response.body().string());
        }
    }

    /*
     парсим json для ответа
     */

    private static Response parseResponse(String body) throws Exception {
        return MAPPER.readValue(body, Response.class);
    }

    public static @NonNull List<String> getStockDataFromJson(String url, String data) throws Exception {
        return sendPostRequest(url, data)
                .getData()
                .stream()
                .filter(Objects::nonNull)
                .map(DataItem::getD)
                .map(Object::toString)
                .toList();
    }
}
