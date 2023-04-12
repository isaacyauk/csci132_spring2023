import java.util.LinkedList;
public class LinkedListQueue
{
    private LinkedList<Customer> customers;
    private int queueSize;

    public LinkedListQueue()
    {
        this.customers = new LinkedList<Customer>();
        this.queueSize = 0;
    }

    // TODO: Verify that this function properly, once you can enqueue peeps
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
}
