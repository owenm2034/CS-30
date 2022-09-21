package Monus;

/**
 * ZooAnimal.java
 *
 * @author Owen Monus
 * @since 5/10/21
 * A class for storing and retrieving basic info about zoo animals
 * Mr. Birrells CS 30
 * Creating Classes Assignment
 */

public class ZooAnimal {
    private static int currentYear = 2021; //a static int for the current year
    private static double lbToKg = 2.205; //a static int for the lb to kg conversion rate

    private String name; //animals given name
    private String species;
    private int age; //how many years old the animal is
    private int weight; //weight in pounds
    private int yearEntered; //the year the animal entered the zoo

    public ZooAnimal(String name, String species, int age, int weight, int yearEntered) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.weight = weight;
        this.yearEntered = yearEntered;
    }

    public static int getCurrentYear() {
        return currentYear;
    }

    public static void setCurrentYear(int currentYear) {
        ZooAnimal.currentYear = currentYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getYearEntered() {
        return yearEntered;
    }

    public void setYearEntered(int yearEntered) {
        this.yearEntered = yearEntered;
    }

    public int getYearOfBirth() {
        return currentYear - age;
    }

    public double getWeightKg() {
        return weight / lbToKg;
    }

    public void printAllInfo() {
        System.out.println("\nName = " + getName());
        System.out.println("Age = " + getAge());
        System.out.println("Species = " + getSpecies());
        System.out.println("Weight in pounds = " + getWeight());
        System.out.println("Weight in kilos = " + getWeightKg());
        System.out.println("Year of birth = " + getYearOfBirth());
        System.out.println("Year of entrance = " + getYearEntered());
    }
}
