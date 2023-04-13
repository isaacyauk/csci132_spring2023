import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListQueue
{
    private LinkedList<Customer> customers;
    private int queueSize;

    public LinkedListQueue()
    {
        this.customers = new LinkedList<Customer>();
        this.queueSize = 0;
    }

    // TODO: Verify that this functions properly, once you can enqueue peeps
    public void printQueue()
    {
        int counter = 1;
        for (Customer each_customer : this.customers)
        {
            each_customer.printCustomer(counter);
            counter++;
        }
    }

    public void enqueue(Customer newCustomer)
    {
        this.customers.addLast(newCustomer);
        this.queueSize++;
    }

    public Customer dequeue()
    {
        if(this.queueSize !=0 )
        {
            Customer served =  this.customers.removeFirst();
            System.out.println(served.getName() + " was served and removed from the line.");
            return served;
        }
        else
        {
            return null;
        }
    }

    // TODO: What's the parameter here?
    public void removeFromQueue()
    {
        //TODO: fill this out!

    }

    public static Customer createCustomer(boolean isProf)
    {
        System.out.println("What is the customer name?");
        Scanner userResponse = new Scanner(System.in);
        String customerName = userResponse.nextLine();

        System.out.println("What is the customer name?");
        Scanner userResponse2 = new Scanner(System.in);
        String customerOrder = userResponse2.nextLine();

        if(isProf)
        {
            Customer newProfessor = new Customer(customerName, customerOrder);
            //TODO: add the professor to the professor queue here
            return newProfessor;
        }
        else
        {
            Customer newStudent = new Customer(customerName, customerOrder);
            //TODO: add the student to the student queue here
            return newStudent;
        }
    }
}
