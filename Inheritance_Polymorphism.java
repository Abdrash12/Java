// 1. Define the Superclass (Parent Class)
class Employee {
    // Fields common to all employees
    protected String name;
    protected double baseSalary;

    // Constructor for Employee
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Method common to all employees
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
    }

    // Method that might be overridden later
    public double calculateTotalPay() {
        return baseSalary; // Default pay is just base salary
    }
}

// 2. Define the Subclass (Child Class) using 'extends'
class Manager extends Employee { 
    // Additional field specific to Manager
    private double bonus;

    // Constructor for Manager
    public Manager(String name, double baseSalary, double bonus) {
        // 'super()' calls the Employee constructor to set name and baseSalary
        super(name, baseSalary);
        this.bonus = bonus; // Set the Manager-specific field
    }

    // Override the calculateTotalPay method for Manager
    @Override
    public double calculateTotalPay() {
        // Manager's pay includes bonus
        return baseSalary + bonus; 
    }

    // Add a method specific to Manager
    public void conductMeeting() {
        System.out.println(name + " is conducting a meeting.");
    }
}

// 3. Use the classes
public class Inheritance_Polymorphism {
    public static void main(String[] args) {
        // --- Case 1: Standard Object Creation ---
        System.out.println("--- Employee Info ---");
        Employee emp1 = new Employee("Alice", 50000);
        emp1.displayInfo(); // Fixed the "77" syntax error here
        System.out.println("Total Pay: $" + emp1.calculateTotalPay());

        System.out.println("\n--- Manager Info ---");
        Manager mgr1 = new Manager("Bob", 70000, 10000);
        mgr1.displayInfo();       // Inherited method
        mgr1.conductMeeting();    // Manager-specific method
        System.out.println("Total Pay: $" + mgr1.calculateTotalPay()); // Overridden method

        // --- Case 2: Polymorphism Demonstration ---
        System.out.println("\n--- Polymorphism Demo ---");
        
        // Upcasting: Parent reference holding a Child object
        Employee polyEmp = new Manager("Charlie", 60000, 5000);
        
        // This calls the Employee's displayInfo (inherited by Manager)
        polyEmp.displayInfo(); 
        
      
        System.out.println("Total Pay (Polymorphic): $" + polyEmp.calculateTotalPay());
        
    