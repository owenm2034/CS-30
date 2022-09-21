package Monus;

import java.util.ArrayList;

public class DiceCup {
    ArrayList<Die> dice = new ArrayList<>();

    DiceCup(int numOfDice, int diceSize) {
        for (int i = 0; i < numOfDice; i++) {
            dice.add(new Die(diceSize));
        }
    }

    public int combinatorialRoll() {
        int tally = 0;
        for (Die die: dice) {
            int roll = die.roll();
            tally += roll;
        }
        return tally;
    }
}
