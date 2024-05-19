package Practice;
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
//                for (int k = 0; k < arr.length; k++) {
//                    System.out.print(arr[k]+ " ");
//                }
//                System.out.println();
            }
        }
    }
    public static void main(String[] args) {

        int[] arr={23,32,72,76,22,73,40,30,20,60,16,74,28,14};
//        System.out.print("Original Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
        bubbleSort(arr);
//        System.out.print("Sorted Array: ");
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+ " ");
//        }

    }
}