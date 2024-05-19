package Practice;

class LinkedListQueue{
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node front; // front of the queue
    private Node rear; // rear of the queue
    public int size=0;

    // Constructor to initialize the queue
    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
        this.size=0;
    }

    // Method to add an element to the rear of the queue
    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    // Method to remove an element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty, cannot dequeue!");
            return -1;
        }
        int removedItem = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return removedItem;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Method to display the elements of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue: ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int size(){
        return size;
    }

}

public class QueLL {
    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        queue.display();
        System.out.println("Dequeued element: " + queue.dequeue());
        queue.display();
        queue.enqueue(60);
        queue.display();
        System.out.println("Size: "+queue.size());
    }
}