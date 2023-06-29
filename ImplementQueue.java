import java.util.Scanner;
class Queue {
    private int front;
    private int rear;
    private int[] queue;
    private int capacity;

    public Queue(int capacity) {
        this.front = 0;
        this.rear = -1;
        this.queue = new int[capacity];
        this.capacity = capacity;
    }

    public void enqueue(int x) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + x);
        } else {
            rear = (rear + 1) % capacity;
            queue[rear] = x;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            int dequeuedElement = queue[front];
            front = (front + 1) % capacity;
            return dequeuedElement;
        }
    }

    public boolean isEmpty() {
        return front == (rear + 1) % capacity;
    }

    public boolean isFull() {
        return front == (rear + 2) % capacity;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of operations
        int T = scanner.nextInt();

        // Create an instance of the Queue class
        Queue queue = new Queue(T);

        // Perform the operations
        for (int i = 0; i < T; i++) {
            String operation = scanner.next();

            if (operation.equals("Enqueue")) {
                int x = scanner.nextInt();
                queue.enqueue(x);
            } else if (operation.equals("Dequeue")) {
                int dequeuedElement = queue.dequeue();
                if (dequeuedElement == Integer.MIN_VALUE) {
                    System.out.println("Empty");
                } else {
                    System.out.println(dequeuedElement);
                }
            }
        }

        scanner.close();
    }
}

