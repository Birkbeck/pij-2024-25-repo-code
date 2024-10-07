public class S2Example4 {
    public static void main(String[] args) {
        String s = "artificial reality";
        System.out.println(s.substring(11,15) + " " + s.substring(0,3));
        int length = s.substring(11).length();
        System.out.println(length);
    }
}
