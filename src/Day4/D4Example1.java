public class D4Example1 {
    static void add1000(int number) {
        System.out.println("Starting method, parameter is " + number);
        number = number + 500;
        System.out.println("In the middle of method, parameter is " + number);
        number = number + 500;
        System.out.println("Ending method, parameter is " + number);
    }

    // program execution starts here
    public static void main(String[] args) {
        int myNumber = 0;
        System.out.println("Starting program, my number is " + myNumber);
        add1000(myNumber);  // method call
        System.out.println("After the method is used, my number is " + myNumber);
    }
}
