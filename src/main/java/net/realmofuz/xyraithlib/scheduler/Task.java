package net.realmofuz.xyraithlib.scheduler;

public class Task {
    TaskLambda task;
    int delay;
    public int startTime;

    public Task(TaskLambda task) {
        this.task = task;
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
}
