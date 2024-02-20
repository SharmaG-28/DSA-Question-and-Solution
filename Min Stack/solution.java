import java.util.Scanner;
import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            if (stack.pop().equals(minStack.peek())) {
                minStack.pop();
            }
        }
    }
    
    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        }
        throw new IllegalStateException("Stack is empty");
    
    }
    
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new IllegalStateException("Stack is empty");
    
    }
}

public class solution {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of operations:");
        int operations = scanner.nextInt();
        
        for (int i = 0; i < operations; i++) {
            System.out.println("Enter operation (1: push, 2: pop, 3: top, 4: getMin):");
            int operation = scanner.nextInt();
            
            switch (operation) {
                case 1:
                    System.out.println("Enter value to push:");
                    int val = scanner.nextInt();
                    minStack.push(val);
                    break;
                case 2:
                    minStack.pop();
                    break;
                case 3:
                    try {
                        System.out.println("Top element: " + minStack.top());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println("Minimum element: " + minStack.getMin());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid operation!");
            }
        }
        
        scanner.close();
    }
}
