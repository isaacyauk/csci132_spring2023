import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class LinkedListQueue
{
    private LinkedList<Customer> customers;
    private LinkedList<Customer> professor;
    private int queueSize;

    public LinkedListQueue()
    {
        this.customers = new LinkedList<Customer>();
        this.professor = new LinkedList<Customer>();
        this.queueSize = 0;
    }

    // TODO: Verify that this functions properly, once you can enqueue peeps
    public void printQueue()
    {
        int customerCounter = 1;
        for (Customer each_customer : this.professor)
        {
            each_customer.printCustomer(customerCounter);
            customerCounter++;
        }
        for (Customer each_customer : this.customers)
        {
            each_customer.printCustomer(customerCounter);
            customerCounter++;
        }
    }

    public void enqueue(Customer newCustomer)
    {
        this.customers.addLast(newCustomer);
        this.queueSize++;
    }

    public void priorityEnqueue(Customer newCustomer)
    {
        this.professor.addLast(newCustomer);
        this.queueSize++;
    }

    public Customer dequeue()
    {
        // TODO: prioritize removing professors! if selector logic --> the prof == isEmpty then remove from students
        if(this.queueSize !=0 )
        {
            Customer served =  this.customers.removeFirst();
            System.out.println(served.getName() + " was served and removed from the line.");
            // TODO: Get current time and figure out how long the person was in the line
            // TODO: make an array list of wait times after a sucessful dequeue
            return served;
        }
        else
        {
            return null;
        }
    }

    // TODO: What's the parameter here?
    //  A: Its a search var
    public void removeFromQueue(String nameToFind)
    {
        // Catching edge case where there are no people left in the queue.
        if (this.queueSize != 0)
        {
            // Searching through the Professor queue here
            for (Customer each_prof : this.professor)
            {
                if (Objects.equals(each_prof.getName(), nameToFind))
                {
                    System.out.println("Hey! I found " + each_prof.getName());
                }
            }

            // Searching through the Student queue here
            for (Customer each_student : this.customers)
            {
                if (Objects.equals(each_student.getName(), nameToFind))
                {
                    System.out.println("Hey! I found " + each_student.getName());
                }
                else    // At this point, all the elements of the queues have been searched through
                {
                    System.out.println("ERROR. That person wasn't found in the line.");
                }
            }
        }
    }

    public static Customer createCustomer()
    {
        System.out.println("What is the customer name?");
        Scanner userResponse = new Scanner(System.in);
        String customerName = userResponse.nextLine();

        System.out.println("What is the customer's order?");
        Scanner userResponse2 = new Scanner(System.in);
        String customerOrder = userResponse2.nextLine();

        long startTime = System.nanoTime();

        return new Customer(customerName, customerOrder, startTime);
    }
}
