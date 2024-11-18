package pij.day16.stream;

import java.util.List;

public class SimplePersonDriver {
    public static void main(String[] args) {
        List<Person> persons = List.of(
                new SimplePerson("Alice", 20),
                new SimplePerson("Bob", 15),
                new SimplePerson("Carol", 42));
        long count = PersonHelper.getAdultCount(persons);
        List<String> adults = PersonHelper.getAdultNames(persons);
        System.out.println("There are " + count + " adults: " + adults);
        System.out.println("Printing them one per line:");
        PersonHelper.printAdultNames(persons);
    }
}
