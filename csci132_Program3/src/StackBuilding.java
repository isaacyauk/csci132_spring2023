import java.util.Scanner;
public class StackBuilding
{
    public static void printSubmenuOptions() {
        System.out.println("");
        System.out.println("1. New classroom");
        System.out.println("2. New office");
        System.out.println("3. New research lab");
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
            {
                System.out.println("Your choice?");
                choice = inputFinder.nextInt();
                if (choice == 1)
                {
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
                    System.out.println("What professor will have this office?");
                    Scanner userResponse = new Scanner(System.in);
                    String userString = userResponse.next();

                    Floor add = new Floor("office", userString, this.buildingSize + 1);

                    this.top_of_building++;
                    data[this.top_of_building] = add;
                    this.buildingSize++;
                }
                if (choice == 3)
                {
                    System.out.println("What type of Research Lab will be here?");
                    Scanner userResponse = new Scanner(System.in);
                    String userString = userResponse.next();

                    Floor add = new Floor("research lab", userString, this.buildingSize + 1);

                    this.top_of_building++;
                    data[this.top_of_building] = add;
                    this.buildingSize++;

                }
                if (choice == 4)
                {
                    // Return without doing anything
                    return;
                }

                printSubmenuOptions();

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

    public void removeFloor()
    {
        if (this.buildingSize == 0)
        {
            return;
        }
        else
        {
            this.data[this.top_of_building] = null;
            this.top_of_building--;
            this.buildingSize--;
        }
    }

    public Floor searchForClassroom(Floor floorToFind)
    {
        if (this.buildingSize != 0)
        {
            // TODO: Find the floor that is being passed in
        }
        else
        {
            System.out.println("There are no floors left to search through...");
            return null;
        }
    }





}
