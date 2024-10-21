package pij.day7.animals;

public class Dog extends LandAnimal {

    // no explicit constructor -- implicitly calls super()

    @Override
    public void move(int metres) {
        System.out.println("Walking " + metres + "...");
    }

    @Override
    public String makeSound() {
        return "Woof!";
    }
}
