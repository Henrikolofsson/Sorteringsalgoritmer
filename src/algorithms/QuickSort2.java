package algorithms;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {
    // Shuffles the first n elements of a.
    public static void shuffle(int[] a, int lo, int hi) {
        Random rand = new Random();
        for (int i = lo; i <= hi; i++) {
            int r = i + rand.nextInt(hi + 1 - i);     // between i and hi
            int t = a[i];
            a[i] = a[r];
            a[r] = t;
        }
    }

    public int[] quickSort(int[] arr, int low, int high) {
        //shuffle(arr, low, high);
        if (high <= low) {
            return arr;
        } else {
            int p = partition(arr, low, high);
            quickSort(arr, low, p);
            quickSort(arr, p + 1, high);
        }
        return arr;
    }

    private int partition(int[] arr, int low, int high) {
       int p = arr[low];
       int i = low-1;
       int j = high+1;

       while(true) {
           while(++i < high && arr[i] < p);

           while(--j > low && arr[j] > p);

           if(i < j) {
               swap(arr, i, j);
           } else {
               return j;
           }
       }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}