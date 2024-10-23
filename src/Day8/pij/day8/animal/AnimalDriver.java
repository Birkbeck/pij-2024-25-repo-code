package pij.day8.animal;

public class AnimalDriver {

    public static void main(String[] args) {
        Barker b = new Barker();
        Animal[] a1 = { new Dog(), new Dog(), new Dog() };
        b.makeAllDogsBarkTry1(a1);
        b.makeAllDogsBarkTry2(a1);
        b.makeAllDogsBarkTry3(a1);
        /*
        // uncomment and see what happens!
        Animal[] a2 = { new Dog(), new Cat(), null };
        b.makeAllDogsBarkTry1(a2);
        b.makeAllDogsBarkTry2(a2);
        b.makeAllDogsBarkTry3(a2);
        */
    }
}
