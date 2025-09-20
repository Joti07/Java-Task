package todo.service;

import todo.model.Task;

import java.util.*;

public class TaskManager {
    private Set<Task> taskSet = new HashSet<>();
    private Map<Long, Task> taskById = new HashMap<>();
    private Map<String, List<Task>> taskByDate = new HashMap<>();

    // Add todo.model.Task
    public void addTask(String message, String date) {
        Task task = new Task(message, date);
        taskSet.add(task);
        taskById.put(task.getId(), task);

        taskByDate.putIfAbsent(date, new ArrayList<>());
        taskByDate.get(date).add(task);

        System.out.println("Task added successfully!");
        showAllTasks();
    }

    // View by id
    public void viewTaskById(long id) {
        Task task = taskById.get(id);
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    // View by date
    public void viewTaskByDate(String date) {
        List<Task> tasks = taskByDate.get(date);
        if (tasks != null && !tasks.isEmpty()) {
            for (Task t : tasks) {
                System.out.println(t);
            }
        } else {
            System.out.println("No tasks found on " + date);
        }
    }

    // Delete by id
    public void deleteTask(long id) {
        Task task = taskById.remove(id);
        if (task != null) {
            taskSet.remove(task);
            taskByDate.get(task.getDate()).remove(task);
            System.out.println("Task deleted successfully!");
        } else {
            System.out.println(" Task with ID " + id + " not found.");
        }
        showAllTasks();
    }

    // Show all tasks
    public void showAllTasks() {
        if (taskSet.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("All Tasks:");
        for (Task task : taskSet) {
            System.out.println(task);
        }
    }
}
