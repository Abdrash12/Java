// 1. Define the Abstract Class
abstract class Animal {
    // A regular field (all animals have a name)
    protected String name;

    // Constructor for the abstract class
    public Animal(String name) {
        this.name = name;
    }

    // A regular method (all animals sleep similarly)
    public void sleep() {
        System.out.println(name + " is sleeping... Zzz");
    }

    // An ABSTRACT method - no body! [cite: 1391-1394]
    // Each subclass MUST provide its own version of this.
    public abstract void makeSound();
}

// 2. Create Concrete Subclasses that EXTEND the abstract class

class Dog extends Animal {
    // Constructor calls the superclass constructor
    public Dog(String name) {
        super(name); // 'super' calls the Animal constructor
    }

    // MUST implement the abstract method
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    // MUST implement the abstract method
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

// 3. Use the classes
public class AbstractClass {
    public static void main(String[] args) {
        // You CANNOT do this:
        // Animal genericAnimal = new Animal("Generic"); // Error! Cannot instantiate abstract class

        // You CAN create objects of the CONCRETE subclasses
        Animal myDog = new Dog("Buddy");
        Animal myCat = new Cat("Whiskers");

        // Call methods
        myDog.sleep();      // Inherited from Animal
        myDog.makeSound();  // Implemented in Dog

        myCat.sleep();      // Inherited from Animal
        myCat.makeSound();  // Implemented in Cat
    }
}