import java.util.LinkedList;
public class RecursionFun
{
    public static String string_star(String s)
    {
        if (s.length() == 1)
        {
            return s;   // Base case
        }
        else
        {
            if(s.charAt(0) == s.charAt(1))  // returns characters, primitive data type
            {
                return s.charAt(0) + "*" + string_star(s.substring(1));     //substring takes everything after the n char
            }
            else
            {
                return s.charAt(0) + string_star(s.substring(1));
            }
        }
    }

    public static void print_LL(LinkedList<String> incoming_ll)
    {
        if(incoming_ll.size() == 1)
        {
            System.out.println(incoming_ll.getFirst());
        }
        else
        {
            System.out.println(incoming_ll.removeFirst());   //removes but also returns it!
            print_LL(incoming_ll);
        }
    }

    public static void print_LL_reversive(LinkedList<String> incoming_ll)
    {
        if(incoming_ll.size() == 1)
        {
            System.out.println(incoming_ll.getFirst());
        }
        else
        {
            String removed = incoming_ll.removeFirst();
            print_LL_reversive(incoming_ll);

            System.out.println(removed);
        }
    }

    public static void main(String[] args)
    {
         String s = "aabbcc";
         String answer = string_star(s);
        System.out.println(answer);

        LinkedList<String> ll = new LinkedList<String>();

        ll.add("First");
        ll.add("Second");
        ll.add("Third");
        ll.add("Fourth");

        //print_LL(ll);
        print_LL_reversive(ll);
    }
}
