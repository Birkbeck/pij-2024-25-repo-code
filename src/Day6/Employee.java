public class Employee {
    private long id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalaryInPence() {
        long l = calculateSalary();
        return l;
    }

    private long calculateSalary() {
        // slightly unusual approach to implementing this functionality
        return name.length() + id;
    }

}
