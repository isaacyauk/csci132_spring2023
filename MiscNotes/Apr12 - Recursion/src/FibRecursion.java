public class FibRecursion
{
    public static void main(String[] args)
    {
        int n = 5; // get the n digit of the Fibonacci sequence. (Hardcoded)
        int answer = fib(n);

        System.out.println(answer);
    }

    private static int fib(int n)
    {
        // base case
        if (n == 1 || n == 2)
        {
            return 1;
        }
        else
        {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
