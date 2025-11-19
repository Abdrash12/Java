package Structural_Patterns;
// 1. The Implementor Interface

// This defines the interface for implementation classes (The "How").
interface Workshop {
    void work();
}

// 2. Concrete Implementors
// Specific implementations of the Workshop interface.

class Produce implements Workshop {
    @Override
    public void work() {
        System.out.print("Produced.");
    }
}

class Assemble implements Workshop {
    @Override
    public void work() {
        System.out.print("Assembled.");
    }
}

// 3. The Abstraction
// This is the high-level control layer. It holds a reference (The Bridge)
// to the Implementor.
abstract class Vehicle {
    // THE BRIDGE: Composition over inheritance
    protected Workshop workshop;

    protected Vehicle(Workshop workshop) {
        this.workshop = workshop;
    }

    abstract void manufacture();
}

// 4. Refined Abstractions
// Specific types of vehicles that use the Workshop bridge.

class Car extends Vehicle {
    public Car(Workshop workshop) {
        super(workshop);
    }

    @Override
    public void manufacture() {
        System.out.print("Car is being ");
        workshop.work(); // Delegating the work to the implementation
        System.out.println(); // New line for formatting
    }
}

class Bike extends Vehicle {
    public Bike(Workshop workshop) {
        super(workshop);
    }

    @Override
    public void manufacture() {
        System.out.print("Bike is being ");
        workshop.work();
        System.out.println();
    }
}

// 5. Client Code
public class BridgePattern {
    public static void main(String[] args) {
        System.out.println("--- Bridge Pattern: Vehicles & Workshops ---\n");

        // Create a Car that uses the 'Produce' workshop
        Vehicle car1 = new Car(new Produce());
        car1.manufacture();

        // Create a Car that uses the 'Assemble' workshop
        // Notice we can change the implementation without changing the Car class
        Vehicle car2 = new Car(new Assemble());
        car2.manufacture();

        // Create a Bike that uses the 'Produce' workshop
        Vehicle bike1 = new Bike(new Produce());
        bike1.manufacture();

        // Create a Bike that uses the 'Assemble' workshop
        Vehicle bike2 = new Bike(new Assemble());
        bike2.manufacture();
    }
}