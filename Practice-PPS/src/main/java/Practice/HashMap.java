package Practice;

class HashmapWithDLinkedList<K,V> {
    class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        Entry<K, V> prev;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    Entry<K, V>[] arrayLL;
    int capacity;
    int size;

    public HashmapWithDLinkedList(int capacity) {
        this.capacity = capacity;
        this.arrayLL = new Entry[capacity];
        this.size = 0;
    }

    int HashFunction(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = HashFunction(key);
        Entry<K, V> entry = arrayLL[index];

        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }

        Entry<K, V> newEntry = new Entry<>(key, value);
        if (arrayLL[index] == null) {
            arrayLL[index] = newEntry;
            size++;
        } else {
            newEntry.next = arrayLL[index];
            arrayLL[index].prev = newEntry;
            arrayLL[index] = newEntry;
            size++;
        }
    }

    public void display() {
        for (Entry<K, V> s : arrayLL) {
            Entry<K, V> entry = s;
            while (entry != null) {
                System.out.println("Key: " + entry.key + ", Value: " + entry.value);
                entry = entry.next;
            }
        }
    }

    public V get(K key){
        int index = HashFunction(key);
        Entry<K, V> entry = arrayLL[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public int size(){
        return size;
    }

    public V remove(K key){
        int index = HashFunction(key);
        Entry<K, V> entry = arrayLL[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                if (entry.prev == null) {
                    arrayLL[index] = entry.next;
                } else {
                    entry.prev.next = entry.next;
                }
                if (entry.next != null) {
                    entry.next.prev = entry.prev;
                }
                size--;
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }
}

public class HashMap {
    public static void main(String[] args) {

        HashmapWithDLinkedList<Integer, String> map = new HashmapWithDLinkedList<>(10);
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");
        map.put(6, "F");
        map.put(7, "G");
        map.put(8, "H");
        map.put(9, "I");
        map.put(10, "J");
        map.put(11, "K");
        map.put(12, "L");
        map.put(13, "M");
        map.put(14, "N");
        map.put(15, "O");
        map.put(16, "P");
        map.put(17, "Q");
        map.put(18, "R");
        map.put(19, "S");
        map.put(20, "T");
        map.put(21, "U");
        map.put(22, "V");
        map.put(23, "W");
        map.put(24, "X");
        map.put(25, "Y");
        map.put(26, "Z");

        System.out.println("Value at key 2: " + map.get(2));
        map.display();
        System.out.println(map.size());

        System.out.println(map.remove(7));
    }
}
