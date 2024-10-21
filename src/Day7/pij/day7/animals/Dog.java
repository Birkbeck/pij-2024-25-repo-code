package pij.day7.animals;

/**
 * A Dog is a LandAnimal that walks and that makes a "Woof!" sound.
 */
public class Dog extends LandAnimal {

    // final because we are not allowing for renaming;
    // with the 'final' modifier, the compiler can check this for ys
    public final String name;

    /**
     * Initialises the new Dog with the given name.
     *
     * @param name the Dog's name
     */
    public Dog(String name) {
        // implicitly calls super(); if we wanted to call a different
        // superclass constructor, we would have to do this explicitly here
        this.name = name;
    }
    @Override
    public void move(int metres) {
        System.out.println("Walking " + metres + "...");
    }

    @Override
    public String makeSound() {
        return "Woof!";
    }
}
