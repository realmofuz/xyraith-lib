package net.realmofuz.xyraithlib.scheduler;

import java.util.ArrayList;
import java.util.List;

public class TaskQueue {
    public static List<Task> tasks = new ArrayList<Task>();
    public static int time = 0;

    public static void attemptTasks() {
        time++;
        System.out.println("Attempting tasks _" + tasks + "_");
        for(Task task : tasks) {
            System.out.println("Task: " + task);
            System.out.println(task.startTime + " | " + task.delay + " | " + time);
            if(time >= task.startTime+task.delay) {
                task.getTaskLambda().run(task);
                tasks.remove(task);
            }
        }
    }

    public static void clearTasks() {
        tasks.clear();
    }
    public static void pushTask(Task task) {
        task.startTime = time;
        tasks.add(task);
    }

    public static void pushTask(TaskLambda lambda) {
        var task = new Task(lambda);
        pushTask(task);
    }

}
