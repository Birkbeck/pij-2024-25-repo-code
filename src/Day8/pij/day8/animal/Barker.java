package pij.day8.animal;

public class Barker {
    public void makeAllDogsBarkTry1(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            Animal nextAnimal = animals[i];
            Dog dog = (Dog) nextAnimal;
            dog.bark();
        }
    }

    public void makeAllDogsBarkTry2(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            Animal nextAnimal = animals[i];
            if (nextAnimal instanceof Dog) {
                Dog dog = (Dog) nextAnimal;
                dog.bark();
            }
        }
    }

    public void makeAllDogsBarkTry3(Animal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            Animal nextAnimal = animals[i];
            if (nextAnimal instanceof Dog dog) {
                dog.bark();
            }
        }
    }
}
