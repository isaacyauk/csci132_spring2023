import java.util.ArrayList;
public class CoinFinder
{
    public static void main(String[] args)
    {
        int[] D = {1, 5, 10, 25};
        int k = 16;

        int n = 3;

        find_coins(D, k, n);


    }

    private static void find_coins(int[]d, int k, int n)
    {
        // this is filled with indices of chosen coin values
        int[] chosen = new int[n + 1];

        // index of the chosen thing we're inserting inot
        int index = 0;

        // the bounds of the secion D array
        int start = 0;
        int end = d.length - 1;

        // k is target change amount
        // "Chosen is the array we build up over time, filled with possible combonations
        // n is the desired size of the combonation of coins
        // start and end is going to dicitate the sixe of the array

        calculate_combinations(chosen, d, index, n, start, end, k);
    }

    private static void calculate_combinations(int[] chosen, int[] d, int index, int n, int start, int end, int target)
    {
        // base case
        if (index == n)
        {
            int counter = 0;
            ArrayList<Integer> coins = new ArrayList<Integer>();

            for(int i = 0; i < n; i++)
            {
                counter += d[chosen[i]];
                coins.add(d[chosen[i]]);
            }
            if(counter == target)
            {
                System.out.println(coins);
            }
            return;
        }
        else
        {
            // recursive method; we need to make several branches. do a for loop through all branches
            for (int i = start; i <= end; i++)
            {
                chosen[index] = i;
                calculate_combinations(chosen, d, index + 1, n, i, end, target);
            }
            return;
        }
    }
}
