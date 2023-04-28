import java.util.Arrays;
public class Program5Demo {

    public static void main(String[] args) {

        System.out.println("Part I: Palindromes");

        String test;
        boolean answer;

        test = "racecar";
        answer = is_palindrome(test);
        System.out.println("Word: " + test + ", Is palindrome: " + answer);

        test = "aa";
        answer = is_palindrome(test);
        System.out.println("Word: " + test + ", Is palindrome: " + answer);


        test = "computer";
        answer = is_palindrome(test);
        System.out.println("Word: " + test + ", Is palindrome: " + answer);

        System.out.println("-----------------------------------------------------");

        System.out.println("Part II: Binary Search");
        int[] array = {2, 6, 12, 14, 17, 19, 20, 23, 27, 29, 32, 37, 40, 42, 45};
        int num, answer2;

        int low = 0;
        int high = array.length - 1;

        System.out.println(Arrays.toString(array));

        num = 12;
        answer2 = binary_search(array,num,low,high);
        System.out.println(num + " is located at index: " + answer2);

        num = 45;
        answer2 = binary_search(array,num,low,high);
        System.out.println(num + " is located at index: " + answer2);

        num = 29;
        answer2 = binary_search(array,num,low,high);
        System.out.println(num + " is located at index: " + answer2);

        num = 55;
        answer2 = binary_search(array,num,low,high);
        System.out.println(num + " is located at index: " + answer2);

        System.out.println("-----------------------------------------------------");
        System.out.println("Part III and IV: Finding minimum number of coins");
        int k; //target value
        int n; // answer for part III
        int[] D = {1, 5, 10, 18, 25};

        k = 37; //find minimum number of coins from D to make value K
        n = min_coins(D, k);
        System.out.println("Minimum coins needed to create " + k + ": " + n);
        System.out.println("Coins used:");
        find_coins(D,k,n);

        k = 4; //find minimum number of coins from D to make value K
        n = min_coins(D, k);
        System.out.println("Minimum coins needed to create " + k + ": " + n);
        System.out.println("Coins used:");
        find_coins(D,k,n);

        k = 19; //find minimum number of coins from D to make value K
        n = min_coins(D, k);
        System.out.println("Minimum coins needed to create " + k + ": " + n);
        System.out.println("Coins used:");
        find_coins(D,k,n);

    }

    private static boolean is_palindrome(String str)
    {
        if (str.length() <= 1)
        {
            // An empty string is technically a palindrome.
            return true;
        }
        else if (str.charAt(0) == str.charAt(str.length() - 1))
        {
            // Recursive case where the first and last char are checked to see if they're matching; a non-palindrome will not pass this check
            return is_palindrome(str.substring(1, str.length() - 1));
        }
        else
        {
            return false;
        }
    }

    private static int binary_search(int[] array, int num, int low, int high) {

        if (low <= high)
        {
            // Divide the stuff in half and use that number to start looking through either side of the array
            int mid = (low + high ) / 2;

            // The case where you find the exact number you're looking for, based on the number you generated above
            if (num == array[mid])
            {
                return mid;
            }

            // The case where you look through your array again, if the number you're looking for is greater than the number you generated above
            else if(num > array[mid])
            {
                // Adjust the low parameters here, so you don't recurse infinitely
                return binary_search(array, num, mid + 1, high);
            }
            else
            {
                // Adjust the high parameters here, so you don't recurse infinitely
                return binary_search(array, num, low, mid - 1);
            }
        }
        else
        {
            // Number was not in the array
            return -1;
        }
    }


    private static int min_coins(int[] coins, int total_change)
    {
        // If you're making change for $0.00
        if (total_change == 0)
        {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int a = Integer.MAX_VALUE;

        for (int some_coin: coins)
        {
            if ((total_change - some_coin) >= 0)
            {
                a = min_coins(coins, total_change - some_coin);
            }
            if (a < min)
            {
                min = a;
            }
        }
        return 1 + min;
    }

    private static void find_coins(int[] d, int k, int n) {

        //TODO: Part I: Fill in method using recursion, or have it call another method that uses recursion

    }



}