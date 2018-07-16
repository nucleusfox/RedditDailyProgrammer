/******************************************************************************
 *  Class: SalesCommissions
 *  Author: nucleusfox
 *
 *  Sales Commissions
 *  Accepts a line of agent names and 2 matrix of values - revenues and expenses -
 *  ceparated by empty line. Prints their commissions.
 *
 *  Reddit DailyProgrammer - #365 [Intermediate]
 *  https://www.reddit.com/r/dailyprogrammer/comments/8xzwl6/20180711_challenge_365_intermediate_sales/
 *
 *  Example:
 *  $ java SalesCommissions
 *  Frank Jane
 *  Tea 120 145
 *  Coffee 243 265
 *
 *  Tea 130 59
 *  Coffee 143 198
 *
 *  Result:
 *  Frank Jane
 *  6.20 9.49
 ******************************************************************************/
import java.util.*;

public class SalesCommissions {
    public static final double COMMISSION = 0.062;

    public static void printInput(Map<String, String[]> metrics) {
        for (Map.Entry<String, String[]> m : metrics.entrySet()) {
            System.out.print(m.getKey());
            for (String s : m.getValue())
                System.out.print(" " + s);
            System.out.println();
        }
    }

    public static void printIncome(String[] names, double[] commissions) {
        for (String n : names) {
            System.out.print(n + " ");
        }
        System.out.println();

        for (double d : commissions)
            System.out.format("%.2f ", d);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] names  = line.split("[\\s\\t]+");

        line = sc.nextLine();
        Map<String, String[]> revenues = new HashMap<>();
        while(line.length() > 0) {
            String[] tokens = line.split("[\\s\\t]+");
            revenues.put(tokens[0], Arrays.copyOfRange(tokens, 1, tokens.length));
            line = sc.nextLine();
        }
//        System.out.println("Revenues");
//        printInput(revenues);

        line = sc.nextLine();
        Map<String, String[]> expenses = new HashMap<>();
        while(line.length() > 0) {
            String[] tokens = line.split("[\\s\\t]+");
            expenses.put(tokens[0], Arrays.copyOfRange(tokens, 1, tokens.length));
            line = sc.nextLine();
        }
//        System.out.println("Expenses");
//        printInput(expenses);

        double[] income = new double[names.length];
//        int income = 0;
        for (Map.Entry<String, String[]> r : revenues.entrySet()) {
            String[] rev = r.getValue();
            for (int i = 0; i < rev.length; i++) {
                int temp = Integer.parseInt(rev[i]) - (expenses.containsKey(r.getKey()) ? Integer.parseInt(expenses.get(r.getKey())[i]) : 0);
                if (temp > 0) income[i] += temp*COMMISSION;
            }
        }

        printIncome(names, income);
    }
}
