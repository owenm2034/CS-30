package Monus;
import java.util.Random;

public class Die {
    Random diceCup = new Random();
    int roll;
    int size;

    Die(int size) {
        this.size = size;
    }

    public int roll() {
        roll = (diceCup.nextInt(size)) + 1;
        return this.roll;
    }
}
