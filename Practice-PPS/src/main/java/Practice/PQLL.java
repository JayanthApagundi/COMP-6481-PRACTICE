package Practice;

class Node {
    int value;
    int priority;
    Node next;

    public Node(int v, int p) {
        value = v;
        priority = p;
    }
}

class PQLinkedList {
    Node head;
    int size;

    public PQLinkedList() {
        head = null;
        size = 0;
    }

    public void insert(int v, int p) {
        Node newNode = new Node(v, p);

        if (head == null || p < head.priority) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null && temp.next.priority <= p) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.print("PQ is Empty !!! ");
            return -1;
        }
        int removed = head.value;
        head = head.next;
        size--;
        return removed;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print("(" + temp.value + "," + temp.priority + ")->");
            temp = temp.next;
        }
        System.out.println();
    }

    public int size() {
        return size;
    }
}

public class PQLL {
    public static void main(String[] args) {
        PQLinkedList PriQueLL = new PQLinkedList();
        PriQueLL.insert(12, 3);
        PriQueLL.insert(45, 6);
        PriQueLL.insert(49, 4);
        PriQueLL.insert(90,1);
        PriQueLL.insert(200,2);
        System.out.println("Size: " + PriQueLL.size());
        PriQueLL.display();
        System.out.println(PriQueLL.remove());
        System.out.println(PriQueLL.remove());
        PriQueLL.display();
    }
}
