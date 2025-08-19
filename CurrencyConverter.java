import java.util.*;

public class CurrencyConverter {
    
    // Predefined exchange rates relative to 1 USD
    private static final Map<String, Double> exchangeRates = new HashMap<>();
    
    static {
        exchangeRates.put("USD", 1.0);       // US Dollar
        exchangeRates.put("EUR", 0.91);      // Euro
        exchangeRates.put("INR", 83.10);     // Indian Rupee
        exchangeRates.put("GBP", 0.78);      // British Pound
        exchangeRates.put("JPY", 146.52);    // Japanese Yen
        exchangeRates.put("AUD", 1.50);      // Australian Dollar
        exchangeRates.put("CAD", 1.36);      // Canadian Dollar
    }

    public static double convert(String from, String to, double amount) {
        if (!exchangeRates.containsKey(from) || !exchangeRates.containsKey(to)) {
            throw new IllegalArgumentException("Unsupported currency.");
        }
        // Convert 'from' currency to USD first, then to target currency
        double amountInUSD = amount / exchangeRates.get(from);
        return amountInUSD * exchangeRates.get(to);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter!");
        System.out.println("Supported Currencies: " + exchangeRates.keySet());
        
        System.out.println("Enter source currency: ");
        String from = sc.next().toUpperCase();
        
        System.out.println("Enter target currency: ");
        String to = sc.next().toUpperCase();
        
        System.out.println("Enter amount: ");
        double amount = sc.nextDouble();
        
        try {
            double result = convert(from, to, amount);
            System.out.printf("%.2f %s = %.2f %s%n", amount, from, result, to);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        sc.close();
    }
}
