package todo.model;

public class Task {
    private static long counter = 100;
    private long id;
    private String message;
    private String date; // format: dd/MM/yyyy

    public Task(String message, String date) {
        this.id = ++counter;
        this.message = message;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        // Controlled formatting, no dependency on class name
        return "Task [id=" + id + ", message='" + message + "', date=" + date + "]";
    }
}
