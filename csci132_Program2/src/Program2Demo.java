import java.util.Scanner;

public class Program2Demo
{
    public static void main(String[] args)
    {
        LinkedListBattle showdown = new LinkedListBattle();

        showdown.fillChallengerList("participants.txt");

        System.out.println("Challengers Remaining: \n-------------------------------");
        showdown.printLinkedList();

        while (showdown.getListSize() > 1)
        {
            Scanner inputSearcher = new Scanner(System.in);
            System.out.println("Would you like to continue? (Y/N): ");
            String userResponse = inputSearcher.nextLine().toLowerCase();
            if(userResponse.contains("y"))
            {
                showdown.simulateOneRound();
                showdown.printLinkedList();
            }
            else
            {
                System.out.println("Goodbye.");
                System.exit(0);
            }
        }
        System.out.println("-------------------------------\nThe winner is " + showdown.getHead().getName() + "!");
    }
}
