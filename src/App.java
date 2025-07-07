import java.util.Objects;
import java.util.Scanner;
import models.OperationType;

public class App {
    public static void main(String[] args) throws Exception {
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        int code;
        double a, b;
        OperationType operation;

        while (!exit) {
            code = -1;
            System.out.print("| Select operation type ");
            for (OperationType type : OperationType.values()) {
                System.out.print(" | " + type.get_name() + " (" + type.get_code() + ")");
            }

            while (code < 0 || code > 3) {
                System.out.print(" : ");
                code = sc.nextInt();
            }

            operation = OperationType.get_type_by_code(code);

            System.out.print("| Enter first value : ");
            a = sc.nextDouble();
            
            System.out.print("| Enter second value : ");
            b = sc.nextDouble();

            System.out.println("| Result : " + operation.calc(a, b));
            System.out.println("-------");
            System.out.print("| Exit (Y/N) : ");
            exit = Objects.equals(sc.next(), "Y");
            System.out.println("-------");
        }
        sc.close();
    }
}
