public class Integer2 {
    int value;

    int getValue() {
        return this.value;
    }

    void setValue(int value) {
        this.value = value;
    }

    boolean isEven() {
        return this.value % 2 == 0;
    }

    boolean isOdd() {
        return ! isEven();
    }

    void prettyPrint() {
        System.out.println(this.value);
    }

    String asString() {
        return "" + this.value;
    }
}
