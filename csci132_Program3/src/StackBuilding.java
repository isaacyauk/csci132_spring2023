import java.util.Scanner;
public class StackBuilding
{
    public static void printSubmenuOptions() {
        System.out.println("");
        System.out.println("1. New classroom");
        System.out.println("2. New office");
        System.out.println("3. New research lab");
        // You don't have to do option 4 if you don't want
        System.out.println("4. Return to previous menu");
        System.out.println("");
    }
    private Floor[] data;
    private int top_of_building;
    private int buildingSize;
    public StackBuilding()
    {
        data = new Floor[10];
        top_of_building = -1;
        buildingSize = 0;
    }

    public void addFloor()
    {
        if (this.buildingSize == 10)
        {
            return;
        }
        else
        {
            printSubmenuOptions();
            Scanner inputFinder = new Scanner(System.in);

            int choice = 0;
            while (choice != 4)
                System.out.println("Your choice?");
            choice = inputFinder.nextInt();
            {
                if (choice == 1)
                {
                    // TODO: add logic for a new classroom entry via scanner
                    // What course?
                    // attach string input value to the floor objec
                    System.out.println("What CS course will be offered here?");
                    Scanner userResponse = new Scanner(System.in);
                    String userString = userResponse.next();

                    Floor add = new Floor("Classroom", userString, this.buildingSize + 1);

                    this.top_of_building++;
                    data[this.top_of_building] = add;
                    this.buildingSize++;

                }
                if (choice == 2)
                {
                    // TODO: add logic for a new office entry via scanner
                    System.out.println("What professor will have this office?");

                }
                if (choice == 3)
                {
                    // TODO: add logic for a new research lab entry via scanner

                }
                if (choice == 4)
                {
                    // Return without doing anything
                    return;
                }

                printSubmenuOptions();

                // TODO: make sure that you correctly add all the right information here
                this.top_of_building++;
                data[this.top_of_building] = newFloor;
                this.buildingSize++;



            }
        }
    }

    public void printStack()
    {
        for (int i = this.buildingSize - 1; i >= 0; i--)
        {
            this.data[i].printInfo();
        }
    }





}
