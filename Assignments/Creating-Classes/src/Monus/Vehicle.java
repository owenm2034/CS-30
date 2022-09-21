package Monus;

/**
 * Vehicle.java
 * @author Owen Monus
 * @since 5/10/21
 * A class for storing and retrieving vehicle information
 * Mr. Birrells CS 30
 * Creating Classes Assignment
 */

public class Vehicle {

    private static final double milesToKm = 1.609; //conversion rate for km to mi
    private static final int currentYear = 2021; //the current year

    private String make; //a vehicles manufacturer
    private String model; //a vehicles model name
    private String colour; //a vehicles exterior colour
    private int year; //a vehicles year of production
    private int mileage; //a vehicles miles


    public Vehicle(String make, String model, String colour, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.year = year;
        this.mileage = mileage;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getAge() {
        return currentYear - year;
    }

    public double getKilometers() {
        return mileage * milesToKm;
    }

    public String getAllInfo(){
        return year + " " + make + " " + model + "\n" +
                "colour = " + colour + "\n" +
                "age = " + getAge() + "\n" +
                "mileage = " + mileage + "\n" +
                "kilometers = " + getKilometers() + "\n";
    }



}