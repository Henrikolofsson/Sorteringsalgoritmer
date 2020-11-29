import algorithms.QuickSort;
import algorithms.QuickSort2;
import algorithms.QuickZort;

import java.util.Arrays;

public class testquicksort {

    public static void main(String[] args) {
        QuickSort2 quickSort = new QuickSort2();
        /*QuickZort quickZort = new QuickZort();*/
        int[] testArray = {5, 9, 4, 6, 5, 3};
        int n = testArray.length;
        System.out.println(Arrays.toString(testArray));
        quickSort.quickSort(testArray, 0, n-1);
        /*quickZort.sort(testArray, 0, n-1);*/
        System.out.println(Arrays.toString(testArray));
    }
}
