/*
Author: Isaac Yauk
Date Completed: 2/10/2023
Summary: This program is a very simplistic slot machine that takes user input
    with a very basic UI, and generates a 3x3 slot machine roll and awards them
    accordingly; keeping track of their winnings and current available credits.

    PLEASE DO NOT SHARE THIS CODE.
*/

import java.util.Random;

public class SlotMachine
{
    // Don't forget to instantiate things here if you need!
    private int[] top_row;
    private int[] mid_row;
    private int[] bttm_row;

    private int total_winnings;
    private int credits = 10;


    // Constructor method for slot machine
    public SlotMachine()
    {
        // Creates an int array with a space of 3
        this.top_row = new int[3];
        this.mid_row = new int[3];
        this.bttm_row = new int[3];

        this.total_winnings = total_winnings;
        this.credits = credits;
    }

    // ↓↓↓ Various method calls that can be used in this class ↓↓↓
    public void menuText()
    {
        System.out.println("""
                    Welcome to Java Casino Slot Machine
                    Press 1 to play the slots once
                    Press 2 to play the slots X amount of times
                    Press 3 to print out this machine's total winnings
                    Press 4 to view your current credits
                    Press 5 to exit""");
    }
    public void playRound()
    {
        String space = "  ";
        Random rand = new Random();

        // Fills the arrays
        for (int i = 0; i < 3; i++)
        {
            this.top_row[i] = rand.nextInt(1, 4);
            this.mid_row[i] = rand.nextInt(1, 4);
            this.bttm_row[i] = rand.nextInt(1, 4);
        }

        // Prints out the results
        System.out.println("- - - - - -");
        System.out.println(space + top_row[0] + space + top_row[1] + space + top_row[2]);
        System.out.println("- - - - - -");
        System.out.println(space + mid_row[0] + space + mid_row[1] + space + mid_row[2]);
        System.out.println("- - - - - -");
        System.out.println(space + bttm_row[0] + space + bttm_row[1] + space + bttm_row[2]);
        System.out.println("- - - - - -\n");

        // Removes one credit for playing
        credits -= 1;
    }

    public void calculateWin()
    {
        // Sum of all numbers
        int allTotal = top_row[0] + top_row[1] + top_row[2] +
                mid_row[0] + mid_row[1] + mid_row[2] +
                bttm_row[0] + bttm_row[1] + bttm_row[2];

        System.out.println("------- ↓ TOTAL WINNINGS ↓ -------");
        if (allTotal > 20)
        {
            System.out.println(" --→ Sum of all numbers is greater than 20 (+2 Credit)");
            total_winnings += 2;
        }

        // Checks for both Diagonals to be matching
        if(top_row[0] == mid_row[1] && mid_row[1] == bttm_row[2] &&
        bttm_row[2] == bttm_row[0] && bttm_row[0] == top_row[2])
        {
            System.out.println(" --→ 2 Matching Diagonals (+4 Credit)");
            total_winnings += 4;
        }       // else, checks Left-to-Right & Right-to-Left diagonals
        else if (top_row[0] == mid_row[1] && mid_row[1] == bttm_row[2] ||
                top_row[2] == mid_row[1] && mid_row[1] == bttm_row[0])
        {
                System.out.println(" --→ Matching Diagonals (+2 Credit)");
                total_winnings += 2;
        }
        // Column (up/down) numbers match
        if(top_row[0] == mid_row[0] && mid_row[0] == bttm_row[0] ||
                top_row[1] == mid_row[1] && mid_row[1] == bttm_row[1] ||
                top_row[2] == mid_row[2] && mid_row[2] == bttm_row[2])
        {
            System.out.println(" --→ Matching Column (+2 Credit)");
            total_winnings += 2;
        }
        // Row (left/right) numbers match
        if (top_row[0] == top_row[1] && top_row[1] == top_row[2] ||
                mid_row[0] == mid_row[1] && mid_row[1] == mid_row[2] ||
                bttm_row[0] == bttm_row[1] && bttm_row[1] == bttm_row[2])
        {
            System.out.println(" --→ Matching Row (+2 Credit)");
            total_winnings += 2;
        }
        // Matching corners
        if (top_row[0] == top_row[2] && top_row[2] == bttm_row[0] &&
                bttm_row[0] == bttm_row[2])
        {
            System.out.println(" --→ Matching Corners (+3 Credit)");
            total_winnings += 3;
        }
        System.out.println("------- - ----- -------- - -------\n");
    }

    public void getTotalCredits()
    {
        System.out.println("Your total credits are: " + (credits + total_winnings) + "\n");
    }

    public void getTotalWinnings()
    {
        System.out.println("The total winnings from this machine are: " + total_winnings + "\n");
    }
}
