package com.garrido.conversor.modelos;

public record Conversion(
        String result,
        String base_code,
        ConversionRates conversion_rates
) {
}
