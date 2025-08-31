import java.util.Stack;

class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minSt;

    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        if (minSt.isEmpty() || val <= minSt.peek()) {
            minSt.push(val);
        }
    }

    public void pop() {
        if (st.peek().equals(minSt.peek())) {
            minSt.pop();
        }
        st.pop();
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minSt.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        // Demonstrate the MinStack functionality
        System.out.println("Initializing a MinStack and performing operations:");
        
        System.out.println("Pushing 5...");
        minStack.push(5);
        System.out.printf("Current top: %d, Current min: %d%n", minStack.top(), minStack.getMin());

        System.out.println("Pushing 2...");
        minStack.push(2);
        System.out.printf("Current top: %d, Current min: %d%n", minStack.top(), minStack.getMin());

        System.out.println("Pushing 4...");
        minStack.push(4);
        System.out.printf("Current top: %d, Current min: %d%n", minStack.top(), minStack.getMin());

        System.out.println("Pushing 2...");
        minStack.push(2);
        System.out.printf("Current top: %d, Current min: %d%n", minStack.top(), minStack.getMin());

        System.out.println("Popping a value...");
        minStack.pop();
        System.out.printf("After pop, current top: %d, Current min: %d%n", minStack.top(), minStack.getMin());

        System.out.println("Popping another value...");
        minStack.pop();
        System.out.printf("After pop, current top: %d, Current min: %d%n", minStack.top(), minStack.getMin());

        System.out.println("Pushing 1...");
        minStack.push(1);
        System.out.printf("After push, current top: %d, Current min: %d%n", minStack.top(), minStack.getMin());
    }
}
