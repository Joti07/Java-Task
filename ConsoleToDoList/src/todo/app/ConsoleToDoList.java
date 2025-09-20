package todo.app;
import todo.service.TaskManager;
import java.util.Scanner;

public class ConsoleToDoList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        System.out.println("=== Welcome to Console To-Do List ===");
        System.out.println("Commands: a (add), v<id>, v<date>, d<id>, exit");

        while (true) {
            System.out.print("\nEnter command: ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting To-Do List. Goodbye!");
                break;
            }

            if (input.equals("a")) {
                System.out.print("Message: ");
                String message = sc.nextLine();
                System.out.print("Date (dd/MM/yyyy): ");
                String date = sc.nextLine();
                manager.addTask(message, date);

            } else if (input.startsWith("v")) {
                String param = input.substring(1);
                if (param.matches("\\d+")) {
                    manager.viewTaskById(Long.parseLong(param));
                } else {
                    manager.viewTaskByDate(param);
                }

            } else if (input.startsWith("d")) {
                String param = input.substring(1);
                if (param.matches("\\d+")) {
                    manager.deleteTask(Long.parseLong(param));
                } else {
                    System.out.println("Invalid delete command.");
                }

            } else {
                System.out.println("Invalid command.");
            }
        }

        sc.close();
    }
}