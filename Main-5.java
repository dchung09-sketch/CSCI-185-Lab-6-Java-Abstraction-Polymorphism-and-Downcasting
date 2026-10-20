/*
Name: Daniel Chung
Student ID: 1331774
Course: CSCI 185- Programming 2
Section: M03
Lab 6
 */

import labfiles.Bicycle;// importing information from the bicycle file
import labfiles.Car;// importing from the car file
import labfiles.Vehicle;// importing from the vehicle file

public class Main {// start of the main method class
    public static void main(String[] args) {// start of the argumens in the method
        Vehicle[] vehicles = { new Car(2022, "BMW"), new Bicycle(2027, "Untron") };// array of vehicles identifying the different years and brands

        for (Vehicle v : vehicles) {// start of a for statement for vehicles
            System.out.println(v);// this is a print console statement for the variable v
            v.move();// executing the overriden method
            if (v instanceof Car) {// this is an if statement with an instaceof variable
                ((Car) v).honking();// this is a action that is being tested to identify if the car is honking or not
            } else if (v instanceof Bicycle) {// if not, the method instance action for the bbiycle class will start
                ((Bicycle) v).rinningtheBell();// he bicycle will then start running its bell
            }
            System.out.println();// this is a print statement that will allow a space to occur
        }
    }
}
