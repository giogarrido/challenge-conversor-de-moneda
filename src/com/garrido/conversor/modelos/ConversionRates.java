package com.garrido.conversor.modelos;

public record ConversionRates(
        double USD,
        double MXN,
        double BRL,
        double COP
)
{
    // Método para obtener el valor por el código de la moneda
    public double getValue(String currencyCode) {
        return switch (currencyCode.toUpperCase()) {
            case "USD" -> USD;
            case "MXN" -> MXN;
            case "BRL" -> BRL;
            case "COP" -> COP;
            default -> throw new IllegalArgumentException("Moneda no soportada: " + currencyCode);
        };
    }
}
