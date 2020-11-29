package algorithms;

/**
 * Quicksort algorithm.
 * @Author Daniel Wikander
 */
public class QuickZort {
    public int[] sort(int[] a, int lo, int hi) {
        if (lo < hi) {                      // If lo < hi; array is already sorted
            int p = partition(a, lo, hi);   // Create partitions
            sort(a, lo, p);                 // Sort left side of array
            sort(a, p + 1, hi);          // Sort right side of array
        }
        return a;                           // Return sorted array
    }

    private int partition(int[] a, int lo, int hi) {

        // Choose pivot point
        //int pivot = a[lo + rand.nextInt(hi - lo)]; // Random pivot
        int pivot = a[lo + (hi - lo) / 2]; // Midpoint pivot
        //int pivot = a[lo];   // Lowpoint pivot
        //int pivot = a[hi-1]; // Highpoint pivot

        int i = lo - 1; // Set left side index
        int j = hi + 1; // Set right side index

        while (true) {
            while (++i < hi && a[i] < pivot) ; // Increment i until a[i] is greater than pivot
            while (--j > lo && a[j] > pivot) ; // Decrement j until a[j] is less than pivot

            if (i < j) {                       // If i < j, swap elements positions.
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            } else {
                return j;                      // Else return j as partitioning point.
            }
        }
    }
}
