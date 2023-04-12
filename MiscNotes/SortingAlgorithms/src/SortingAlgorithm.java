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
}