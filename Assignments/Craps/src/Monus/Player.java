package Monus;

import java.util.Scanner;

public class Player {
    Scanner scan = new Scanner(System.in);

    public boolean readyToRoll() {
        System.out.print("\nPress Enter to roll...");
        scan.nextLine();
            return true;
    }
}

