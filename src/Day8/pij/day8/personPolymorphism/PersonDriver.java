package pij.day8.personPolymorphism;

public class PersonDriver {

    public static void greet(Person p) {
        p.makeVerbalStatement("Hello!");
    }

    public static void moveAndGreet(Person child) {
        // move in front of parent
        child.move(10);
        // give the message
        child.makeVerbalStatement("Good morning!");
    }

    public static void main(String[] args) {
        Person alice = new AdultPerson();
        greet(alice);

        KidPerson kid = new KidPerson();
        moveAndGreet(kid); // expects a Person, gets a KidPerson

    }
}
