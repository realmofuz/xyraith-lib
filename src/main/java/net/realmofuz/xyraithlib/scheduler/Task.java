package net.realmofuz.xyraithlib.scheduler;

import net.realmofuz.xyraithlib.lambdas.TaskLambda;

public class Task {
    TaskLambda task;
    int delay;
    public int startTime;

    public Task(TaskLambda task) {

        this.task = task;
        this.pushToQueue(0);
    }

    public TaskLambda getTaskLambda() {
        return task;
    }

    public int getDelay() {
        return delay;
    }

    public void pushToQueue(int delay) {
        this.delay = delay;
        TaskQueue.pushTask(this);
    }

    public void repeat(int delay) {
        this.delay = delay;
        TaskQueue.pushTask(this);
    }

    public static void pushTask(TaskLambda lambda) {
        new Task(lambda);
    }
}
