package pij.day16solution.examResult;

import pij.day16.examResult.ExamResult;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Utility class with several methods to retrieve information about given
 * Collections of ExamResult objects.
 */
public class ExamResultUtils {

    /**
     * Returns a list of the student names occurring in the given Collection
     * of ExamResult objects. The list is sorted by the natural order of String
     * and has only distinct entries.
     * Implementation note: Implementation using the stream() method
     * of the Collection is intended.
     *
     * @param results the Collection of ExamResult objects to analyse
     * @return a sorted list of all distinct student names occurring in the
     *  given Collection of ExamResult objects
     * @throws NullPointerException if results is null or contains null
     */
    public static List<String> getStudents(Collection<? extends ExamResult> results) {
        return results.stream()
                .map(ExamResult::getStudentName)
                .distinct()
                //.sorted((x,y) -> x.length() - y.length())
                //.sorted(Comparator.reverseOrder())
                .sorted()
                .toList();
    }

    /**
     * Returns a list of the student names occurring in the given Collection
     * of ExamResult objects who have taken the given exam. The list is sorted
     * by the natural order of String and has only distinct entries.
     *
     * @param results the Collection of ExamResult objects to analyse
     * @param exam the exam for which we want to retrieve the students
     * @return a sorted list of all distinct student names occurring in the
     *  given Collection of ExamResult objects who have taken the given exam
     * @throws NullPointerException if results is null or contains null,
     *  or if exam is null
     */
    public static List<String>
            getStudentsOnExam(Collection<? extends ExamResult> results, String exam) {
        return results.stream()
                .filter(r -> r.getExamName().equals(exam))
                .map(ExamResult::getStudentName)
                .distinct()
                .sorted()
                .toList();
    }

    /**
     * Returns a map from exam names occurring in results to corresponding non-empty
     * lists of all ExamResult objects in results that contain the given exam name.
     *
     * @param results the Collection of ExamResult objects to analyse
     * @return a map from exam names occurring in results to corresponding non-empty
     *  lists of all ExamResult objects in results that contain the given exam name
     * @throws NullPointerException if results is null or contains null
     */
    public static Map<String, List<ExamResult>> groupByExams(Collection<? extends ExamResult> results) {
        return results.stream()
                .collect(Collectors.groupingBy(ExamResult::getExamName));
    }

    /**
     * Returns a map from classifications with at least one corresponding
     * ExamResult occurrence in results for the given exam to lists with
     * all corresponding such occurrences of ExamResult objects in results;
     * classifications that are not represented in results for the given
     * exam are not part of the returned map.
     *
     * @param results the Collection of ExamResult objects to analyse
     * @param exam the exam for which we want to retrieve the results
     * @return a map from classifications with at least one corresponding
     *  ExamResult occurrence in results for the given exam to lists with
     *  all corresponding such occurrences of ExamResult objects in results;
     *  classifications that are not represented in results for the given
     *  exam are not part of the returned map
     */
    public static Map<ExamResult.Classification, List<ExamResult>>
                classificationsToResults(Collection<? extends ExamResult> results, String exam) {
        return results.stream()
                .filter(r -> r.getExamName().equals(exam))
                .collect(Collectors.groupingBy(r -> ExamResult.Classification.fromMarks(r.getMarks())));
    }

    /**
     * Returns a map from all classifications to a list of all ExamResult
     * objects for the given exam with this classification in results.
     *
     * @param results the Collection of ExamResult objects to analyse
     * @param exam the exam for which we want to retrieve the results
     * @return a map from all classifications to a list of all ExamResult
     *  objects for the given exam with this classification in results
     */
    public static Map<ExamResult.Classification, List<ExamResult>>
                allClassificationsToResults(Collection<? extends ExamResult> results, String exam) {
        return Arrays // we need a Stream<ExamResult.Classification> of all keys for our new map ...
                .stream(ExamResult.Classification.values())
                // ... and now we need to find the values to make a
                // Map<ExamResult.Classification, List<ExamResult>>
                .collect(Collectors
                        .toMap(Function.identity(), // or: c -> c (no change for the keys)
                                // extract the list with the value list for the key
                                // via a separate stream pipeline
                                c -> results.stream()
                                        .filter(r -> r.getExamName().equals(exam) &&
                                                c == ExamResult.Classification.fromMarks(r.getMarks()))
                                        // .toList() would lead to type problems due to the wildcard
                                        // in the type Stream<? extends ExamResult>
                                        .collect(Collectors.toList())));
    }

    /**
     * Returns a list of the student names occurring in the given Collection
     * of ExamResult objects. The list is sorted by the natural order of String
     * and has only distinct entries.
     * Implementation note: Implementation using the parallelStream() method
     * of the Collection is intended.
     *
     * @param results the Collection of ExamResult objects to analyse
     * @return a list of the student names occurring in the given Collection
     *  of ExamResult objects
     * @throws NullPointerException if results is null or contains null
     */
    public static List<String> getStudentsParallel(Collection<? extends ExamResult> results) {
        return results.parallelStream()
                .map(ExamResult::getStudentName)
                .distinct()
                //.sorted((x,y) -> x.length() - y.length())
                //.sorted(Comparator.reverseOrder())
                .sorted()
                .toList();
    }
}
