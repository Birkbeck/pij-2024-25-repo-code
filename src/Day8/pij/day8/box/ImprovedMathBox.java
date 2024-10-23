package pij.day8.box;

/**
 * An ImprovedMathBox stores a reference to a number and allows us to retrieve
 * the number and to calculate its square root. In contrast to a MathBox, an
 * ImprovedMathBox avoids code duplication from class Box by extending class
 * Box -- also conceptually, every ImprovedMathBox is a Box.
 *
 * @param <T> type of the data stored in this MathBox, a subtype of Number
 *           so that T has instance method doubleValue()
 */
public class ImprovedMathBox<T extends Number> extends Box<T> {

    /**
     * Constructs a Box<T> that stores the given reference.
     *
     * @param data the reference to store
     */
    public ImprovedMathBox(T data) {
        super(data);
    }

    /**
     * Returns the square root of the encapsulated number.
     *
     * @return the square root of the encapsulated number
     */
    public double sqrt() {
        Number data = this.getData();
        double val = data.doubleValue();
        return Math.sqrt(val);
    }
}
