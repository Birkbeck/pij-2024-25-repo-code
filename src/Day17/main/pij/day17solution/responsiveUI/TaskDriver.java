package pij.day17solution.responsiveUI;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Driver class for the "Responsive UI" exercise on Day 16.
 * Reads durations of 10 tasks from the user and reports whenever
 * a task has finished, without interrupting the data entry.
 */
public class TaskDriver {

    /**
     * Sleep duration during the final polling phase after all user input
     * has been read.
     */
    private static final int SLEEP_MILLIS = 100;

    /**
     * Maximum number of tasks to launch.
     */
    private static final int MAX_TASKS = 10;

    /**
     * @param args ignored
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TaskTracker tracker = new TaskTracker(MAX_TASKS);
        Thread[] threads = new Thread[MAX_TASKS];
        for (int i = 0; i < MAX_TASKS; i++) {
            System.out.print("Enter the duration (in ms) of task " + i + ": ");
            long duration = scan.nextLong();
            printTrackerData(tracker);
            Thread t = new Thread(new Task(i, duration, tracker));
            threads[i] = t;
            t.start();
        }
        // now there may still be threads running...
        while (tracker.getPendingTaskCount() > 0) {
            try {
                // use regular polling here
                Thread.sleep(SLEEP_MILLIS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            printTrackerData(tracker);
        }
    }

    /**
     * Prints a message about finished tasks (if any).
     *
     * @param tracker has the information about the tasks that have finished
     *                in the meantime and should be printed
     * @throws NullPointerException if tracker is null
     */
    private static void printTrackerData(TaskTracker tracker) {
        List<Integer> done = tracker.getAndResetTasks();
        if (! done.isEmpty()) {
            // get some practice with the streams
            String doneString = done.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            // or:
            // String doneString = done.toString();
            // doneString = doneString.substring(1, doneString.length() - 1);
            // or: use a for loop over done, omitting one comma
            System.out.println("Finished tasks: " + doneString);
        }
    }
}
