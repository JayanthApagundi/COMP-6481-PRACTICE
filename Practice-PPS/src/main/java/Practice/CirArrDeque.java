package Practice;

class CirArrDeque {
    private int maxSize; // maximum size of the deque
    private int[] dequeArray; // array to hold the deque elements
    private int front; // front index of the deque
    private int rear; // rear index of the deque
    private int size; // current size of the deque

    // Constructor to initialize the deque
    public CirArrDeque(int maxSize) {
        this.maxSize = maxSize;
        dequeArray = new int[maxSize];
        front = -1;
        rear = -1;
        size = 0;
    }

    // Method to add an element to the head of the deque
    public void addFirst(int item) {
        if (isFull()) {
            System.out.println("Deque is full, cannot addFirst!");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + maxSize) % maxSize;
        }
        dequeArray[front] = item;
        size++;
    }

    // Method to add an element to the tail of the deque
    public void addLast(int item) {
        if (isFull()) {
            System.out.println("Deque is full, cannot addLast!");
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % maxSize;
        }
        dequeArray[rear] = item;
        size++;
    }

    // Method to remove and return the first element of the deque
    public int removeFirst() {
        if (isEmpty()) {
            System.out.println("Deque is empty, cannot removeFirst!");
            return -1;
        }
        int removedItem = dequeArray[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % maxSize;
        }
        size--;
        return removedItem;
    }

    // Method to remove and return the last element of the deque
    public int removeLast() {
        if (isEmpty()) {
            System.out.println("Deque is empty, cannot removeLast!");
            return -1;
        }
        int removedItem = dequeArray[rear];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            rear = (rear - 1 + maxSize) % maxSize;
        }
        size--;
        return removedItem;
    }

    // Method to get the first element of the deque
    public int getFirst() {
        if (isEmpty()) {
            System.out.println("Deque is empty, cannot getFirst!");
            return -1;
        }
        return dequeArray[front];
    }

    // Method to get the last element of the deque
    public int getLast() {
        if (isEmpty()) {
            System.out.println("Deque is empty, cannot getLast!");
            return -1;
        }
        return dequeArray[rear];
    }

    // Method to check if the deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to check if the deque is full
    public boolean isFull() {
        return size == maxSize;
    }

    // Method to get the current size of the deque
    public int size() {
        return size;
    }

    // Method to display the elements of the deque
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty!");
            return;
        }
        System.out.print("Deque: ");
        int i = front;
        do {
            System.out.print(dequeArray[i] + " ");
            i = (i + 1) % maxSize;
        } while (i != (rear + 1) % maxSize);
        System.out.println();
    }

    public static void main(String[] args) {
        CirArrDeque deque = new CirArrDeque(5);

        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(30);
        deque.addLast(40);
        deque.display(); // Output: Deque: 30 10 20 40
        System.out.println("First element: " + deque.getFirst()); // Output: 30
        System.out.println("Last element: " + deque.getLast()); // Output: 40
        deque.removeFirst();
        deque.removeLast();
        deque.display(); // Output: Deque: 10 20
    }
}
