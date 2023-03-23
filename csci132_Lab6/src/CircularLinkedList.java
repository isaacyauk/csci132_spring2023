import java.util.Random;

public class CircularLinkedList
{
    private Node head;
    private Node tail;

    private int size;

    public CircularLinkedList()
    {
        this.head = null;
        this.tail = null;

        size = 0;
    }

    public void addAfterTail(Node country)
    {
        if (size == 0)
        {
            this.head = country;
            this.tail = country;
        }
        else
        {
            tail.setNext(country);      // Sets the tail's NEXT to be the incoming
            country.setPrev(this.tail); // Setting the previous node to be the tail
            this.head.setPrev(country); // Sets the head's PREVIOUS to be the incoming

            this.tail = country; // Tail is holding the value brought in
            this.tail.setNext(this.head); // Sets the tail's NEXT to be the head
        }
        size++; // Increments the counter, noting that the size of the list has increased
    }

    public void printCircularLinkedList(boolean isReversed)
    {
        int counter = 1;
        if (!isReversed)
        {
            Node current = this.head;   // Creates an instance of the current head
            do
            {
                current.printNode();
                current = current.getNext(); // Sets the current to be whatever comes next, therefore creating a loop
                counter++;
            }
            while(current != this.head);
        }
        else if(isReversed)
        {
            Node current = this.tail;
            do
            {
                current.printNode();
                current = current.getPrev();
                counter++;
            }
            while(current != this.tail);
        }
    }

    public Node selectRandomCountry(boolean isReversed)
    {
        Node current = this.head;
        Random rand = new Random();
        int randInt = rand.nextInt(10);

        if(!isReversed)
        {
            // a for loop to "jump" however many nodes that were randomly generated
            for (int i = 0; i < randInt; i++)
            {
                current = current.getNext();
            }
            System.out.println(current.getCountry());

        }
        else if(isReversed)
        {
            // a for loop to "jump" however many nodes that were randomly generated
            for (int i = 0; i < randInt; i++)
            {
                current = current.getPrev();
            }
            System.out.println(current.getCountry());
        }
        return current;
    }

    public void remove(Node removeNode)
    {
        // If the node we intend to remove is the head
        if (this.head == removeNode)
        {
            this.head = this.head.getNext(); // set the head's next node to be the head
        }
        // If the node we intend to remove is the tail
        else if (this.tail == removeNode)
        {
            this.tail = this.tail.getNext(); // set the head's next node to be the tail
        }

        Node previousNode = removeNode.getPrev(); // Creates an instance of what the incoming node's previous is
        Node followingNode = removeNode.getNext();  // Creates an instance of what the incoming node's next is

        // Sets the nodes to "Look at each other"
        previousNode.setNext(followingNode); // Looks at the PREVIOUS instance of the incoming node and sets its NEXT to be what comes after it
        followingNode.setPrev(previousNode); // Looks at the FOLLOWING instance of the incoming node and sets its PREVIOUS to be what comes after it
        size--;
    }
}
