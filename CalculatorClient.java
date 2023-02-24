import java.rmi.Naming;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Obtain a reference to the remote object
            Calculator calculator = (Calculator) Naming.lookup("CalculatorService");

            // Prompt the user to enter two numbers
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the first number: ");
            int a = scanner.nextInt();
            System.out.print("Enter the second number: ");
            int b = scanner.nextInt();

            // Use the remote object to perform calculations
            int result = calculator.add(a, b);
            System.out.println(a + " + " + b + " = " + result);

            result = calculator.subtract(a, b);
            System.out.println(a + " - " + b + " = " + result);

            result = calculator.multiply(a, b);
            System.out.println(a + " * " + b + " = " + result);

            result = calculator.divide(a, b);
            System.out.println(a + " / " + b + " = " + result);
        } catch (Exception e) {
            System.err.println("Calculator client exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
