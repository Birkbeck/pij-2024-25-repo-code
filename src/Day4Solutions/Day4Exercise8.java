import java.util.Scanner;

public class Day4Exercise8 {

    static double computeMoneyAfterYears(double moneyBefore, double interestPercentage, int years) {
        double result = moneyBefore;
        for (int i = 0; i < years; i++) {
            result *= 1 + interestPercentage / 100;
            // directly follows the formula from the exercise; note that
            // "*=" multiplies only _after_ the operations to the right

            // alternatively, compute and add the interest:
            // result += result * interestPercentage / 100;
        }
        return result;
    }

    static int computeYearsForSavingsGoal(double moneyBefore, double interestPercentage, double savingsGoal) {
        int years = 0;
        double currentAmount = moneyBefore;
        while (currentAmount < savingsGoal) {
            // what will happen for an interest percentage of 0?
            currentAmount *= 1 + interestPercentage / 100;
            years++;
        }
        return years;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the initial amount in £: ");
        double initialAmount = scan.nextDouble();
        System.out.print("Please enter the interest rate in %: ");
        double interestPercentage = scan.nextDouble();
        System.out.print("Do you want to enter the number of years? (y/n) ");

        String choice = scan.next(); // reads the next "token", may also be separated by space
        if ("y".equals(choice)) {
            System.out.print("Please enter the number of years: ");
            int years = scan.nextInt();
            double moneyAfter = computeMoneyAfterYears(initialAmount, interestPercentage, years);
            System.out.println("After " + years + " years you will have £" +
                    moneyAfter + ".");
        } else {
            System.out.print("Please enter your savings goal in £: ");
            double savingsGoal = scan.nextDouble();
            int years = computeYearsForSavingsGoal(initialAmount, interestPercentage, savingsGoal);
            System.out.println("Having at least £" + savingsGoal +
                    " will take " + years + " years.");
        }
    }
}
