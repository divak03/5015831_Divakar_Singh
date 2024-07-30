package AlgorthmsDataStructures;

import java.util.Scanner;

class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + employeeId + ", Name=" + name + ", Position=" + position + ", Salary=" + salary + "]";
    }
}
class EmployeeManager {
    private Employee[] employees;
    private int size;

    public EmployeeManager(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add Employee
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    // Search Employee by ID
    public void searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                System.out.println("Search Result: " + employees[i]);
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Traverse and Print All Employees
    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees to display.");
            return;
        }
        System.out.println("Employee List:");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete Employee by ID
    public void deleteEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                // Shift elements to the left
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null; // Nullify the last element
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(10);
        Scanner scanner = new Scanner(System.in);
        boolean continueManaging = true;

        while (continueManaging) {
            System.out.println("\nEmployee Management Menu");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Traverse Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Add Employee
                    System.out.print("Enter employee ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    Employee employee = new Employee(id, name, position, salary);
                    manager.addEmployee(employee);
                    break;
                case 2:
                    // Search Employee
                    System.out.print("Enter employee ID to search: ");
                    String searchId = scanner.nextLine();
                    manager.searchEmployee(searchId);
                    break;
                case 3:
                    // Traverse Employees
                    manager.traverseEmployees();
                    break;
                case 4:
                    // Delete Employee
                    System.out.print("Enter employee ID to delete: ");
                    String deleteId = scanner.nextLine();
                    manager.deleteEmployee(deleteId);
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

