import java.util.ArrayDeque;
import java.util.Queue;

class MyStack {
  private Queue<Integer> q = new ArrayDeque<>();

  public void push(int x) {
    q.offer(x);
    for (int i = 0; i < q.size() - 1; ++i)
      q.offer(q.poll());
  }

  public int pop() {
    return q.poll();
  }

  public int top() {
    return q.peek();
  }

  public boolean empty() {
    return q.isEmpty();
  }

  public static void main(String[] args) {
    // Create an instance of MyStack
    MyStack myStack = new MyStack();

    System.out.println("1. Pushing 1, 2, and 3 onto the stack...");
    myStack.push(1);
    myStack.push(2);
    myStack.push(3);

    System.out.println("2. The top element is: " + myStack.top()); // Should be 3

    System.out.println("3. Popping the top element...");
    System.out.println("Popped element: " + myStack.pop()); // Should be 3

    System.out.println("4. The top element is now: " + myStack.top()); // Should be 2

    System.out.println("5. Popping again...");
    System.out.println("Popped element: " + myStack.pop()); // Should be 2

    System.out.println("6. Is the stack empty? " + myStack.empty()); // Should be false

    System.out.println("7. Popping the last element...");
    System.out.println("Popped element: " + myStack.pop()); // Should be 1

    System.out.println("8. Is the stack empty now? " + myStack.empty()); // Should be true
  }
}
