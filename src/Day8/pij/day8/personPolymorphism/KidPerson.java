package pij.day8.personPolymorphism;

public class KidPerson implements Person {
    @Override
    public void move(int distance) {
        System.out.println("KidPerson moving by" + distance + "...");
    }

    @Override
    public void makeVerbalStatement(String message) {
        System.out.println("KidPerson says: \"" + message + "\"");
    }
}
