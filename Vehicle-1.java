/*
Name: Daniel Chung
Student ID: 1331774
Course: CSCI 185- Programming 2
Section: M03
Lab 6
 */

package labfiles;// the package of the files are called labfiles
public abstract class Vehicle {// this is an immense abstract class for the vehicle files
    private int year;// setting the private integer int
    private String brand;// setting the private string brand

    public Vehicle(int year, String brand) {// start of the constructor vehicle class
        this.year = year; //identifying the year
        this.brand = brand;// identifying the brand
    }

    public int getYear() {// getter method for the year
        return year;// greturning the year
    }

    public String getBrand() {// getter method for the brand
        return brand;// returning the brand
    }

    public abstract void move(); // this is part of the abstract method instance

    @Override// this is an ovveride statement
    public String toString() {// this is a major tostring method
        return "Year : " + year + "\n" +// these are the outputs with a \n for spaces
                "Brand : " + brand + "\n";// these are the outputs for the brand
    }
}
