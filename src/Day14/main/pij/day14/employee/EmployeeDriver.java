package pij.day14.employee;

/**
 * Driver class for class Employee.
 */
public class EmployeeDriver {
    public static void main(String[] args) {
        Employee erica = new Employee("Erica"); // Erica is the CEO
        Employee derek = new Employee("Derek", erica);
        Employee celia = new Employee("Celia", derek);
        Employee colin = new Employee("Colin", derek);
        Employee barry = new Employee("Barry", celia); // Barry and Betsy both have
        Employee betsy = new Employee("Betsy", celia); // Celia as their line manager

        System.out.println("Betsy answers, recursively: " + betsy.getCEORecursively());
        System.out.println("Betsy answers, iteratively: " + betsy.getCEOIteratively());

        System.out.println("Barry answers, recursively: " + barry.getCEORecursively());
        System.out.println("Barry answers, iteratively: " + barry.getCEOIteratively());

        System.out.println("Celia answers, recursively: " + celia.getCEORecursively());
        System.out.println("Celia answers, iteratively: " + celia.getCEOIteratively());
    }
}
