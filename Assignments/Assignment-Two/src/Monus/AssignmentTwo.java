/*
Computer Science 30 Assignment Two
Assorted things to solve.  Now with loops!
Name:Owen Monus
Date:Sept 21
 */

package Monus;

import java.util.Scanner;

public class AssignmentTwo {

    /*
    Use a for loop to print the even number from 2 to 100, inclusive.
     */
    public static void even(){
        for (int evenInt = 2; evenInt <= 100; evenInt += 2)
        {
            System.out.println(evenInt);
        }
    }

    /*
    Ask the user how many integers they want to sum.  Use a while loop to ask for and sum that many numbers.  Keep track
    of the count of how many negative entries, positive entries, and entries equal to 0 that there were.  Use an
    if\else if\ else chain instead of separate if statements to do this.  Display the sum and the other stats at the
    end.

    Possible program run:

    How many integers do you want to sum?  3

    Enter integer: -1
    Enter integer: 0
    Enter integer: -10

    Sum: -11
    Number of zeroes: 1
    Number of negative integers: 2
    Number of positive integers: 0
     */
    public static void sumStats(){
        Scanner scan = new Scanner(System.in);
        int positiveCount = 0, negativeCount = 0, zeroCount = 0, sum = 0, intCount; //int variables to count how many integers to ask for, how many are positive, how many are negative, how many are 0, and the final sum.

        System.out.print("How many integers would you like to sum? ");
        intCount = scan.nextInt();

        while (intCount > 0)
        {
            System.out.print("Enter integer: ");
            int integer = scan.nextInt();
            if (integer > 0)
            {
                positiveCount += 1;
            }
            else if (integer == 0)
            {
                zeroCount += 1;
            }
            else
            {
                negativeCount += 1;
            }
            sum += integer;
            intCount--;
        }

        System.out.println("\nSum: " + sum);
        System.out.println("Number of zeroes: " + zeroCount);
        System.out.println("Number of negative integers: " + negativeCount);
        System.out.println("Number of positive integers: " + positiveCount);

    }

    /*
    Asks the user how many coin flips they wish to simulate.  Use a loop to simulate flipping a coin that many times.
    Output the total number flips, number of heads, percentages of heads, number of tails, and  percentage of tails.
     */
    public static void coinFlipper(){
        Scanner scan = new Scanner(System.in);
        int headCount = 0, tailCount = 0, totalFlips = 0;  //Integer variables to count heads and tails amd the amount of times the coin has been flipped
        double flip, headsPercentage, tailsPercentage; //Double variables used for the variable to flip the coin, and for the heads percentage and tails percentage to get accurate results.
        System.out.print("How many coin flips do you wish to simulate? ");

        for (int remainingFlips = scan.nextInt(); remainingFlips > 0; remainingFlips--, totalFlips++) //The variable counter ensures the flip simulator does only as much as it is asked for
        {
            flip = Math.random();
            if (flip > 0.5)
            {
                headCount += 1;
            }
            else
            {
                tailCount += 1;
            }
        }

        headsPercentage = (((double)headCount/totalFlips) * 100);
        tailsPercentage = (((double)tailCount/totalFlips) * 100);

        System.out.println("\nTotal number of flips: " + totalFlips);
        System.out.println("Number of heads: " + headCount);
        System.out.println("Number of tails: " + tailCount);
        System.out.println("Percentage of heads: %" + Math.round(headsPercentage));
        System.out.println("Percentage of tails: %" + Math.round(tailsPercentage));
    }

    public static void main(String[] args) {
        even();
        System.out.println();

        sumStats();
        System.out.println();

        coinFlipper();
    }
}
