public class Node
{
    private String country_name;

    private Node next;
    private Node prev;

    public Node(String country_name)
    {
        this.country_name = country_name;
    }

    public Node getNext()
    {
        return this.next;
    }

    public Node getPrev()
    {
        return this.prev;
    }

    public void setPrev(Node newNode)
    {
        this.prev = newNode;
    }

    public void setNext(Node newNode)
    {
        this.next = newNode;
    }

    public String getCountry()
    {
        return this.country_name;
    }

    public void printNode()
    {
        System.out.println(this.country_name);
    }


}
