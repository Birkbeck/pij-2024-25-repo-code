package pij.day16.examResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper methods for exercises with exam results.
 */
public class ExamResultHelper {

    /**
     * Helper method to generate random numbers in a given range.
     *
     * @param max bound for generation of random integer numbers
     * @return a random integer in the range 0..max if max is positive
     *  and max..0 otherwise
     */
    public static int getRandom(int max) {
        return (int) (Math.round(Math.random() * max));
    }

    /**
     * @return a list with very many ExamResult objects for a fixed module and
     *  a bounded pool of student names
     */
    public static List<ExamResult> makeLargeTestData() {
        final int SIZE = 100000000;
        final int MAX_MARK = ExamResult.MAX_EXAM_MARK;
        final int MAX_NAME_SUFFIX = 400;
        final String NAME_PREFIX = "Student";
        final String MODULE = "PiJ";
        List<ExamResult> result = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            int randomMark = getRandom(MAX_MARK);
            int randomSuffix = getRandom(MAX_NAME_SUFFIX);
            ExamResult examResult = new ExamResult(NAME_PREFIX + randomSuffix,
                    MODULE, randomMark);
            result.add(examResult);
        }
        return result;
    }

    /**
     * Returns a list of ExamResult objects for testing,
     * as provided on the worksheet.
     *
     * @return a list of ExamResult objects for testing
     */
    public static List<ExamResult> makeTestData() {
        return List.of(
                new ExamResult("Harry", "FoC", 46),
                new ExamResult("Sally", "FoC", 82),
                new ExamResult("Sally", "PiJ", 76),
                new ExamResult("Alice", "PiJ", 80),
                new ExamResult("Bob", "PiJ", 68),
                new ExamResult("Bob", "FoC", 58)
        );
    }
}
