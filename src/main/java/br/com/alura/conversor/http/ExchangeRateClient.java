package br.com.alura.conversor.http;

import br.com.alura.conversor.model.ExchangeRateResponse;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateClient {

    private final String apiKey;
    private final HttpClient http;
    private final Gson gson;

    public ExchangeRateClient(String apiKey) {
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalArgumentException("API key inválida.");
        }
        this.apiKey = apiKey.trim();
        this.http = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public ExchangeRateResponse latest(String baseCurrency) throws Exception {
        if (baseCurrency == null || baseCurrency.isBlank()) {
            throw new IllegalArgumentException("Moeda base inválida.");
        }

        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency.trim().toUpperCase();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new RuntimeException("Falha HTTP " + response.statusCode() + ": " + response.body());
        }

        ExchangeRateResponse data = gson.fromJson(response.body(), ExchangeRateResponse.class);

        if (data == null) {
            throw new RuntimeException("Resposta vazia/ inválida da API.");
        }
        if (!"success".equalsIgnoreCase(data.result())) {
            throw new RuntimeException("API retornou erro: " + data.result());
        }

        return data;
    }
}
