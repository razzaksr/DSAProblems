package problems.dsa.days.day2;

import java.util.Stack;
public class DoRecursiveStackSort {
    public static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertSorted(stack, element);
            stack.push(temp);
        }
    }
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();sortStack(stack);insertSorted(stack, temp);
        }
    }
    public static void main(String[] args) {
        Stack<Integer> inputStack = new Stack<>();
        inputStack.push(34);inputStack.push(3); inputStack.push(31); inputStack.push(98);      inputStack.push(92);inputStack.push(23); System.out.println("Original stack: " + inputStack);
        sortStack(inputStack);
        System.out.println("Sorted stack: " + inputStack);
    }
}
