package Practice;

class CirArrayQueue {
    private int maxSize; // maximum size of the queue
    private int[] queueArray; // array to hold the queue elements
    private int front; // front of the queue
    private int rear; // rear of the queue

    // Constructor to initialize the queue
    public CirArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new int[maxSize];
        front = -1;
        rear = -1;
    }

    // Method to add an element to the rear of the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full, cannot enqueue!");
            return;
        }
        if (isEmpty()) {
            front = 0; // If queue is empty, set front to 0
        }
        rear = (rear + 1) % maxSize; // Circular increment for rear
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
            // If there was only one element in the queue, reset front and rear
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % maxSize; // Circular increment for front
        }
        return removedItem;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // Method to display the elements of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue: ");
        int i = front;
        do {
            System.out.print(queueArray[i] + " ");
            i = (i + 1) % maxSize; // Circular increment
        } while (i != (rear + 1) % maxSize); // Stop when we reach rear+1
        System.out.println();
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return (rear - front + maxSize) % maxSize + 1;
    }

    public static void main(String[] args) {
        CirArrayQueue queue = new CirArrayQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        queue.display();
        queue.enqueue(60);
        queue.enqueue(70);
        queue.enqueue(80);
        queue.display();
        System.out.println("Size: "+queue.size());
    }
}
