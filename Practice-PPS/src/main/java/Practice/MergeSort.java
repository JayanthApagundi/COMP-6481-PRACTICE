package Practice;

public class MergeSort {

    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return; // Base case: if the array has 0 or 1 elements, it is already sorted
        }

        int middle = array.length / 2;

        // Divide the array into two halves
        int[] left = new int[middle];
        int[] right = new int[array.length - middle];
        // Copy elements from array to left array
        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }

        // Copy elements from array to right array
        for (int i = middle; i < array.length; i++) {
            right[i - middle] = array[i];
        }

        // Recursively sort each half
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(array, left, right);
    }

    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0; // Index into the left array
        int j = 0; // Index into the right array
        int k = 0; // Index into the result array

        // Merge elements from left and right arrays into result array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from left array
        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }

        // Copy any remaining elements from right array
        while (j < right.length) {
            result[k] = right[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {45, 67, 34, 78, 98, 43, 21, 10, 19};
        System.out.print("Original Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        mergeSort(arr);
        System.out.print("Sorted Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}