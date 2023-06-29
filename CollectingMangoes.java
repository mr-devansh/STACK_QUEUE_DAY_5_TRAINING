import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            // Print the case number
            System.out.println("Case " + t + ":");

            // Read the number of questions/operations
            int N = scanner.nextInt();

            // Create a stack to store the mango sizes
            Stack<Integer> basket = new Stack<>();
            int maxMangoSize = -1;

            // Process each question/operation
            for (int i = 0; i < N; i++) {
                String type = scanner.next();

                if (type.equals("A")) {
                    int mangoSize = scanner.nextInt();
                    basket.push(mangoSize);
                    maxMangoSize = Math.max(maxMangoSize, mangoSize);
                } else if (type.equals("R")) {
                    if (!basket.isEmpty()) {
                        int removedMangoSize = basket.pop();
                        if (removedMangoSize == maxMangoSize) {
                            // If the removed mango was the maximum, recalculate the maximum
                            maxMangoSize = -1;
                            for (int mango : basket) {
                                maxMangoSize = Math.max(maxMangoSize, mango);
                            }
                        }
                    }
                } else if (type.equals("Q")) {
                    if (!basket.isEmpty()) {
                        System.out.println(maxMangoSize);
                    } else {
                        System.out.println("Empty");
                    }
                }
            }
        }

        scanner.close();
    }
}