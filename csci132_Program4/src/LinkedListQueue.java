import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class LinkedListQueue
{
    private LinkedList<Customer> customers;
    private LinkedList<Customer> professor;
    private ArrayList<Double> waitTimes;
    private int queueSize;
    private int servedCustomers = 0;

    public LinkedListQueue()
    {
        this.customers = new LinkedList<Customer>();
        this.professor = new LinkedList<Customer>();
        this.waitTimes = new ArrayList<Double>();
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
        // Handles edge case of an empty que and trying to run option 4 on a queue that used to be full, but is now empty
        if(this.queueSize != 0 && !customers.isEmpty())
        {
            // Check to see if there is still a prof in the line, creating a priority
            if (this.professor.isEmpty())
            {
                Customer served =  this.customers.removeFirst();
                System.out.println(served.getName() + " was served and removed from the line.");

                // Stop tracking the exe TIME here
                long end_time = System.nanoTime();
                double total_wait_time = (end_time - served.getTime()) / 1000000000;
                System.out.println("this customer waited " + total_wait_time + " seconds.");
                this.waitTimes.add(0, total_wait_time);
                servedCustomers++;

                return served;
            }
            else
            {
                Customer served =  this.professor.removeFirst();
                System.out.println(served.getName() + " was served and removed from the line.");

                // Stop tracking the exe TIME here
                long end_time = System.nanoTime();
                double total_wait_time = (end_time - served.getTime()) / 1000000000;
                System.out.println("this customer waited " + total_wait_time + " seconds.");
                this.waitTimes.add(0, total_wait_time);
                servedCustomers++;

                return served;
            }
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
        else    // If there is nothing in either of the Lists
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

        // Starts tracking the exe TIME here
        long startTime = System.nanoTime();

        return new Customer(customerName, customerOrder, startTime);
    }

    public void printQueueStats()
    {
        double total_wait_times = 0;
        for (int i = 0; i < waitTimes.size(); i++)
        {
            total_wait_times += waitTimes.get(i);
        }

        double average_wait_time = total_wait_times / waitTimes.size();
        System.out.println("------- Queue Statistics -------");
        System.out.println("Average wait time: " + average_wait_time);
        System.out.println("Total customers served: " + servedCustomers);
    }
}