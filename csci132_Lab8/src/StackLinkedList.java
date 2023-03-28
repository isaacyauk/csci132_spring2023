import java.util.LinkedList;
public class StackLinkedList
{
    // 'Technically' a book, but this is
    private LinkedList<String> data;
    private String top_of_stack;
    private int size;

    public StackLinkedList()
    {
        this.data = new LinkedList<String>();
        this.top_of_stack = null;
        this.size = 0;
    }

    public void push(String newBookTitle)
    {
        this.data.addFirst(newBookTitle);
        this.size++;
        this.top_of_stack = this.data.getFirst();
    }

    public String pop()
    {
        if(this.size != 0)
        {
            String removedThing = this.data.getFirst();
            this.data.removeFirst();
            this.size--;

            if(this.size != 0)
            {
                this.top_of_stack = data.getFirst();
            }
            return removedThing;

        }
        else
        {
            return null;
        }

    }

    public void printStack()
    {
        for (int i = 0; i < this.size; i++)
        {
            System.out.println((i + 1) + ". " + this.data.get(i));
        }
    }

    public String peek()
    {
        if (this.size != 0)
        {
            return this.top_of_stack;
        }
        else
        {
            return null;
        }
    }

    public String getSize()
    {
        return Integer.toString(this.size);
    }

    // If a false case is triggered, function call will skip
    public boolean isEmpty()
    {
        return this.size == 0;
    }
}
