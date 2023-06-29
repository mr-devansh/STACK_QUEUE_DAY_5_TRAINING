import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int q = scanner.nextInt(); // Number of queries
        scanner.nextLine(); // Consume the newline

        Stack<Integer> stack1 = new Stack<>(); // Stack for enqueue operation
        Stack<Integer> stack2 = new Stack<>(); // Stack for dequeue operation

        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();

            if (type == 1) {
                int x = scanner.nextInt();
                stack1.push(x); // Enqueue operation
            } else if (type == 2) {
                if (stack2.isEmpty()) {
                    // Transfer elements from stack1 to stack2
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }
                stack2.pop(); // Dequeue operation
            } else if (type == 3) {
                if (stack2.isEmpty()) {
                    // Transfer elements from stack1 to stack2
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }
                System.out.println(stack2.peek()); // Print the front element
            }
        }

        scanner.close();
    }
}