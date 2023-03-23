import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class LinkedListBattle
{
    private Node head;
    private Node tail;

    private int sizeOfList;

    public LinkedListBattle()
    {
        this.head = null;
        this.tail = null;
        this.sizeOfList = 0;
    }

    public Node getHead()
    {
        return this.head;
    }

    public int getListSize()
    {
        return this.sizeOfList;
    }

    public void fillChallengerList(String filename)
    {
        String line = "";
        try
        {
            BufferedReader br = new BufferedReader( new FileReader(filename));
            while( (line=br.readLine()) != null )
            {
                String[] vals = line.split(",");
                String name = vals[0];
                int power_lvl = Integer.parseInt(vals[1]);

                Node n = new Node(name, power_lvl);
                insert(n, this.sizeOfList+1);
            }
        }
        catch (Exception e)
        {
            System.out.println("File not found.");
        }
    }

    public void insert(Node incomingNode, int n)
    {
        // If the list is empty
        if(this.sizeOfList == 0)
        {
            this.head = incomingNode;
            this.tail = incomingNode;
        }
        // Insert at the beginning
        else if (n == 1)
        {
            this.head.setPrev(incomingNode);
            incomingNode.setNext(this.head);
            this.head = incomingNode;

            // CLL: Making sure that the list is circular by attaching the tail and head
            this.head.setPrev(this.tail);
            this.tail.setNext(this.head);
        }
        // Insert at the end
        else if (n == this.sizeOfList+1)
        {
            this.tail.setNext(incomingNode);
            incomingNode.setPrev(this.tail);
            this.tail = incomingNode;

            // CLL: Making sure that the list is circular by attaching the tail and head
            this.head.setPrev(this.tail);
            this.tail.setNext(this.head);
        }
        // Insert in the middle
        else
        {
            Node current = this.head;
            for (int i = 1; 1 < n-1; i++)
            {
                current = current.getNext();
            }
            Node nextNode = current.getNext();
            current.setNext(incomingNode);
            incomingNode.setPrev(current);
            nextNode.setPrev(incomingNode);
            incomingNode.setNext(nextNode);
        }
        this.sizeOfList++;
    }

    public void printLinkedList()
    {
        Node current = this.head;
        do
        {
            current.printNode();
            current = current.getNext();
        }
        while(current != this.head);
    }

    public void simulateOneRound()
    {
        Node challenger1 = this.head;
        Node challenger2 = this.tail;
        Random randJ = new Random();
        Random randK = new Random();
        int randIntJ = randJ.nextInt(sizeOfList);
        int randIntK = randK.nextInt(sizeOfList);

        System.out.println("j: " + randIntJ);
        System.out.println("k: " + randIntK);

        // Selects and prints the first challenger
        System.out.println("Nodes Selected:");
        for(int i = 0; i < randIntJ; i++)
        {
            challenger1 = challenger1.getNext();
        }
        System.out.println("+---------------------+\n" + challenger1.getName() + "\n" + "Power Level: " + challenger1.getPowerLevel());
        System.out.println("vs.");

        // Selects and then prints the second challenger
        for(int i = 0; i < randIntK; i++)
        {
            challenger2 = challenger2.getPrev();
        }

        // Compares the challenger1 and challenger2 (or clockwise and counterclockwise) selections and
        //      increments the challenger2 by one if a duplicate value is found.
        if(challenger1 == challenger2)
        {
            challenger2 = challenger2.getPrev();
        }
        System.out.println(challenger2.getName() + "\n" + "Power Level: " + challenger2.getPowerLevel() + "\n+---------------------+");

        // Complete the round by determining the winner, based on power level
        if(challenger1.getPowerLevel() > challenger2.getPowerLevel())
        {
            removeFromCircle(challenger2);
            System.out.println(challenger1.getName() + " wins!");
            System.out.println(challenger2.getName() + " was eliminated.\n");
        }
        else if (challenger1.getPowerLevel() < challenger2.getPowerLevel())
        {
            removeFromCircle(challenger1);

            System.out.println(challenger2.getName() + " wins!");
            System.out.println(challenger1.getName() + " was eliminated.\n");
        }
        else
        {
            System.out.println("Challenger tie. Maaaaaaaaaaaaaan that's lame!\n");
        }
    }

    public void removeFromCircle(Node nodeToDelete)
    {
        if (this.head == nodeToDelete)
        {
            this.head = this.head.getNext();
        }
        else if (this.tail == nodeToDelete)
        {
            this.tail = this.tail.getNext();
        }

        Node previousNode = nodeToDelete.getPrev();
        Node followingNode = nodeToDelete.getNext();

        previousNode.setNext(followingNode);
        followingNode.setPrev(previousNode);
        sizeOfList--;
    }
}
