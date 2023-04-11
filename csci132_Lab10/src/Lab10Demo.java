import java.util.Arrays;
import java.util.Random;

public class Lab10Demo {

    public static int[] getRandomArray(int n) {
        int[] array = new int[n];
        Random random = new Random();
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101);
        }
        return array;
    }

    public static int[] selection_sort(int[] array)
    {
        int start_index = array.length;
        for (int i = 0; i < start_index - 1; i++) // Looping through the number of things in the array - 1 (cuz the last idx should be sorted)
        {
            int min_pos = i;
            for (int j = i + 1; j < start_index; j++) // Looping through the content of the array and sorting it
            {
                // Check to see if the current index is lowest and if it is, set it to the min_pos
                if (array[j] < array[min_pos]) // j is the content of the array
                {
                    min_pos = j;
                }
            }

                // Does the hokey pokey swappy boppy here
                int temp = array[min_pos];
                array[min_pos] = array[i];
                array[i] = temp;
        }
        return array;
    }

    public static void main(String[] args) {

        // Sort an array of size 15
        int[] array1 = getRandomArray(15); //TODO: CHANGE THIS BACK TO 15 BEFORE SUBMIT
        System.out.println("Input: " + Arrays.toString(array1));
        long start_time = System.nanoTime();
        int[] sorted_array = selection_sort(array1);
        long end_time = System.nanoTime();
        double elapsed_time = (end_time - start_time) / 1000000.0;
        System.out.println("Time taken: " + elapsed_time + " ms");
        System.out.println("Output: " + Arrays.toString(sorted_array));

        System.out.println("");

        // Sort an array of size 1000
        int[] array2 = getRandomArray(1000);
        System.out.println("Input: " + Arrays.toString(array2));
        start_time = System.nanoTime();
        sorted_array = selection_sort(array2);
        end_time = System.nanoTime();
        elapsed_time = (end_time - start_time) / 1000000.0;
        System.out.println("Time taken: " + elapsed_time + " ms");
        System.out.println("Output: " + Arrays.toString(sorted_array));
    }

}