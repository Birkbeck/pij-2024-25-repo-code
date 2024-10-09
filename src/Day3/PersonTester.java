public class PersonTester {
    public static void main(String[] args) {
        Person john = new Person();
        john.name = "John Smith";
        john.age = 35;
        Person mary = new Person();
        mary.name = "Mary Smith";
        mary.age = 32;
        Person student = new Person();
        student.name = "John Smith, Jr.";
        student.age = 5;
        student.parent1 = john;
        student.parent2 = mary;
        System.out.println("TEACHER: How old are you, " + student.name + "?");
        System.out.println("LITTLE JOHN: I am " + student.age + " years old, sir.");
        System.out.println("TEACHER: Who are your parents?");
        System.out.println("LITTLE JOHN: " + student.parent1.name + " and "
                + student.parent2.name + ", sir.");
    }
}
