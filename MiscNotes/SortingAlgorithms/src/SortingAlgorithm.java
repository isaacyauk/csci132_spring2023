import java.util.Random;
public class SortingAlgorithm
{

    public int[] getRandomArray(int n)
    {
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < array.length; i++)
        {
            array[i] = random.nextInt(101); // bound number is NOT included
        }

        return array;
    }

    public int[] bubble_sort(int[] array)
    {
        int n = array.length;
        for(int i = 0; i < n - 1; i++)
        {
            for(int j = 0; j < n - i - 1; j++)
            {
                if ( array[j] > array[j + 1])
                {
                    //swap
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;

                }
            }
        }

        return array;
    }

    public int[] selectionSort(int[] array)
    {
        int arrSize = array.length;
        for(int i = 0; i < arrSize - 1; i++)
        {
            for (int j = i + 1; j < arrSize; j++)
            {
                int min_index_so_far = i;

                if(array[j] < array[min_index_so_far])
                {
                    min_index_so_far = j;
                }
                int temp = array[i];
                array[i] = array[min_index_so_far];
                array[min_index_so_far] = temp;
            }
        }

        return array;
    }

    // Slices up an array by taking smaller and smaller chunks of the array, and sorting thorugh THOSE
    public int[] quick_sort(int[] array, int start, int end)
    {
       // Base Case
       if (end <= start)
       {
           return array;
       }

       int pivot = partition(array, start, end);
       quick_sort(array, start, pivot-1); // left side of the array
       quick_sort(array, pivot+1, end); // right side of the array

       return array;
    }

    private int partition(int[] array, int start, int end)
    {
        int pivot = array[end];
        int i = start - 1;

        for (int j = start; j < end - 1; j++)
        {
            if (array[j] < pivot)
            {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }
}