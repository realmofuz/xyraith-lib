package net.realmofuz.xyraithlib.scheduler;

@FunctionalInterface
public interface TaskLambda {
    void run(Task task);
}
