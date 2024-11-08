package pij.day14.employee;

import java.util.Objects;

/**
 * An Employee has a name and a line manager. An Employee who has no other
 * Employee as a line manager is the CEO of the company.
 */
public class Employee {

    /** the Employee's name; non-null */
    private final String name;

    /** the Employee's direct manager; null means none */
    private final Employee lineManager;

    /**
     * Initialises a new Employee with a name and a line manager.
     *
     * @param name this Employee's name
     * @param lineManager this Employee's line manager; null means none
     * @throws NullPointerException if name is null
     */
    public Employee(String name, Employee lineManager) {
        this.name = Objects.requireNonNull(name);
        this.lineManager = lineManager;
    }

    /**
     * Initialises an Employee with a name who has no line manager
     * (i.e., they are the CEO of the company).
     *
     * @param name this Employee's name
     * @throws NullPointerException if name is null
     */
    public Employee(String name) {  // constructor for the CEO
        this(name, null);  // the CEO has no line manager
    }

    /**
     * Returns this Employee's line manager.
     *
     * @return this Employee's line manager
     */
    public Employee getLineManager() {
        return this.lineManager;
    }

    /**
     * Returns the CEO of this Employee's company. Uses recursion.
     *
     * @return the CEO of this Employee's company
     */
    public Employee getCEORecursively() {
        if (this.lineManager == null) {
            return this;
        }
        return this.lineManager.getCEORecursively();
    }

    /**
     * Returns the CEO of this Employee's company.
     * Uses loops instead of recursion.
     *
     * @return the CEO of this Employee's company
     */
    public Employee getCEOIteratively() {
        Employee boss = this;
        while (boss.lineManager != null) {
            boss = boss.lineManager;
        }
        return boss;
    }

    @Override
    public String toString() {
        if (this.lineManager == null) {
            return "Employee " + this.name + ", CEO";
        }
        return "Employee " + this.name + " with line manager " + this.lineManager;
    }
}
