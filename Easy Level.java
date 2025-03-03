import java.util.ArrayList;
import java.util.Scanner;
class Employee {
int id;
String name;
double salary;
public Employee(int id, String name, double salary) {
this.id = id;
this.name = name;
this.salary = salary;
}
public String toString() {
return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
}
}
public class EmployeeManagement {
private static ArrayList<Employee> employees = new ArrayList<>();
private static Scanner scanner = new Scanner(System.in);
public static void main(String[] args) {
    while (true) {
        System.out.println("\n1. Add Employee\n2. Update Employee\n3. Remove Employee\n4.
        Search Employee\n5. Display All\n6. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        switch (choice) {
        case 1 -> addEmployee();
        case 2 -> updateEmployee();
        case 3 -> removeEmployee();
        case 4 -> searchEmployee();
        case 5 -> displayEmployees();
        case 6 -> {
        System.out.println("Exiting...");
        return;
        }
        default -> System.out.println("Invalid choice! Try again.");
        }
        }
        }
        private static void addEmployee() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added successfully.");
        }
        private static void updateEmployee() {
        System.out.print("Enter Employee ID to Update: ");
        int id = scanner.nextInt();
        for (Employee e : employees) {
        if (e.id == id) {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter New Name: ");
        e.name = scanner.nextLine();
        System.out.print("Enter New Salary: ");
        e.salary = scanner.nextDouble();
        System.out.println("Employee updated successfully.");
        return;
        }
        }
        System.out.println("Employee not found!");
        }
        private static void removeEmployee() {
        System.out.print("Enter Employee ID to Remove: ");
        int id = scanner.nextInt();
        employees.removeIf(e -> e.id == id);
        System.out.println("Employee removed successfully.");
        }
        private static void searchEmployee() {
        System.out.print("Enter Employee ID to Search: ");
        int id = scanner.nextInt();
        for (Employee e : employees) {
        if (e.id == id) {
        System.out.println(e);
        return;
        }
        }
        System.out.println("Employee not found!");
        }
        private static void displayEmployees() {
        if (employees.isEmpty()) {
        System.out.println("No employees to display.");
        } else {
        employees.forEach(System.out::println);
        }
        }
        }
