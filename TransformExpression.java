import java.util.*;

public class RPNConverter {
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    private static String convertToRPN(String expression) {
        StringBuilder rpn = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : expression.toCharArray()) {
            if (Character.isLetter(c)) {
                rpn.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    rpn.append(stack.pop());
                }
                stack.pop(); // Discard '('
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && getPrecedence(c) <= getPrecedence(stack.peek())) {
                    rpn.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            rpn.append(stack.pop());
        }

        return rpn.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Read the newline after t

        for (int i = 0; i < t; i++) {
            String expression = scanner.nextLine();
            String rpn = convertToRPN(expression);
            System.out.println(rpn);
        }
    }
}