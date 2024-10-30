package pij.day10;

/**
 * An unchecked / runtime exception: indicates a programming error,
 * should /not/ be caught.
 */
public class BarException extends RuntimeException {
    public BarException() {
        super();
    }
    public BarException(String message) {
        super(message);
    }
    public BarException(Throwable cause) {
        super(cause);
    }
}
