import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    // Exchange rates relative to USD
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        exchangeRates.put("USD", 1.0);
        exchangeRates.put("CAD", 1.25); // 1 USD = 1.25 CAD
        exchangeRates.put("EUR", 0.85); // 1 USD = 0.85 EUR
        exchangeRates.put("HKD", 7.85); // 1 USD = 7.85 HKD
        exchangeRates.put("INR", 74.50); // 1 USD = 74.50 INR
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.println("Welcome, " + userName + "!");

        System.out.println("Currency Converter");
        System.out.println("Available currencies: USD, CAD, EUR, HKD, INR");

        System.out.print("Enter the source currency: ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency: ");
        String toCurrency = scanner.next().toUpperCase();

        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            System.out.println("Invalid currency entered. Please use one of the available currencies.");
            scanner.close();
            return;
        }

        System.out.print("Enter the amount in " + fromCurrency + ": ");
        double amount = scanner.nextDouble();

        // Convert amount to USD first, then to target currency
        double amountInUSD = amount / exchangeRates.get(fromCurrency);
        double convertedAmount = amountInUSD * exchangeRates.get(toCurrency);

        System.out.printf("%s, %.2f %s is %.2f %s\n", userName, amount, fromCurrency, convertedAmount, toCurrency);

        scanner.close();
    }
}
