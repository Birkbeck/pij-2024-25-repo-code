package pij.day17solution.responsiveUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Tracks the ids of completed tasks. Thread-safe.
 */
public class TaskTracker {

    /** How many tasks are still pending completion? */
    private int pendingTaskCount;

    /**
     * The tasks that have been completed since the last call to
     * getAndResetTasks(). Must not be nor contain null.
     */
    private List<Integer> tasks;

    /**
     * Initialises a new TaskTracker with the information how many tasks
     * are expected to be tracked (which can be useful for knowing when to
     * stop tracking).
     *
     * @param maxTasks how many tasks are expected to be tracked
     */
    public TaskTracker(int maxTasks) {
        this.pendingTaskCount = maxTasks;
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a completed task with a given id to this TaskTracker.
     * Decrements the number of pending tasks.
     *
     * @param id the id of the completed task
     */
    public synchronized void addTask(int id) {
        this.pendingTaskCount--;
        this.tasks.add(id);
    }

    /**
     * Returns a list with the tasks completed since the last call to the
     * method or since object construction. Resets the completed tasks in
     * this TaskTracker.
     *
     * @return a list with the tasks completed since the last call to the
     *  method or since object construction
     */
    public synchronized List<Integer> getAndResetTasks() {
        if (this.tasks.isEmpty()) { // nothing to reset
            return Collections.emptyList();
        }
        List<Integer> result = this.tasks;
        this.tasks = new ArrayList<>();
        return result;
    }

    /**
     * Returns how many tasks are still pending completion,
     * on the basis of the value passed to the constructor.
     *
     * @return how many tasks are still pending completion
     */
    public synchronized int getPendingTaskCount() {
        return this.pendingTaskCount;
    }
}
