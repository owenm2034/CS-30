/*
Computer Science 30 Assignment One
Assorted things to solve.
Name: Owen Monus
Date: Sept 13 2021
 */

// change this to your package name (your last name) if the IDE doesn't do it for you
package Monus;

//imports
import java.util.Scanner;
import turtles.*;

public class AssignmentOne {

    /*
    Ask the user for the temperature in Celsius, convert it to Fahrenheit, and display it to the user
     */
    public static void celsiusToFahrenheit(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a temperature in degrees celsius: ");
        double celsius = scan.nextDouble();
        double fahrenheit = ((celsius * (1.8)) + 32);

        System.out.println(celsius + " degrees celsius is " + fahrenheit + " degrees fahrenheit.");
        return;
    }

    /*
    Asks the user for number of seconds.  Convert this to Days:Hours:Minutes:Seconds
    For example, 100000 seconds would be 1:3:46:40
     */
    public static void secondsToDays(){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a number of seconds: ");
        int days, hours, minutes, seconds, remainingSeconds, secondsInput;

        secondsInput = scan.nextInt();
        days = (secondsInput) / 86400;
        remainingSeconds = (secondsInput) % 86400;
        hours = remainingSeconds / 3600;
        remainingSeconds = remainingSeconds % 3600;
        minutes = remainingSeconds / 60;
        remainingSeconds = remainingSeconds % 60;
        seconds = remainingSeconds;

        System.out.println(days + ":" + hours + ":" + minutes + ":" + seconds);
        return;
    }

    /*
    Create two turtles.  Have the first draw a triangle and the second draw a hexagon.  The shapes should not overlap.
    Output how far away the two turtles are from each other at the end.
     */
    public static void turtlePower(){
        //World and turtle creation
        World world = new World(300,300);
        Turtle john = new Turtle(280, 299, world);
        Turtle davy = new Turtle(1, 1, world);
        world.show(true);

        //Triangle
        davy.moveTo(150,1);
        davy.moveTo(75, 125);
        davy.moveTo(1,1);

        //Hexagon
        john.moveTo(299, 280);
        john.moveTo(299, 250);
        john.moveTo(280, 230);
        john.moveTo(250, 230);
        john.moveTo(230, 250);
        john.moveTo(230, 280);
        john.moveTo(250,299);
        john.moveTo(280, 299);

        //distance apart
        int davyX = davy.getXPos();
        int davyY = davy.getYPos();
        int distance = (int) john.getDistance(davyX, davyY);
        System.out.println("John (green) is " + distance + " px away from Dave (blue).");
        return;
    }

    /*
    Use indexOf and substring to create a new string with the target removed from the source.  Print the new string.
    Try to create a general solution that works for any source and target, provided that the target exists in the source.
     */
    public static void pizza(){
        String source = "Ham and pineapple is not a pizza.";
        String target = "not" + " ";
        int splice = source.indexOf(target); //finds the target and its index in the source
        int length = target.length(); //finds the length of the target

        /*
        The following line of code takes the source line, and keeps everything up until the index, or first character, of the target.
        It then concatenates this with everything following the last index of the target (the last index position is found using the
        targets beginning index + its length). This creates a snippet of code that can work with any source and target, provided the
        target is in the source (if it isn't there is an error).
        */

        System.out.println(source.substring(0, splice) + source.substring((splice + length)));

        return;
    }

    /*
    Prints a random integer from 20 - 80 inclusive.
     */
    public static void myRandom(){
        int random = (int)(Math.random()* 61) + 20;
        System.out.println(random);
    }

    public static void main(String[] args) {
        celsiusToFahrenheit();
        secondsToDays();
        turtlePower();
        pizza();
        myRandom();
        myRandom();
        myRandom();

    }
}
