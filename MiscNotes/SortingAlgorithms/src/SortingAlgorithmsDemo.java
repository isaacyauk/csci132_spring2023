import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class SortingAlgorithmsDemo
{

    public static void main(String[] args)
    {

        SortingAlgorithm sort = new SortingAlgorithm();

        int[] array = sort.getRandomArray(15);
        System.out.println(Arrays.toString(array));
        long start_time = System.nanoTime();

        int[] sorted_array = sort.selectionSort(array);
        long end_time = System.nanoTime();
        double elapsed_time = (end_time - start_time) / 1000000.0; // 6 zeroes is milliseconds; 9 zeroes is seconds
        System.out.println("Elapsed time: " + elapsed_time + " milliseconds.");

        System.out.println(Arrays.toString(sorted_array));

    }
}