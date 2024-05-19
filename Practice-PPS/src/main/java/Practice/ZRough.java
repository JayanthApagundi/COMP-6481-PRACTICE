package Practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ZRough {
    public static void main(String[] args) {
        // Create a custom comparator for PriorityQueue to sort strings based on their length
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        // Add custom strings to test the PriorityQueue
        pq.add("grapefruit");
        pq.add("banana");
        pq.add("apple");
        pq.add("orange");
        pq.add("Jackfruit");

        // Print each string value after sorting
        System.out.println("Strings sorted by length:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
