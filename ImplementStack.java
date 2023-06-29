import java.util.*;

class Stack {
    private List<Integer> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public String pop() {
        if (isEmpty()) {
            return "Empty";
        } else {
            int poppedElement = stack.remove(stack.size() - 1);
            return String.valueOf(poppedElement);
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

public class ImplementStack{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of operations
        int T = scanner.nextInt();

        // Create an instance of the Stack class
        Stack stack = new Stack();

        // Perform the operations
        for (int i = 0; i < T; i++) {
            String operation = scanner.next();

            if (operation.equals("push")) {
                int x = scanner.nextInt();
                stack.push(x);
            } else if (operation.equals("pop")) {
                System.out.println(stack.pop());
            }
        }

        scanner.close();
    }
}