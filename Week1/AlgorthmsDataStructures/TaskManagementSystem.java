package AlgorthmsDataStructures;
import java.util.*;
class Task {
    private String taskId;
    private String taskName;
    private String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task [ID=" + taskId + ", Name=" + taskName + ", Status=" + status + "]";
    }
}
class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class TaskManager {
    private Node head;

    public TaskManager() {
        this.head = null;
    }

    // Add Task
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Task added successfully.");
    }

    // Search Task by ID
    public void searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                System.out.println("Search Result: " + current.task);
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found.");
    }

    // Traverse and Print All Tasks
    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        Node current = head;
        System.out.println("Task List:");
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete Task by ID
    public void deleteTask(String taskId) {
        if (head == null) {
            System.out.println("Task not found.");
            return;
        }

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Task not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Task deleted successfully.");
        }
    }
}
public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean continueManaging = true;

        while (continueManaging) {
            System.out.println("\nTask Management Menu");
            System.out.println("1. Add Task");
            System.out.println("2. Search Task");
            System.out.println("3. Traverse Tasks");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Add Task
                    System.out.print("Enter task ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter task name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter task status: ");
                    String status = scanner.nextLine();
                    Task task = new Task(id, name, status);
                    manager.addTask(task);
                    break;
                case 2:
                    // Search Task
                    System.out.print("Enter task ID to search: ");
                    String searchId = scanner.nextLine();
                    manager.searchTask(searchId);
                    break;
                case 3:
                    // Traverse Tasks
                    manager.traverseTasks();
                    break;
                case 4:
                    // Delete Task
                    System.out.print("Enter task ID to delete: ");
                    String deleteId = scanner.nextLine();
                    manager.deleteTask(deleteId);
                    break;
                case 5:
                    // Exit
                    continueManaging = false;
                    System.out.println("Exiting the management system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
