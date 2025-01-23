public class ArrayExamples {

    public static void runEmployees() {
        String[] employeeArray;
        employeeArray = new String[5];
        employeeArray[0] = "Alice";
        employeeArray[1] = "Bob";
        employeeArray[2] = "Charlie";
        employeeArray[3] = "Dave";
        employeeArray[4] = "Eve";
        System.out.println("Our first employee is " + employeeArray[0]);
        System.out.println("Our company has " + employeeArray.length + " employees");
        System.out.println("All employees: " + java.util.Arrays.toString(employeeArray));
    }

    public static void runMultiSizeArrays() {
        int[] myArray;
        myArray = new int[5];
        myArray = new int[10];
    }

    public static int sum(int[] numbers) {
        int runningTotal = 0;
        for (int i = 0; i < numbers.length; i++) {
            runningTotal += numbers[i]; // recall: writing  x += y;  adds y to x
        }
        return runningTotal;
    }

    public static void runCurlyInitialisation() {
        int[] employeeIdArray = {123, 55, 14, 642, 243};
        System.out.println(java.util.Arrays.toString(employeeIdArray));
    }

    public static void run2DArrays() {
        int[][] matrix;
        matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;

        int[][] matrix3 = {{1,2,3},{4,5,6},{7,8,9}};

        int[][] matrix3a = { { 1, 2, 3 },
                             { 4, 5, 6 },
                             { 7, 8, 9 } };

        String[][] teams =  { { "Alice", "Bob" },
                              { "Marge", "Homer", "Bart", "Lisa", "Maggie" },
                              { "Wolverine" } };

        System.out.println(java.util.Arrays.toString(matrix3));
        System.out.println(java.util.Arrays.toString(matrix3a));
        System.out.println(java.util.Arrays.toString(teams));
    }
    public static void main(String[] args) {
        runEmployees();
        runMultiSizeArrays();

        int[] nums = { 2, 7, 9, 24 };
        System.out.println(sum(nums));

        runCurlyInitialisation();
        run2DArrays();
    }
}
