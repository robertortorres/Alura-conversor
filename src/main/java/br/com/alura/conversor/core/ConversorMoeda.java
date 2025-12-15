package br.com.alura.conversor.core;

import br.com.alura.conversor.model.ExchangeRateResponse;

public class ConversorMoeda {

    public double converter(double valor, String targetCurrency, ExchangeRateResponse rates) {
        if (rates == null || rates.conversionRates() == null) {
            throw new IllegalArgumentException("Taxas não disponíveis.");
        }

        Double taxa = rates.conversionRates().get(targetCurrency);
        if (taxa == null) {
            throw new IllegalArgumentException("Moeda não encontrada nas taxas: " + targetCurrency);
        }

        return valor * taxa;
    }
}
