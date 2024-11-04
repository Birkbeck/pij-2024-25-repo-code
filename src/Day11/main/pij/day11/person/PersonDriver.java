package pij.day11.person;

public class PersonDriver {
    public static void main(String[] args) {
        Person p = new Person("Jane  Doe");
        String initials = p.getInitials();
        System.out.println("Initials: " + initials);
    }
}
