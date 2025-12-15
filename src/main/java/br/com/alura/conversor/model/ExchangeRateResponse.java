package br.com.alura.conversor.model;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

/**
 * Resposta do endpoint:
 * GET https://v6.exchangerate-api.com/v6/{API_KEY}/latest/{BASE}
 */
public record ExchangeRateResponse(
        String result,
        @SerializedName("base_code") String baseCode,
        @SerializedName("conversion_rates") Map<String, Double> conversionRates
) {}
