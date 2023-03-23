import java.util.Objects;

public class SinglyLinkedList
{
    private Node head;
    public SinglyLinkedList()
    {
        this.head = null;
    }

    public void addToBack(Node newMovie)
    {
        if(this.head == null)
        {
            this.head = newMovie;
        }
        else
        {
            Node current = this.head;
            while(current.getNext() != null)
            {
                current = current.getNext();
            }
            current.setNext(newMovie);
        }
    }

    public void removeFirst()
    {
        if(this.head != null)
        {
            this.head = this.head.getNext();
        }
    }

    public void printList()
    {
        Node current = this.head;
        while(current != null)
        {
            System.out.println(current.getData());
            current = current.getNext();
        }

    }

    /* This method uses while loop and a listCount counter to record the number of times
            the loop has run (a.k.a the location of the movie in the List), and prints the
            location of the movie, if it matches the movie it's looking for (m).

            This method also implements two new methods from the Node class, which fetch
            the movie name and release date.
    */
    public void searchForMovie(String m)
    {
        int listCount = 1;
        Node current = this.head;
        boolean isFound = false;

        while(current.getNext() != null)
        {
            if(Objects.equals(current.getMovieName(), m))
            {
                System.out.println("Movie: " + current.getMovieName() + " " + current.getReleaseDate() +
                        " was found at spot #" + listCount);
                isFound = true;

            }
            current = current.getNext();
            listCount++;
        }
        if(isFound == false)
        {
            System.out.println("Movie: " + m + " was not found");
        }
    }

    public void insert(Node newMovie, int N)
    {   // TODO: Get the newMovie inserted at the right location, N
        int listCount = 1;
        Node current = this.head;

        if(N == 1)
        {
            System.out.println("Out of bounds");
        }
        else if (N == getSize())
        {
            System.out.println("Out of bounds");
        }

        while(listCount != N-1)
        {
            current = current.getNext(); // moves to next node
            listCount++;
        }

        Node nextNode = current.getNext(); // pointer of the next thing in the chain
        current.setNext(newMovie); // tracks where we're currently at
        newMovie.setNext(nextNode); // setting comes after the new node to be the new movie

    }

    public int getSize()
    {
        int listCount = 0;
        Node current = this.head;
        while(current != null)
        {
            current = current.getNext();
            listCount++;
        }
        return listCount;
    }
}