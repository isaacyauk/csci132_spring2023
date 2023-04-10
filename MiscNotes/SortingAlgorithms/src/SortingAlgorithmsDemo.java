import java.util.Arrays;

public class SortingAlgorithmsDemo {

    public static void main(String[] args) {

        SortingAlgorithm sort = new SortingAlgorithm();

        int[] array = sort.getRandomArray(10);
        System.out.println(Arrays.toString(array));

        int[] sorted_array = sort.bubble_sort(array);
        System.out.println(Arrays.toString(sorted_array));

    }

}