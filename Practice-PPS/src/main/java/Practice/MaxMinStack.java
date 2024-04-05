package Practice;

class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;
    private int min;
    private int max;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push element: " + value);
            return;
        }

        if (isEmpty()) {
            min = value;
            max = value;
        } else {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }

        stackArray[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        return stackArray[top--];
    }

    public int getMin() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No minimum value.");
            return -1;
        }
        return min;
    }

    public int getMax() {
        if (isEmpty()) {
            System.out.println("Stack is empty. No maximum value.");
            return -1;
        }
        return max;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}


public class MaxMinStack {
    public static void main(String[] args) {
        int[] array = {9, 3, 1, 49, 7, 6};

        Stack stack = new Stack(array.length);

        for (int i : array) {
            stack.push(i);
        }

        int minValue = stack.getMin();
        int maxValue = stack.getMax();

        System.out.println("Minimum element in array: " + minValue);
        System.out.println("Maximum element in array: " + maxValue);
    }
}
