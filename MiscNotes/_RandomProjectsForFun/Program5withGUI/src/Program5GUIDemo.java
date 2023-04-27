import javax.swing.*;
import java.util.Arrays;

public class Program5GUIDemo {

    public static void main(String[] args) {

        // Prompt the user to choose an option
        String[] options = {"Check if Palindrome", "Binary Search", "Exit"};
        int selectedOption = JOptionPane.showOptionDialog(null, "Select an option:", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        // Handle the selected option
        switch (selectedOption) {
            case 0 -> { // Check if Palindrome
                String input = JOptionPane.showInputDialog(null, "Enter a string:");
                boolean isPalindrome = is_palindrome(input);
                String message = "Word Entered: " + input + "\nIs palindrome: " + isPalindrome;
                JOptionPane.showMessageDialog(null, message);
            }
            case 1 -> { // Binary Search
                int[] array = {2, 6, 12, 14, 17, 19, 20, 23, 27, 29, 32, 37, 40, 42, 45};

                // Prompt the user to enter a number to search for
                String searchNumString = JOptionPane.showInputDialog(null, "Enter a number to search for:");
                int searchNum = Integer.parseInt(searchNumString);

                // Call the binary_search method and store the result
                int result = binary_search(array, searchNum, 0, array.length - 1);

                // Display the result to the user
                if (result == -1) {
                    JOptionPane.showMessageDialog(null, searchNum + " was not found in the array.");
                } else {
                    JOptionPane.showMessageDialog(null, searchNum + " is located at index: " + result);
                }
            }
            case 2 -> // Exit
                    System.exit(0);
            default -> {
            }
            // Handle invalid selection
        }
    }


    private static boolean is_palindrome(String str) {
        if (str.length() <= 1) {
            return true;
        } else if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return is_palindrome(str.substring(1, str.length() - 1));
        } else {
            return false;
        }
    }

    private static int binary_search(int[] array, int num, int low, int high) {

        if (low <= high) {
            // Divide the stuff in half and use that number to start looking through either side of the array
            int mid = (low + high) / 2;

            // The case where you find the exact number you're looking for, based on the number you generated above
            if (num == array[mid]) {
                return mid;
            }

            // The case where you look through your array again, if the number you're looking for is greater than the number you generated above
            else if (num > array[mid]) {
                // Adjust the low parameters here, so you don't recurse infinitely
                return binary_search(array, num, mid + 1, high);
            } else {
                // Adjust the high parameters here, so you don't recurse infinitely
                return binary_search(array, num, low, mid - 1);
            }
        } else {
            // Number was not in the array
            return -1;
        }
    }
}
