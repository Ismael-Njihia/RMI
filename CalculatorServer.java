import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            // Create an instance of the remote object
            Calculator calculator = new CalculatorImpl();

            // Register the remote object with the RMI registry
            LocateRegistry.createRegistry(2099);
            Naming.rebind("CalculatorService", calculator);

            System.out.println("Calculator service started");
        } catch (Exception e) {
            System.err.println("Calculator service exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
