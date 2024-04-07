package Practice;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if(low>=high){
            return;
        }

        int start= low;
        int end= high;
        int mid= start+(end-start)/2;
        int pivot= arr[mid];

        while(start<=end){
            while(arr[start]<pivot){
                start++;
            }
            while(arr[end]>pivot){
                end--;
            }
            if(start<=end){
                int temp= arr[start];
                arr[start]= arr[end];
                arr[end]= temp;
                start++;
                end--;
            }
        }

        quickSort(arr,low,end);
        quickSort(arr,start,high);
    }

    public static void main(String[] args) {

            int[] arr={45,67,34,78,98,43,21,10,19};
            System.out.print("Original Array: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
            quickSort(arr,0,arr.length-1);
            System.out.print("Sorted Array: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+ " ");
            }
    }
}