import java.util.Stack;

class MyQueue {
    public static Stack<Integer> s1;
    public static Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
    
    public int pop() {
        if (s1.isEmpty()) {
            return -1;
        }
        return s1.pop();
    }
    
    public int peek() {
        if (s1.isEmpty()) {
            return -1;
        }
        return s1.peek(); 
    }
    
    public boolean empty() {
        if (s1.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println("Push 1 and 2.");
        System.out.println("Peek: " + myQueue.peek());
        System.out.println("Pop: " + myQueue.pop());
        System.out.println("Is empty: " + myQueue.empty());
        System.out.println("Pop: " + myQueue.pop());
        System.out.println("Is empty: " + myQueue.empty());
    }
}
