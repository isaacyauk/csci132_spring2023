import java.util.Stack;

public class Lab11Demo
{
    public static String fix_string(String s)
    {
        //TODO: Use recursion to solve this problem
        if(s.length() == 0)
        {
            return "";
        }
        else
        {
            if(s.charAt(0) == 'g')
            {
                return "c" + fix_string(s.substring(1));
            }
            if(s.charAt(0) == 'a')
            {
                return "t" + fix_string(s.substring(1));
            }
            if(s.charAt(0) == 't')
            {
                return "a" + fix_string(s.substring(1));
            }
            if(s.charAt(0) == 'c')
            {
                return "g" + fix_string(s.substring(1));
            }


            else
            {
                return "";
            }
        }
    }

    public static void print_stack_reverse_recursive(Stack<String> incoming_stack)
    {
        if(incoming_stack.size() == 0)
        {
            return;
        }
        else
        {
            String removed = incoming_stack.pop();
            print_stack_reverse_recursive(incoming_stack);

            System.out.println("Original String:");
            System.out.println(removed);
            System.out.println("Fixed String:");

            String corrected_string = fix_string(removed);
            System.out.println(corrected_string);
            System.out.println("-----------");
        }
    }

    //You should NOT change anything below this comment
    public static void main(String[] args)
    {
        Stack<String> stack = new Stack<String>();

        stack.push("ctgtcctt");
        stack.push("agtgccct");
        stack.push("taacgcgg");
        stack.push("ccctcagt");
        stack.push("ggataata");
        stack.push("gtgaatgc");

        System.out.println("Printing out the stack in reverse order:");
        System.out.println();
        print_stack_reverse_recursive(stack);
    }
}