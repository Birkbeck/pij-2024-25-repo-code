public class S2Example3 {
    public static void main(String[] args) {
        String s = "software services";
        s = s.substring(0,4) + s.substring(8,9) + s.substring(13);
        System.out.println(s);
    }
}
