package pij.day8.personPolymorphism;

public class AdultPerson implements Person {
    @Override
    public void move(int distance) {
        System.out.println("AdultPerson moving by" + distance + "...");
    }

    @Override
    public void makeVerbalStatement(String message) {
        System.out.println("AdultPerson says: \"" + message + "\"");
    }
}
