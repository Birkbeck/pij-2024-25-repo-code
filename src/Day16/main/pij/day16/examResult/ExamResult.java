package pij.day16.examResult;

import java.util.Objects;

/**
 * Represents the marks a student was awarded in an exam.
 */
public class ExamResult {

    /** The minimum mark that can be obtained in an exam. */
    public static final int MIN_EXAM_MARK = 0;

    /** The maximum mark that can be obtained in an exam. */
    public static final int MAX_EXAM_MARK = 100;

    /**
     * Represents the postgraduate degree classification to which given
     * marks correspond.
     */
    public enum Classification {
        FAIL, PASS, MERIT, DISTINCTION;

        /** The minimum mark for a PASS classification. */
        private static final int MIN_PASS_MARK = 50;

        /** The minimum mark for a MERIT classification. */
        private static final int MIN_MERIT_MARK = 60;

        /** The minimum mark for a DISTINCTION classification. */
        private static final int MIN_DISTINCTION_MARK = 70;

        /**
         * Returns the classification corresponding to the given marks.
         *
         * @param marks the marks that a student has got in a postgraduate exam
         * @return the classification corresponding to the given marks
         * @throws IllegalArgumentException if marks is less than MIN_EXAM_MARK
         *  or greater than MAX_EXAM_MARK
         */
        public static Classification fromMarks(int marks) {
            if (marks < MIN_EXAM_MARK || marks > MAX_EXAM_MARK) {
                throw new IllegalArgumentException("marks must be at least "
                        + MIN_EXAM_MARK + " and at most " + MAX_EXAM_MARK
                        + ", found: " + marks);
            }
            if (marks < MIN_PASS_MARK) {
                return FAIL;
            }
            if (marks < MIN_MERIT_MARK) {
                return PASS;
            }
            if (marks < MIN_DISTINCTION_MARK) {
                return MERIT;
            }
            return DISTINCTION;
        }
    }

    /** The name of the student who took the exam. Never null. */
    private final String studentName;

    /** The name of the module to which the exam belongs. Never null. */
    private final String examName;

    /**
     * The number of marks obtained by the student in the exam.
     * At least MIN_EXAM_MARK, at most MAX_EXAM_MARK.
     */
    private final int marks;

    /**
     * Initialises a new ExamResult according to the parameter values.
     *
     * @param studentName the name of the student who took the exam
     * @param examName the name of the module to which the exam belongs
     * @param marks the marks obtained in the exam by the student
     * @throws NullPointerException if studentName or examName is null
     * @throws IllegalArgumentException if marks is not at least MIN_EXAM_MARK
     *                                  and at most MAX_EXAM_MARK
     */
    public ExamResult(String studentName, String examName, int marks) {
        this.studentName = Objects.requireNonNull(studentName);
        this.examName = Objects.requireNonNull(examName);
        if (marks < MIN_EXAM_MARK || marks > MAX_EXAM_MARK) {
            throw new IllegalArgumentException("marks: Illegal value " + marks
                    + "! Allowed values are at least " + MIN_EXAM_MARK
                    + " and at most " + MAX_EXAM_MARK + ".");
        }
        this.marks = marks;
    }

    /* ... documentation comments for getters omitted ... */

    public String getStudentName() {
        return this.studentName;
    }

    public String getExamName() {
        return this.examName;
    }

    public int getMarks() {
        return this.marks;
    }

    @Override
    public String toString() {
        return "(" + this.studentName + "," + this.examName + "," + this.marks + ")";
    }
}
