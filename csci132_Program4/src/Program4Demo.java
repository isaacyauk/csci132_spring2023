import java.util.Scanner;
public class Program4Demo {

    public static void printMenu()
    {
        System.out.println("\n1. View Current Queue");
        System.out.println("2. Add student to queue");
        System.out.println("3. Add professor to queue");
        System.out.println("4. Serve next customer");
        System.out.println("5. Remove customer from queue");
        System.out.println("6. Print Queue Statistics");
        System.out.println("7. Exit\n");
    }

    public static void main(String[] args)
    {
        LinkedListQueue queue = new LinkedListQueue();

        System.out.println("Welcome to the Route 406 Sandwiches Queue");
        printMenu();
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        while(choice != 7)
        {
            System.out.println("Your choice?");
            choice = sc.nextInt();
            //System.out.println();
            if(choice == 1)
            {
                queue.printQueue();
            }
            if(choice == 2) {
                Customer c = queue.createCustomer();
                queue.enqueue(c);
            }
            if(choice == 3)
            {
                Customer c = queue.createCustomer();
                queue.priorityEnqueue(c);
            }
            if(choice == 4)
            {
                queue.dequeue();
            }
            if(choice == 5)
            {
                System.out.println("What customer is leaving the line?");
                String name = sc.next();
                queue.removeFromQueue(name);
            }
            if(choice == 6)
            {
               queue.printQueueStats();
            }
            if(choice == 7)
            {
                System.exit(0);
            }

            printMenu();
        }
    }
}