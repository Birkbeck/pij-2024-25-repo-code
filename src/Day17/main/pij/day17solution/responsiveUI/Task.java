package pij.day17solution.responsiveUI;

import java.util.Objects;

/**
 * A task has an id and a duration. It can be run by a Thread.
 */
public class Task implements Runnable {

    /** The Task's id number. */
    private final int id;

    /** The Task's duration (length) in milliseconds. */
    private final long duration;

    /** The TaskTracker to which this Task reports when it has finished. */
    private final TaskTracker tracker;

    /**
     * Initialises a new Task for given task id, duration in milliseconds
     * and TaskTracker to report to.
     *
     * @param id the Task's id
     * @param duration the Task's duration in milliseconds
     * @param tracker the TaskTracker to report to
     * @throws NullPointerException if tracker is null
     */
    public Task(int id, long duration, TaskTracker tracker) {
        this.id = id;
        this.duration = duration;
        this.tracker = Objects.requireNonNull(tracker);
    }

    /**
     * Runs the Task for the duration given at object construction time
     * and reports to the TaskTracker at the end.
     */
    @Override
    public void run() {
        try {
            Thread.sleep(this.duration);
        } catch (InterruptedException e) {
            System.out.println("Task " + this.id + " was woken up too early!");
        }
        this.tracker.addTask(this.id);
    }
}
