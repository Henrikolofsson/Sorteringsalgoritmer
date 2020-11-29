import algorithms.MergeSort;
import algorithms.QuickSort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class main {

    /*
        @Author: Jesper Larsson
     */
    static int[] readFile(String filename) throws Exception {
        // Read file into a byte array, and then combine every group of four bytes to an int. (Not
        // the standard way, but it works!)
        byte[] bytes = Files.readAllBytes(Paths.get(filename));
        int[] ints = new int[bytes.length/4];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < 4; j++) { ints[i] += (bytes[i*4+j] & 255) << (3-j)*8; }
        }
        return ints;
    }

    /*
        @Author: Jesper Larsson
    */
    private static boolean isSorted(int[] a, int lo, int hi) {
        // Checks if the first n element of a are in sorted order.
        int flaws = 0;
        for (int i = lo+1; i <= hi; i++) {
            if (a[i] < a[i-1]) {
                if (flaws++ >= 10) {
                    System.out.println("...");
                    break;
                }
                System.out.println("a["+(i-1)+"] = "+a[i-1]+", a["+i+"] = "+a[i]);
            }
        }
        return flaws == 0;
    }

    public static void main(String[] arg) throws Exception {
        //int m = 100;
       // while(m <= 409600) {
            int N = 1;
            //  while (m <= 1000) {
            while (N < 1019444) { //LargeInts and SmallInts size = 1019444
                MergeSort mergeSort = new MergeSort();
                QuickSort quickSort = new QuickSort();
                int[] smallInts = readFile("src/files/smallints");
                int[] largeInts = readFile("src/files/largeInts");
                int[] smallTemp = new int[smallInts.length];
                int[] largeTemp = new int[largeInts.length];


                //System.out.println("M: " + m);
                System.out.println("Number of elements: " + N);

                // Look at numbers before sorting, unless there are too many of them.
                if (N <= 1000) {
                    for (int i = 0; i < N; i++) {
                        System.out.print(smallInts[i] + " ");
                    }
                    System.out.print("\n\n");
                }


                long before = System.currentTimeMillis();

                //Sorting with merge sort on small ints WITHOUT InsertionSort
                //mergeSort.mergeSort(smallTemp, smallInts, 0, N - 1);

                //Sorting with merge sort on small ints WITH InsertionSort
                //mergeSort.mergeSort(smallTemp, smallInts, 0, N - 1, m);

                //Sorting with merge sort on large ints WITHOUT InsertionSort
                //mergeSort.mergeSort(largeTemp, largeInts, 0, N - 1);

                //Sorting with merge sort on large ints WITH InsertionSort
                //mergeSort.mergeSort(largeTemp, largeInts, 0, N - 1, m);

                //Sorting with quick sort WITHOUT InsertionSort
                quickSort.quickSort(smallInts, 0, N - 1);

                // Look at numbers before sorting, unless there are too many of them.
                if (N <= 1000) {
                    for (int i = 0; i < N; i++) {
                        System.out.print(smallInts[i] + " ");
                    }
                    System.out.print("\n\n");
                }



                long after = System.currentTimeMillis();
                System.out.println(((before - after) / 1000) + " seconds");

                if (isSorted(smallInts, 0, N - 1)) {
                    System.out.println((after - before) / 1000.0 + " seconds");
                }

                N = N * 2;
            }
           // m = m * 2;
       // }
    }
}
