import java.util.Objects;
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

                    Floor add = new Floor("Office", userString, this.buildingSize + 1);

                    this.top_of_building++;
                    data[this.top_of_building] = add;
                    this.buildingSize++;
                }
                if (choice == 3)
                {
                    System.out.println("What type of Research Lab will be here?");
                    Scanner userResponse = new Scanner(System.in);
                    String userString = userResponse.next();

                    Floor add = new Floor("Research Lab", userString, this.buildingSize + 1);

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

    public void searchForClassroom(String floorToFind)
    {
        // catches the edge case where the user tries to search in an empty building
        if (this.buildingSize != 0)
        {
            // iterates through the stack array based on how many things are in the building size
            for (int i = 0; i < this.buildingSize; i++)
            {
                System.out.println("TEST");
                try
                {
                    // Compares the string element of the Floor item stored in the array to the incoming value
                    if(Objects.equals(floorToFind, this.data[i].getInfo()))
                    {
                        System.out.println("eyyyyyyyyyyyyy we found da thing");
                    }
                }
                catch(Exception e)
                {
                    // TODO: Make this message actually print when the case is triggered
                    System.out.println("That class was not found to be offered in this buiilding.");
                }
            }
        }
        else
        {
            System.out.println("There are no floors left to search through...");
        }
    }

    public void printBuildingInfo()
    {
        int num_of_classrooms = 0;
        int num_of_offices = 0;
        int num_of_labs = 0;

        for (int i = 0; i < this.buildingSize; i++)
        {
            // Compares the floor_type string element of the Floor item stored in the array to one of the 3 defined room values
            if(Objects.equals(this.data[i].getFloorType(), "Classroom"))
            {
                num_of_classrooms++;
            }
            if(Objects.equals(this.data[i].getFloorType(), "Office"))
            {
                num_of_offices++;
            }
            if(Objects.equals(this.data[i].getFloorType(), "Research Lab"))
            {
                num_of_labs++;
            }
        }

        System.out.println("Number of Classrooms: " + num_of_classrooms);
        System.out.println("Number of Offices: " + num_of_offices);
        System.out.println("Number of Research Labs: " + num_of_labs);
    }
}
