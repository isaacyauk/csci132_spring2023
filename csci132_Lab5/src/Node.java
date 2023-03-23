public class Node {
    private String movie_name;
    private int release_date;

    private Node next;

    public Node(String movie, int date)
    {
         this.movie_name = movie;
         this.release_date = date;
    }

    public int getReleaseDate()
    {
        return release_date;
    }

    public String getMovieName()
    {
        return this.movie_name;
    }
    public Node getNext()
    {
        return this.next;
    }

    public void setNext(Node next_node)
    {
        this.next = next_node;
    }

    public String getData()
    {
        return "-" + this.movie_name + "(" + this.release_date + ")";
    }
}
