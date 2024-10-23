package pij.day8.owlPolymorphism;

public class OwlMain {
    public static void main(String[] args) {
        Bird b = new Bird();
        Owl o = new Owl();
        Bird owlAsBird = o;

        Bird.print();
        Owl.print();

        // you can call static methods also via object references
        // (calling them via the class name is clearer)
        b.print();
        o.print();
        owlAsBird.print();
    }
}
