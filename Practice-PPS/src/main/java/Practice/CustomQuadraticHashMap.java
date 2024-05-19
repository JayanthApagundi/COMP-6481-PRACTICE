// Quadratic Probing ???

package Practice;

public class CustomQuadraticHashMap {
    private static final int SIZE = 128; // Size of the hashmap
    private String[][] map = new String[SIZE][2]; // Each element stores a String array of [key, value]

    private int hash(String key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    public void put(String key, String value) {
        int index = hash(key);
        int i = 0;
        int quadratic = 1;
        while (map[index][0] != null) {
            if (map[index][0].equals(key)) {
                // If the key already exists, replace the value
                map[index][1] = value;
                return;
            }
            i++;
            index = (hash(key) + quadratic) % SIZE; // Quadratic probing
            quadratic = 2 * i; // Increase the quadratic distance
            if (i >= SIZE) { // Prevent infinite loop
                throw new RuntimeException("Hashmap is full");
            }
        }
        map[index][0] = key;
        map[index][1] = value;
    }

    public String get(String key) {
        int index = hash(key);
        int i = 0;
        int quadratic = 1;
        while (map[index][0] != null) {
            if (map[index][0].equals(key)) {
                return map[index][1];
            }
            i++;
            index = (hash(key) + quadratic) % SIZE; // Quadratic probing
            quadratic = 2 * i; // Increase the quadratic distance
            if (i >= SIZE) { // Prevent infinite loop
                return null;
            }
        }
        return null;
    }

    public String remove(String key) {
        int index = hash(key);
        int i = 0;
        int quadratic = 1;
        while (map[index][0] != null) {
            if (map[index][0].equals(key)) {
                String value = map[index][1];
                map[index][0] = null; // Mark this slot as deleted for key
                map[index][1] = null; // and value
                return value;
            }
            i++;
            index = (hash(key) + quadratic) % SIZE; // Quadratic probing
            quadratic = 2 * i; // Increase the quadratic distance
            if (i >= SIZE) { // Prevent infinite loop
                return null;
            }
        }
        return null;
    }
}