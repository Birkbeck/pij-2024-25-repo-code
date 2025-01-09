/**
 * Write a Java interface called Measurable that specifies a method
 * called getMeasure() that returns a double value as the “measure”
 * of an object.
 *
 * Document your code using JavaDoc comments as good practice (also
 * in all future programming exercises).
 * -------
 * Defines a method getMeasure() returning a double.
 * The notion of "measure" will depend on the class.
 */
public interface Measurable {
    /**
     * Returns the measure of the object, defined in a class-specific way.
     *
     * @return the measure of the object, defined in a class-specific way
     */
    double getMeasure();
}
