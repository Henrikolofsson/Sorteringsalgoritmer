package algorithms;

public class MergeSort {
    /*
        MergeSort without switching to InsertionSort for dealing with smaller quantities of data.
     */
    public int[] mergeSort(int[] tempArr, int[] array, int low, int high) {
        if(high <= low) {
            return array;
        } else {
            int mid = (int) Math.floor((high + low) / 2);
            mergeSort(tempArr, array, low, mid);
            mergeSort(tempArr, array, mid + 1, high);
            merge(tempArr, array, low, mid, high);
        }
        return array;
    }

    /*
        MergeSort with M amount of integers given. When high - low < m (high - low, being the interval between the indexes),
        switch to InsertionSort which is a more efficient sorting method when dealing with smaller quantities of data.
     */
    public int[] mergeSort(int[] tempArr, int[] array, int low, int high, int m) {
        if(high <= low) {
            return array;
        } else {
            if(high - low < m) {
                insertionSort(array, low, high);
            } else {
                int mid = (int) Math.floor((high + low) / 2);
                mergeSort(tempArr, array, low, mid);
                mergeSort(tempArr, array, mid + 1, high);
                merge(tempArr, array, low, mid, high);
            }
        }
        return array;
    }

    public void merge(int[] tempArr, int[] array, int low, int mid, int high) {
        for(int k = low; k <= high; k++) {
            tempArr[k] = array[k];
        }
        int i = low, j = mid + 1;
        for(int k = low; k <= high; k++) {
            if(i > mid) {
                array[k] = tempArr[j];
                j++;
            } else if(j > high) {
                array[k] = tempArr[i];
                i++;
            } else if(tempArr[i] < tempArr[j]) {
                array[k] = tempArr[i];
                i++;
            } else {
                array[k] = tempArr[j];
                j++;
            }
        }
    }


    static void insertionSort(int[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && a[j] < a[j-1]; j--) {
                int x = a[j]; a[j] = a[j-1]; a[j-1] = x;
            }
        }
    }
}
