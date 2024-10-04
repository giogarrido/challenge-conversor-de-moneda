package com.garrido.conversor.modelos;

public record ExchangeRate(
        String result,
        String base_code,
        ConversionRates conversion_rates
) {
}
