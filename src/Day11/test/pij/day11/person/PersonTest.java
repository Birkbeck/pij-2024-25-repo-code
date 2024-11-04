package pij.day11.person;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

/**
 * JUnit 5 test class for class Person in the same package.
 */
public class PersonTest {

    /** Internal timeout for some of our tests. */
    private static final int TEST_DURATION_MILLIS = 1000;

    /** Helper method shared by some tests to create Person object. */
    private static Person makeDerekRobertYeast() { // NOT labelled with @Test!
        String input = "Derek Robert Yeast";
        return new Person(input);
    }

    @Test   // annotation that flags method as JUnit test case
    public void testGetInitials_NormalName() {
        Person p = makeDerekRobertYeast();
        String actual = p.getInitials();
        String expected = "DRY";
        assertEquals(expected, actual); // expected BEFORE actual
    }

    @Test
    public void testGetInitials_OneWordName() {
        String input = "Shakira";
        Person p = new Person(input);
        String actual = p.getInitials();
        String expected = "S";
        assertEquals(expected, actual,  // expected BEFORE actual
                "three-word name, single space separator");
    }

    @Test
    public void testGetInitials_TwoWordName() {
        String input = "Taylor Swift";
        Person p = new Person(input);
        String actual = p.getInitials();
        String expected = "TS";
        assertEquals(expected, actual,  // expected BEFORE actual
                "three-word name, single space separator");
    }

    @Test
    public void testGetInitials_ThreeWordName() {
        String input = "Grace Brewster Hopper";
        Person p = new Person(input);
        String actual = p.getInitials();
        String expected = "GBH";
        assertEquals(expected, actual,  // expected BEFORE actual
                "three-word name, single space separator");
    }

    @Test
    public void testThatFinishedBeforeOneSecond() {
        assertTimeout(Duration.ofMillis(TEST_DURATION_MILLIS),
                () -> { // lambda expression
                    Person p = makeDerekRobertYeast();
                    p.getInitials();
                });
    }// assertTimeout runs the production code until the end

    @Test
    public void testThatFinishedBeforeOneSecond2() {
        assertTimeoutPreemptively(Duration.ofMillis(TEST_DURATION_MILLIS),
                () -> { // lambda expression
                    Person p = makeDerekRobertYeast();
                    p.getInitials();
                });
    } // assertTimeoutPreemptively runs the production code but
    // terminates it after the timeout if it has not finished

    @Test
    public void testIllegalNullArgumentForConstructor() {
        assertThrows(NullPointerException.class,
                () -> {
                    String input = null;
                    Person p = new Person(input);
                    // null should lead to NPE
                });
    }
}
