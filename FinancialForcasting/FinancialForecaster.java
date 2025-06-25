import java.text.DecimalFormat;

public class FinancialForecaster {

    // Recursive method (monthly compounding)
    public static double calculateFutureValueRecursive(double amount, double monthlyRate, int months) {
        if (months == 0) return amount;
        return calculateFutureValueRecursive(amount, monthlyRate, months - 1) * (1 + monthlyRate);
    }

    // Iterative method (monthly compounding)
    public static double calculateFutureValueIterative(double amount, double monthlyRate, int months) {
        for (int i = 1; i <= months; i++) {
            amount *= (1 + monthlyRate);
        }
        return amount;
    }

    // ASCII chart for graphical output
    public static void printForecastChart(double initial, double rate, int months) {
        System.out.println("\n--- Forecast Chart ---");
        double monthlyRate = rate / 12;
        DecimalFormat df = new DecimalFormat("#.##");

        for (int m = 0; m <= months; m += 6) { // print every 6 months
            double fv = calculateFutureValueIterative(initial, monthlyRate, m);
            int bars = (int)(fv / initial * 10); // scale for bar length
            System.out.printf("Month %2d: $%-10s | ", m, df.format(fv));
            for (int i = 0; i < bars; i++) {
                System.out.print("█");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double initialAmount = 10000;     // Initial investment
        double annualRate = 0.08;         // 8% annual rate
        int years = 5;
        int totalMonths = years * 12;
        double monthlyRate = annualRate / 12;

        System.out.println("=== Financial Forecasting Tool ===");
        System.out.println("Initial Investment: $" + initialAmount);
        System.out.println("Annual Growth Rate: " + (annualRate * 100) + "%");
        System.out.println("Forecast Duration: " + years + " years (" + totalMonths + " months)");

        // Recursive calculation
        double recursiveFV = calculateFutureValueRecursive(initialAmount, monthlyRate, totalMonths);
        System.out.printf("Future Value (Recursive): $%.2f\n", recursiveFV);

        // Iterative calculation
        double iterativeFV = calculateFutureValueIterative(initialAmount, monthlyRate, totalMonths);
        System.out.printf("Future Value (Iterative): $%.2f\n", iterativeFV);

        // Visual representation
        printForecastChart(initialAmount, annualRate, totalMonths);
    }
}
