package pij.day16.map;

public class MyMathDriver {
    public static void main(String[] args) {
        int[] myData = { 5, 6, 7, 8 };
        int[] myFactorials1 = ArrayMapper.map(n -> MyMath.factorial(n), myData);
        int[] myFactorials2 = ArrayMapper.map(MyMath::factorial, myData);

        System.out.println(java.util.Arrays.toString(myData));
        System.out.println(java.util.Arrays.toString(myFactorials1));
        System.out.println(java.util.Arrays.toString(myFactorials2));

    }
}
