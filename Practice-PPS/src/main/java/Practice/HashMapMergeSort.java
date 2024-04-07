package Practice;

class MapEntry<K, V> {
    K key;
    V value;
    MapEntry<K, V> next;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class CustomHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private MapEntry<K, V>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        this.buckets = new MapEntry[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        MapEntry<K, V> entry = buckets[index];
        if (entry == null) {
            buckets[index] = new MapEntry<>(key, value);
        } else {
            while (entry.next != null) {
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            entry.next = new MapEntry<>(key, value);
        }
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        MapEntry<K, V> entry = buckets[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public MapEntry<K, V>[] getBuckets() {
        return buckets;
    }

    public int getSize() {
        return size;
    }
}

public class HashMapMergeSort {
    public static <K extends Comparable<? super K>, V> void mergeSort(CustomHashMap<K, V>[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static <K extends Comparable<? super K>, V> void merge(CustomHashMap<K, V>[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        CustomHashMap<K, V>[] leftArr = new CustomHashMap[n1];
        CustomHashMap<K, V>[] rightArr = new CustomHashMap[n2];

        // Copy elements to leftArr
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }

        // Copy elements to rightArr
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            MapEntry<K, V>[] leftBuckets = leftArr[i].getBuckets();
            MapEntry<K, V>[] rightBuckets = rightArr[j].getBuckets();

            int leftIndex = 0, rightIndex = 0;

            // Find the first non-null entry in leftArr[i]
            while (leftIndex < leftBuckets.length && leftBuckets[leftIndex] == null) {
                leftIndex++;
            }

            // Find the first non-null entry in rightArr[j]
            while (rightIndex < rightBuckets.length && rightBuckets[rightIndex] == null) {
                rightIndex++;
            }

            if (leftIndex < leftBuckets.length && rightIndex < rightBuckets.length) {
                if (leftBuckets[leftIndex].key.compareTo(rightBuckets[rightIndex].key) <= 0) {
                    arr[k++] = leftArr[i++];
                } else {
                    arr[k++] = rightArr[j++];
                }
            } else if (leftIndex < leftBuckets.length) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }


    public static void main(String[] args) {
        CustomHashMap<Integer, String>[] arr = new CustomHashMap[5];
        arr[0] = new CustomHashMap<>();
        arr[0].put(3, "apple");
        arr[3] = new CustomHashMap<>();
        arr[3].put(5, "grapes");
        arr[4] = new CustomHashMap<>();
        arr[4].put(6, "mango");
        arr[1] = new CustomHashMap<>();
        arr[1].put(2, "banana");
        arr[2] = new CustomHashMap<>();
        arr[2].put(1, "orange");

        System.out.println("Array before sorting:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nArray after sorting:");
        printArray(arr);
    }

    public static void printArray(CustomHashMap<?, ?>[] arr) {
        for (CustomHashMap<?, ?> map : arr) {
            if (map!=null && map.getSize() > 0) {
                System.out.print("Key-Value pairs: ");
                for (MapEntry<?, ?> entry : map.getBuckets()) {
                    while (entry != null) {
                        System.out.print("(" + entry.key + ", " + entry.value + ") ");
                        entry = entry.next;
                    }
                }
                System.out.println();
            }
        }
    }
}


