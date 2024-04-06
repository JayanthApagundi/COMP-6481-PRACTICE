package Practice;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                return binarySearchRecursive(arr, target, mid + 1, right);
            } else {
                return binarySearchRecursive(arr, target, left, mid - 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // input to be sorted for Binary Search
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 2;

        int index = binarySearch(arr, target);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }

        int indexRecursive = binarySearchRecursive(arr, target, 0, arr.length - 1);
        if (indexRecursive != -1) {
            System.out.println("Element found at index (Recursive): " + indexRecursive);
        } else {
            System.out.println("Element not found (Recursive)");
        }
    }
}
