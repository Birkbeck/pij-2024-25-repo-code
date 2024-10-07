public class Day1Exercise11a {
    public static void main(String[] args) {
        int i = 1;
        while (true) {
            int j = 0;
            while (j < i) {
                System.out.print(i);
                j = j + 1;
            }
            System.out.println();
            i = i + 1;
        }
    }
}
