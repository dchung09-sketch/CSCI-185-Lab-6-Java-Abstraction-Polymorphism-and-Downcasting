# Java Abstraction, Polymorphism, and Downcasting

## Overview

This project was developed for **CSCI 185 – Programming II, Lab 6** at New York Institute of Technology.

The program demonstrates how Java can represent different types of objects through a common abstract parent class. An abstract `Vehicle` class defines shared vehicle information and requires each concrete subclass to implement a movement behavior.

The `Car` and `Bicycle` classes extend `Vehicle`. Each provides its own implementation of `move()` and introduces additional behaviors specific to that vehicle type.

The main program stores both objects in a `Vehicle[]` array. It displays their information, calls their movement methods through a common parent reference, and uses `instanceof` checks followed by explicit downcasting to access the car's horn and the bicycle's bell.

## Learning Objectives

- Define an abstract parent class with shared properties and behavior.
- Implement abstract methods in concrete subclasses.
- Reuse a parent constructor through `super()`.
- Encapsulate data using private fields and public getters.
- Store different subclass objects in an array of their parent type.
- Demonstrate runtime polymorphism through overridden methods.
- Identify an object's type using `instanceof`.
- Perform checked downcasting to access subclass-specific methods.
- Override `toString()` to provide readable object information.
- Traverse an object array using an enhanced `for` loop.

## Project Files

| File | Responsibility |
| --- | --- |
| `Vehicle.java` | Defines the abstract parent class, private fields, getters, constructor, abstract movement method, and text representation. |
| `Car.java` | Implements car movement and provides horn and driving behaviors. |
| `Bicycle.java` | Implements bicycle movement and provides a bell behavior. |
| `Main.java` | Creates the objects and demonstrates polymorphism, type checking, and downcasting. |

## Class Relationships

Both `Car` and `Bicycle` directly extend `Vehicle`.

| Parent Class | Subclass | Required Method | Additional Methods |
| --- | --- | --- | --- |
| `Vehicle` | `Car` | `move()` | `honking()`, `driving()` |
| `Vehicle` | `Bicycle` | `move()` | `rinningtheBell()` |

This is hierarchical inheritance: multiple subclasses share the same parent class.

## Vehicle: Abstract Parent Class

### Shared Fields

The `Vehicle` class stores two private instance fields:

| Field | Type | Description |
| --- | --- | --- |
| `year` | `int` | The vehicle's year. |
| `brand` | `String` | The vehicle's brand. |

The fields are private, so code outside `Vehicle` cannot access them directly. Public getter methods provide read access:

```java
public int getYear()
public String getBrand()
```

The class does not define setters, so its public interface provides no method for changing these values after construction.

### Constructor

The constructor initializes the shared fields:

```java
public Vehicle(int year, String brand)
```

Although `Vehicle` is abstract and cannot be instantiated directly, its constructor runs when a subclass constructor calls it.

Both subclasses initialize their inherited vehicle information using:

```java
super(year, brand);
```

### Abstract Movement Method

The parent class declares:

```java
public abstract void move();
```

This establishes a common operation without specifying its implementation. Each concrete subclass must provide a method body.

A car and a bicycle can therefore respond to the same method call while producing different behavior.

### Object Information with toString()

`Vehicle` overrides `Object.toString()` to return the year and brand:

```java
@Override
public String toString() {
    return "Year : " + year + "\n" +
            "Brand : " + brand + "\n";
}
```

Both subclasses inherit this implementation.

When an object is passed to `System.out.println()`, Java uses its `toString()` representation to display the vehicle information.

## Car Class

`Car` extends `Vehicle` and accepts a year and brand through its constructor.

The main program creates:

```java
new Car(2022, "BMW")
```

### Movement

The overridden `move()` method prints:

```text
Daniel's car is moving
```

### Horn Behavior

The `honking()` method prints:

```text
Daniel's Car is honking the horn
```

This method is called in `Main` after the program confirms that the current object is a `Car`.

### Additional Driving Method

The class also defines `driving()`, which prints:

```text
Daniel's current car is driving
```

This method is available in the class but is not called by the current main program.

## Bicycle Class

`Bicycle` extends `Vehicle` and also accepts a year and brand through its constructor.

The main program creates:

```java
new Bicycle(2027, "Untron")
```

### Movement

The overridden `move()` method prints:

```text
The bicycle is currently pedaling
```

### Bell Behavior

The method named `rinningtheBell()` prints:

```text
The bicycle is ringing as I am riding
```

The spelling `rinningtheBell()` matches the current source code. The method is called after the program confirms that the current object is a `Bicycle`.

## Polymorphic Vehicle Array

The main program creates an array using the parent type:

```java
Vehicle[] vehicles = {
    new Car(2022, "BMW"),
    new Bicycle(2027, "Untron")
};
```

Although the array is declared as `Vehicle[]`, its elements reference objects of different concrete classes.

Assigning subclass objects to parent-type references is an example of implicit upcasting. No explicit cast is required because every `Car` and `Bicycle` in this hierarchy is also a `Vehicle`.

This allows the program to process both objects through one loop.

## Runtime Polymorphism

The enhanced `for` loop uses a variable declared as `Vehicle`:

```java
for (Vehicle v : vehicles) {
    System.out.println(v);
    v.move();
}
```

The call `v.move()` is the same for every array element. Java selects the implementation based on the actual object at runtime:

- A `Car` object executes `Car.move()`.
- A `Bicycle` object executes `Bicycle.move()`.

This is runtime polymorphism, also called dynamic method dispatch.

No explicit cast is needed to call `move()` because that method is already declared in `Vehicle`.

## Type Checking and Downcasting

The subclass-specific methods are not declared in `Vehicle`. A variable declared as `Vehicle` therefore cannot directly call `honking()` or `rinningtheBell()`.

The program first checks the object's type, then casts the reference to the appropriate subclass:

```java
if (v instanceof Car) {
    ((Car) v).honking();
} else if (v instanceof Bicycle) {
    ((Bicycle) v).rinningtheBell();
}
```

### How This Works

1. `instanceof` checks whether the referenced object is compatible with the specified subclass.
2. The explicit cast gives the expression that subclass type.
3. The program calls the method available on that subclass.

The cast does not create a new object or transform the existing object. It allows the existing reference to be used as a more specific type.

Checking the type before casting prevents an incompatible cast in these branches.

## Key Concepts in the Code

| Concept | Example | Purpose |
| --- | --- | --- |
| Abstraction | `abstract class Vehicle` | Defines a shared foundation for vehicle types. |
| Inheritance | `Car extends Vehicle` | Reuses shared state and methods. |
| Encapsulation | Private `year` and `brand` fields | Restricts direct access to stored data. |
| Constructor chaining | `super(year, brand)` | Initializes the parent portion of each object. |
| Method overriding | Subclass implementations of `move()` | Provides different movement behavior. |
| Runtime polymorphism | `v.move()` | Selects the implementation based on the actual object. |
| Upcasting | Subclass objects stored in `Vehicle[]` | Processes different types through a common reference. |
| Type checking | `v instanceof Car` | Checks compatibility before casting. |
| Downcasting | `((Car) v).honking()` | Accesses subclass-specific behavior. |
| Text representation | `Vehicle.toString()` | Produces readable vehicle information. |

## Program Execution

The program performs the following steps:

1. Creates a BMW car with the year 2022.
2. Creates an Untron bicycle with the year 2027.
3. Stores both objects in a `Vehicle[]` array.
4. Begins iterating through the array.
5. Prints the current vehicle's year and brand.
6. Invokes its overridden `move()` method.
7. Checks whether it is a car or bicycle.
8. Calls the appropriate horn or bell method.
9. Prints a blank line before processing the next object.

All values are predefined. The program does not request user input.

## Expected Console Output

```text
Year : 2022
Brand : BMW

Daniel's car is moving
Daniel's Car is honking the horn

Year : 2027
Brand : Untron

The bicycle is currently pedaling
The bicycle is ringing as I am riding

```

The blank line after each brand appears because `toString()` ends with a newline and `println()` adds another newline. A separate `println()` also adds spacing after each vehicle's behavior messages.

## File Setup

Rename the uploaded files to match their public class names:

| Uploaded Filename | Required Filename |
| --- | --- |
| `Main-5.java` | `Main.java` |
| `Vehicle-1.java` | `Vehicle.java` |
| `Car-1.java` | `Car.java` |
| `Bicycle.java` | `Bicycle.java` |

Place `Vehicle.java`, `Car.java`, and `Bicycle.java` inside a folder named `labfiles`.

Keep `Main.java` in the parent folder.

| Relative Path | Contents |
| --- | --- |
| `Main.java` | Program entry point |
| `labfiles/Vehicle.java` | Abstract parent class |
| `labfiles/Car.java` | Car subclass |
| `labfiles/Bicycle.java` | Bicycle subclass |
| `README.md` | Project documentation |

The lowercase folder name `labfiles` must match the package declaration in the source files.

## How to Compile and Run

### Requirements

- A Java Development Kit (JDK)
- A terminal or Java-compatible development environment
- Source files named and organized as described above

### Compile

Open a terminal in the folder containing `Main.java`:

```bash
javac Main.java labfiles/Vehicle.java labfiles/Car.java labfiles/Bicycle.java
```

### Run

```bash
java Main
```

The car's information and behavior appear first, followed by the bicycle's.

## Current Scope and Limitations

- Vehicle movement, honking, and bell ringing are represented by text messages.
- The program does not simulate physical movement or play audio.
- Constructor values are not validated.
- The private vehicle fields have getters but no setters.
- `Car.driving()` is implemented but not called in `Main`.
- The program uses fixed example objects and does not include interactive input.
- Adding a new subclass with a specialized action would require another type-checking branch to invoke that action through the current design.

## Possible Extensions

- Add another concrete subclass with its own `move()` implementation.
- Call `Car.driving()` to demonstrate the additional car behavior.
- Validate vehicle years and brand names.
- Allow users to enter vehicle information.
- Rename `rinningtheBell()` to a more conventional name such as `ringBell()` and update its call.
- Introduce a shared interface for audible alerts so horn and bell behavior can be invoked polymorphically.

## Author

Daniel Chung  
CSCI 185 – Programming II  
Section M03 — Lab 6  
New York Institute of Technology
