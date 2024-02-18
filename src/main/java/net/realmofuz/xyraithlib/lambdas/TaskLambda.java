package net.realmofuz.xyraithlib.lambdas;

import net.realmofuz.xyraithlib.scheduler.Task;

@FunctionalInterface
public interface TaskLambda {
    void run(Task task);
}
