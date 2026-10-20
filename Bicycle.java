/*
Name: Daniel Chung
Student ID: 1331774
Course: CSCI 185- Programming 2
Section: M03
Lab 6
 */

package labfiles;// the files are within a package called labfiles

public class Bicycle extends Vehicle {// the bicycle files are extended from the abstract vehicle
    public Bicycle(int year, String brand) {// the bicycle variables are identified as integers and strings
        super(year, brand);// this is a super method that is retrieveing the old variables
    }

    @Override//  this is a override statement
    public void move() {// this is a public void statement with the move action
        System.out.println("The bicycle is currently pedaling");// this ia a printed statement that goes straight to the console
    }

    public void rinningtheBell() {// this is the void statement whenever the bicycle is rinning the bell
        System.out.println("The bicycle is ringing as I am riding");// the is a print statement that goes straight to the console.
    }
}
