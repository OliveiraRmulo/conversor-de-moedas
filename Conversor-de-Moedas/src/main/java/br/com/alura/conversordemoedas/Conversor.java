package br.com.alura.conversordemoedas;

public class Conversor {
    private final TaxaCambioService taxaCambioService;

    public Conversor(TaxaCambioService taxaCambioService) {
        this.taxaCambioService = taxaCambioService;
    }

    public double convert(String fromCurrency, String toCurrency, double amount) throws Exception {
        double rate = taxaCambioService.getExchangeRate(fromCurrency, toCurrency);
        return amount * rate;
    }
}