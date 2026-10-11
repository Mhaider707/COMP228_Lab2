
package Lab2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Interest {

    private BigDecimal principal;
    private BigDecimal rate;
    private int time;


    // Constructor validates inputs
    public Interest(BigDecimal principal, BigDecimal rate, int time) {

        if (principal == null || rate == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        if (principal.compareTo(BigDecimal.ZERO) < 0
                || rate.compareTo(BigDecimal.ZERO) < 0
                || time < 0) {
            throw new IllegalArgumentException(
                    "Negative values are not allowed");
        }

        if (principal.scale() <= 0 || rate.scale() <= 0) {
            throw new IllegalArgumentException(
                "Integer values are not allowed for principal and rate");
        }

        this.principal = principal;
        this.rate = rate;
        this.time = time;
    }

    // Simple Interest using BigDecimal

    // SI = P*R*T / 100;
    // returning BigDecimal

    public BigDecimal calculateSimpleInterest(
            BigDecimal p, BigDecimal r, int t) {

        BigDecimal simpleInterest = p.multiply(r)
                .multiply(BigDecimal.valueOf(t))
                .divide(BigDecimal.valueOf(100), 2,
                        RoundingMode.HALF_UP);

        return simpleInterest;
    }

    // Simple Interest using Double - method overloading
    public double calculateSimpleInterest(
            double p, double r, int t) {

        double simpleInterest = (p * r * t) / 100;

        return simpleInterest;
    }

    // Compound Interest using BigDecimal
    public BigDecimal calculateCompoundInterest(
            BigDecimal p, BigDecimal r, int t) {

        BigDecimal rateDecimal = r.divide(
                BigDecimal.valueOf(100), 10,
                RoundingMode.HALF_UP);

        BigDecimal amount = p.multiply(
                BigDecimal.ONE.add(rateDecimal).pow(t));

        BigDecimal compoundInterest = amount.subtract(p);

        return compoundInterest.setScale(
                2, RoundingMode.HALF_UP);
    }

    // Compound Interest using Double - method overloading
    public double calculateCompoundInterest(
            double p, double r, int t) {

        double amount = p * Math.pow(1 + r / 100, t);

        double compoundInterest = amount - p;

        return compoundInterest;
    }

    /*
     * This method is overloaded and takes inputs from the user
     * using scanner and returns double value.
     */
    public double calculateCompoundInterest() {

        Scanner sc = new Scanner(System.in);

        // Scan the inputs from the user..!
        System.out.println("Ask the user to input Principal Amt");
        double principal = sc.nextDouble();

        System.out.println("Enter Interest Rate");
        double rate = sc.nextDouble();

        System.out.println("Enter Time");
        int time = sc.nextInt();

        new Interest(BigDecimal.valueOf(principal),
                BigDecimal.valueOf(rate), time);

        double amount = principal * Math.pow(1 + rate / 100, time);
        double val = amount - principal;

        return val;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public int getTime() {
        return time;
    }
}
