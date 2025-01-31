package pij.day16solution.examResult;

import pij.day16.examResult.ExamResult;

import java.util.List;

import static pij.day16.examResult.ExamResultHelper.makeLargeTestData;
import static pij.day16.examResult.ExamResultHelper.makeTestData;
import static pij.day16solution.examResult.ExamResultUtils.allClassificationsToResults;
import static pij.day16solution.examResult.ExamResultUtils.classificationsToResults;
import static pij.day16solution.examResult.ExamResultUtils.getStudents;
import static pij.day16solution.examResult.ExamResultUtils.getStudentsOnExam;
import static pij.day16solution.examResult.ExamResultUtils.getStudentsParallel;
import static pij.day16solution.examResult.ExamResultUtils.groupByExams;

/**
 * Driver class for queries related to exam results.
 */
public class ExamResultDriver {

    /**
     * Runs a query on "large" test data, parameterised by whether
     * sequential or parallel streams should be used. Prints on the
     * screen how many milliseconds the computation took.
     *
     * @param parallel true: use method getStudentsParallel,
     *                 false: use method getStudents
     */
    public static void runLarge(boolean parallel) {
        List<ExamResult> largeTestData = makeLargeTestData();
        long startTime = System.nanoTime();
        // use System.nanoTime() to measure time before and after the
        // method call, then compare
        List<String> results;
        if (parallel) {
            results = getStudentsParallel(largeTestData);
        } else {
            results = getStudents(largeTestData);
        }
        long finishTime = System.nanoTime();
        long totalTime = finishTime - startTime;
        System.out.println("Total time (ms): " + totalTime / 1000000);
    }

    /**
     * Tests several methods related to collections of exam results.
     *
     * @param args Ignored.
     */
    public static void main(String[] args) {
        System.out.println("getStudents: " + getStudents(makeTestData()));
        System.out.println("getStudentsOnExam: "
                + getStudentsOnExam(makeTestData(), "PiJ"));
        System.out.println("groupByExams: " + groupByExams(makeTestData()));
        System.out.println("classificationToResults: "
                + classificationsToResults(makeTestData(), "PiJ"));
        System.out.println("allClassificationsToResults: "
                + allClassificationsToResults(makeTestData(), "PiJ"));

        System.out.println("getStudentsParallel: " + getStudentsParallel(makeTestData()));

        final boolean PARALLEL_FOR_LARGE = true;
        runLarge(PARALLEL_FOR_LARGE);
    }
}
