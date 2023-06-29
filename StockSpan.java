import java.util.*;

public class Main {
    public static int[] calculateStockSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        // The span of the first day is always 1
        span[0] = 1;
        stack.push(0);

        for (int i = 1; i < n; i++) {
            // Pop elements from the stack while the price at the top is less than or equal to the current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If the stack becomes empty, all previous prices are less than the current price, so span is i + 1
            // Otherwise, span is the difference between the current day and the day at the top of the stack
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());

            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            // Read the size of the array
            int N = scanner.nextInt();

            // Read the stock prices
            int[] prices = new int[N];
            for (int i = 0; i < N; i++) {
                prices[i] = scanner.nextInt();
            }

            // Calculate the stock span
            int[] span = calculateStockSpan(prices);

            // Print the stock span array
            for (int i = 0; i < N; i++) {
                System.out.print(span[i] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}