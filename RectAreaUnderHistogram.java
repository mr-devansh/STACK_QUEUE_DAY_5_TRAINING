import java.util.*;

public class Main {
    public static long largestRectangleArea(int[] heights) {
        int n = heights.length;
        long maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            // Calculate the area of the rectangle with the current height as the minimum height
            // Pop elements from the stack while the current height is less than the height at the top of the stack
            // For each popped element, calculate the area with the popped height as the minimum height
            while (!stack.isEmpty() && (i == n || heights[stack.peek()] > heights[i])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                long area = (long) height * width;
                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            // Read the size of the array
            int N = scanner.nextInt();

            // Read the heights of the buildings
            int[] heights = new int[N];
            for (int i = 0; i < N; i++) {
                heights[i] = scanner.nextInt();
            }

            // Calculate the largest rectangle area
            long maxArea = largestRectangleArea(heights);

            // Print the result
            System.out.println(maxArea);
        }

        scanner.close();
    }
}