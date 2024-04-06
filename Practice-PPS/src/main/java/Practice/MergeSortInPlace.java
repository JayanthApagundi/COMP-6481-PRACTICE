package Practice;

public class MergeSortInPlace {

    public static void mergeSort(int[] array,int start,int end) {
        if(end-start==1){
            return;
        }

        int middle = (start+end) / 2;

        mergeSort(array,start,middle);
        mergeSort(array,middle,end);

        merge(array,start,middle,end);
    }

    public static void merge(int[] array, int start, int middle, int end) {
        int i = start; // Index into the left array
        int j = middle; // Index into the right array
        int k = 0; // Index into the result array

        int[] result = new int[end-start];

        // Merge elements from left and right arrays into result array
        while (i < middle && j < end) {
            if (array[i] <= array[j]) {
                result[k] = array[i];
                i++;
            } else {
                result[k] = array[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from left array
        while (i < middle) {
            result[k] = array[i];
            i++;
            k++;
        }

        // Copy any remaining elements from right array
        while (j < end) {
            result[k] = array[j];
            k++;
            j++;
        }

        // Copy elements from result array to original array
        for (int l = 0; l < result.length; l++) {
            array[start+l] = result[l];
        }
    }

    public static void main(String[] args) {
        int[] arr={45,67,34,78,98,43,21,10,19};
        System.out.print("Original Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
        mergeSort(arr,0,arr.length);
        System.out.print("Sorted Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}