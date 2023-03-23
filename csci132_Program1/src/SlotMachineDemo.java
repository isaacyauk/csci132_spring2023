import java.util.Scanner;
public class SlotMachineDemo
{
    // This is the file where you drive all the different elements of your program.
    public static void main(String[] args)
    {
        SlotMachine game = new SlotMachine();
        Scanner inputSearcher = new Scanner(System.in);

        // A bool to turn the while loop on and off
        boolean gameActive = true;
        while(gameActive)
        {
            game.menuText();

            // Grabbing user input here for selector logic each time the loop runs
            int userChoice = Integer.parseInt(inputSearcher.nextLine());
            if (userChoice == 1)
            {
                game.playRound();
                game.calculateWin();
            }
            else if (userChoice == 2)
            {
                // plays the slot "n" number of times
                System.out.println("Please enter how many games in a row you want to play: ");
                int userLoop = Integer.parseInt(inputSearcher.nextLine());
                for (int i = 0; i < userLoop; i++)
                {
                    game.playRound();
                    game.calculateWin();
                }
            }
            else if (userChoice == 3)
            {
                // Prints out the total winnings the machine has paid out. This is separate from the start credit value
                game.getTotalWinnings();
            }
            else if(userChoice == 4)
            {
                // Views current credit count. On 1st run, this should be 10, afterward, it'll be combined with the winnings
                game.getTotalCredits();
            }
            else if (userChoice == 5)
            {
                // End game
                gameActive = false;
            }

        }
    }
}
