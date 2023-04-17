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
        // Handles edge case of an empty que
        if(this.queueSize != 0 )
        {
            // Check to see if there is still a prof in the line, creating a priority
            if (this.professor.isEmpty())
            {
                Customer served =  this.customers.removeFirst();
                System.out.println(served.getName() + " was served and removed from the line.");
                return served;
            }
            else
            {
                Customer served =  this.professor.removeFirst();
                System.out.println(served.getName() + " was served and removed from the line.");
                return served;
            }

            // TODO: Get current time and figure out how long the person was in the line
            // TODO: make an array list of wait times after a sucessful dequeue

        }
        else
        {
            System.out.println("There are no customers in line! (maybe we'll get to go home early...)");
            return null;
        }
    }

    public void removeFromQueue(String nameToFind)
    {
        // Catching edge case where there are no people left in the queue.
        if (this.queueSize != 0)
        {
            // Searching through the Professor queue here
            for (Customer each_prof : this.professor)
            {
                // If a match is found, remove that match from the linked list
                if (Objects.equals(each_prof.getName(), nameToFind))
                {
                    System.out.println(each_prof.getName() + " is late for class and left the line.");
                    customers.remove(each_prof);
                }
            }

            // Searching through the Student queue here
            for (Customer each_student : this.customers)
            {
                if (Objects.equals(each_student.getName(), nameToFind))
                {
                    System.out.println(each_student.getName() + " got impatient and left the line.");
                    customers.remove(each_student);
                }
                else    // At this point, all the elements of the queues have been searched through
                {
                    System.out.println("That person doesn't seem to be in the line...");
                }
            }
        }
        else
        {
            System.out.println("The line is empty!");
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
