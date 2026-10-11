
package Lab2;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MainDriver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Interest[] investments = new Interest[5];

        for (int i = 0; i < investments.length; i++) {

            System.out.println("\nInvestment " + (i + 1));

            try {
                System.out.print("Enter Principal: ");
                BigDecimal principal = scanner.nextBigDecimal();

                System.out.print("Enter Interest Rate (%): ");
                BigDecimal rate = scanner.nextBigDecimal();

                System.out.print("Enter Time (years): ");
                int time = scanner.nextInt();

                investments[i] = new Interest(principal, rate, time);

                System.out.println("Simple Interest (BigDecimal): "
                        + investments[i].calculateSimpleInterest(
                                principal, rate, time));

                System.out.println("Simple Interest (double): "
                        + investments[i].calculateSimpleInterest(
                                principal.doubleValue(),
                                rate.doubleValue(), time));

                System.out.println("Compound Interest (BigDecimal): "
                        + investments[i].calculateCompoundInterest(
                                principal, rate, time));

                System.out.println("Compound Interest (double): "
                        + investments[i].calculateCompoundInterest(
                                principal.doubleValue(),
                                rate.doubleValue(), time));

            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
                e.getCause();
                e.getMessage();

            } catch (ArithmeticException e) {
                e.printStackTrace();
                e.getCause();
                e.getMessage();

            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                e.getCause();
                e.getMessage();

            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                scanner.nextLine();
                i--;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                i--;
            }
        }

        System.out.println("\nCompound Interest using Scanner:");

        System.out.println(
                investments[0].calculateCompoundInterest());

        scanner.close();
    }
}
