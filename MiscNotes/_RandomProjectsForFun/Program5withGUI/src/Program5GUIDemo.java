import javax.swing.*;

public class Program5GUIDemo {

    public static void main(String[] args)
    {
        String input = JOptionPane.showInputDialog(null, "Enter a string:");
        boolean isPalindrome = is_palindrome(input);
        String message = "Word Entered: " + input + "\n Is palindrome: " + isPalindrome;
        JOptionPane.showMessageDialog(null, message);
    }

    private static boolean is_palindrome(String str)
    {
        if (str.length() <= 1)
        {
            return true;
        }
        else if (str.charAt(0) == str.charAt(str.length() - 1))
        {
            return is_palindrome(str.substring(1, str.length() - 1));
        }
        else
        {
            return false;
        }
    }
}
