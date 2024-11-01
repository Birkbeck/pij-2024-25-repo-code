package pij.day11.person;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit 5 test class for class Person in the same package.
 */
public class PersonTest {

    @Test
    public void testGetInitials_NormalName() {
        String input = "Derek Robert Yeast";
        Person p = new Person(input);
        String actual = p.getInitials();
        String expected = "DRY";
        assertEquals(expected, actual);
    }
    // In a "real" testing class, there are usually more methods here,
    // each of them annotated with/ the annotation @Test, each of them
    // testing a different aspect of the code
}
