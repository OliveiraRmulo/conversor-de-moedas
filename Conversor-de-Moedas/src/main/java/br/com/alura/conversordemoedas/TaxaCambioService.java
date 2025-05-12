package br.com.alura.conversordemoedas;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class TaxaCambioService {
    private static final String API_KEY = "825d46ee4169488b39aaccff";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private final HttpClient httpClient;

    public TaxaCambioService() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public double getExchangeRate(String fromCurrency, String toCurrency) throws IOException, InterruptedException {
        String urlString = BASE_URL + API_KEY + "/pair/" + fromCurrency + "/" + toCurrency;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Erro ao conectar à API: Código " + response.statusCode());
        }

        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
        return jsonResponse.get("conversion_rate").getAsDouble();
    }

    public Map<String, String> getAvailableCurrencies() throws IOException, InterruptedException {
        String urlString = BASE_URL + API_KEY + "/codes";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlString))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Erro ao conectar à API: Código " + response.statusCode());
        }

        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject supportedCodes = jsonResponse.getAsJsonObject("supported_codes");

        Map<String, String> currencies = new HashMap<>();
        for (var entry : supportedCodes.entrySet()) {
            currencies.put(entry.getKey(), entry.getValue().getAsString());
        }

        return currencies;
    }
}