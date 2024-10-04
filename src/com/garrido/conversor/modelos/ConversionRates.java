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

    public String getValueConvertTxt(String currencyCode) {
        return switch (currencyCode.toUpperCase()) {
            case "USD" -> "Dólar";
            case "MXN" -> "Peso Mexicano";
            case "BRL" -> "Real Brasileño";
            case "COP" -> "Peso Colombiano";
            default -> throw new IllegalArgumentException("Moneda no soportada: " + currencyCode);
        };
    }
    public String getValueConvertedTxt(String currencyCode) {
        return switch (currencyCode.toUpperCase()) {
            case "USD" -> "Dólares";
            case "MXN" -> "Pesos Mexicano";
            case "BRL" -> "Reales Brasileño";
            case "COP" -> "Pesos Colombiano";
            default -> throw new IllegalArgumentException("Moneda no soportada: " + currencyCode);
        };
    }
}
