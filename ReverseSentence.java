import java.util.*;

public class ReverseSentence{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        
        while (n-- > 0) {
            String str = sc.nextLine();
            String[] array = str.split(" ");
            reverse(array);
            System.out.println();
        }
        
        sc.close();
    }
    
    // reverse using stack
    public static void reverse(String[] str) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            stack.push(str[i]);
        }
        
        while (!stack.isEmpty()) {
            String element = stack.pop();
            System.out.print(element + " ");
        }
    }
}