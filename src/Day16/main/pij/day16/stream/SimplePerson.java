package pij.day16.stream;

import java.util.Objects;

public class SimplePerson implements Person {

    private final String name;
    private final int age;

    public SimplePerson(String name, int age) {
        this.name = Objects.requireNonNull(name);
        this.age = age;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }
}
