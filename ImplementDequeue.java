import java.util.Scanner;
class Deque {
    private int[] deque;
    private int front;
    private int rear;
    private int capacity;

    public Deque(int capacity) {
        this.deque = new int[capacity];
        this.front = -1;
        this.rear = -1;
        this.capacity = capacity;
    }

    public void pushFront(int x) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot push " + x + " at the front.");
        } else if (isEmpty()) {
            front = 0;
            rear = 0;
            deque[front] = x;
        } else {
            front = (front - 1 + capacity) % capacity;
            deque[front] = x;
        }
    }

    public void pushBack(int x) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot push " + x + " at the back.");
        } else if (isEmpty()) {
            front = 0;
            rear = 0;
            deque[rear] = x;
        } else {
            rear = (rear + 1) % capacity;
            deque[rear] = x;
        }
    }

    public int popFront() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        } else if (front == rear) {
            int poppedElement = deque[front];
            front = -1;
            rear = -1;
            return poppedElement;
        } else {
            int poppedElement = deque[front];
            front = (front + 1) % capacity;
            return poppedElement;
        }
    }

    public int popBack() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        } else if (front == rear) {
            int poppedElement = deque[rear];
            front = -1;
            rear = -1;
            return poppedElement;
        } else {
            int poppedElement = deque[rear];
            rear = (rear - 1 + capacity) % capacity;
            return poppedElement;
        }
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of operations
        int T = scanner.nextInt();

        // Create an instance of the Deque class
        Deque deque = new Deque(T);

        // Perform the operations
        for (int i = 0; i < T; i++) {
            String operation = scanner.next();

            if (operation.equals("push_front")) {
                int x = scanner.nextInt();
                deque.pushFront(x);
            } else if (operation.equals("push_back")) {
                int x = scanner.nextInt();
                deque.pushBack(x);
            } else if (operation.equals("pop_front")) {
                int poppedElement = deque.popFront();
                if (poppedElement == Integer.MIN_VALUE) {
                    System.out.println("Empty");
                } else {
                    System.out.println(poppedElement);
                }
            } else if (operation.equals("pop_back")) {
                int poppedElement = deque.popBack();
                if (poppedElement == Integer.MIN_VALUE) {
                    System.out.println("Empty");
                } else {
                    System.out.println(poppedElement);
                }
            }
        }

        scanner.close();
    }
}