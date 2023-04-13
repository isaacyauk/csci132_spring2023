public class Customer
{
    private String name;
    private String order;
    private Long time_in_queue;

    /*TODO: a bool value maybe needed to be added to the class and constructor to check if
    *  the homie is a prof or not. */

    public Customer (String n, String o, Long t)
    {
        this.name = n;
        this.order = o;
        this.time_in_queue = t;
    }

    public String getName()
    {
        return this.name;
    }

    public void printCustomer(int order_num)
    {
        System.out.println(order_num + ". " + this.name + " (" + this.order + ")");
    }

}
