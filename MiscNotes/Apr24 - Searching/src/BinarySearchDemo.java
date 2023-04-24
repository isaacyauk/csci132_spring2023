public class BinarySearchDemo
{
    public static void main(String[] args)
    {
        int[] array = {1, 3, 7, 10, 12, 15, 20, 21, 25};

        // Target value we're looking for
        int target = 15;

        int answer = binary_search(array, target);
        System.out.println(target + " is located at index: " +answer);
    }

    public static int binary_search(int[] array, int target)
    {
        int low = 0;
        int high = array.length - 1;

        while(low <= high)
        {
            System.out.println("Low: " + low + " High: "+ high);
            int mid = (low + high) / 2;
            if (target == array[mid])
            {
                return mid;
            }
            else if (target > array[mid])
            {
                // discard left section
                low = mid + 1;

            }
            else
            {
                // discard right section
                high = mid - 1;
            }
        }

        // did not find what we were looking for
        return -1;

    }


}


