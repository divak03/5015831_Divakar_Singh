package AlgorthmsDataStructures;

import java.util.Scanner;

public class FinancialForecasting {

   
    public static double predictFutureValue(double currentValue, double growthRate, int periods) {
        
        if (periods == 0) {
            return currentValue;
        }
        
        return predictFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Financial Forecasting Tool");

     
        System.out.print("Enter the initial value: ");
        double initialValue = scanner.nextDouble();

      
        System.out.print("Enter the growth rate (as a decimal, e.g., 0.05 for 5%): ");
        double growthRate = scanner.nextDouble();

        
        System.out.print("Enter the number of periods: ");
        int periods = scanner.nextInt();

        
        double futureValue = predictFutureValue(initialValue, growthRate, periods);

        
        System.out.println("Predicted future value after " + periods + " periods: " + futureValue);

        scanner.close();
    }
}
