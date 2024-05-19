package Practice;

class ArrayQueue {
    private int maxSize; // maximum size of the queue
    private int[] queueArray; // array to hold the queue elements
    private int front; // front of the queue
    private int rear; // rear of the queue

    // Constructor to initialize the queue
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new int[maxSize];
        front = -1;
        rear = -1;
    }

    // Method to add an element to the rear of the queue
    public void enqueue(int item) {
        if (rear == maxSize - 1) {
            System.out.println("Queue is full, cannot enqueue!");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear++;
        queueArray[rear] = item;
    }

    // Method to remove an element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, cannot dequeue!");
            return -1;
        }
        int removedItem = queueArray[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        return removedItem;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // Method to get the current size of the queue
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return rear - front + 1;
    }

    // Method to display the elements of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queueArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        //queue.enqueue(60);

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        queue.display();
        System.out.println("Dequeued element: " + queue.dequeue());
        queue.display();
        queue.enqueue(60);
    }
}
