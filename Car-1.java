/*
Name: Daniel Chung
Student ID: 1331774
Course: CSCI 185- Programming 2
Section: M03
Lab 6
 */
package labfiles;// the package files are called labfiles
public class Car extends Vehicle {// the class is being extended from vehicle
    public Car(int year, String brand) {// the old variables from the previious class
        super(year, brand); // the super statement retrieving these variables
    }

    @Override// this is an oveerride statement
    public void move() {// this is a void statement that is part of move
        System.out.println("Daniel's car is moving");// this is a printed statement to the console
    }

    public void honking() {// this is a void statement when the car wants to honk
        System.out.println("Daniel's Car is honking the horn");// this is a printed statement to the console
    }

    public void driving() {// this is a void statement whenever te car is driving
        System.out.println("Daniel's current car is driving");// this is a prited statement to the console
    }
}
