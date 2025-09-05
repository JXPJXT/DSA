import java.util.ArrayDeque;
import java.util.Deque;

class FrontMiddleBackQueue {
    Deque<Integer> dq1, dq2;

    public FrontMiddleBackQueue() {
        dq1 = new ArrayDeque<Integer>();
        dq2 = new ArrayDeque<Integer>();
    }

    public void pushFront(int val) {
        dq1.addFirst(val);
        balance();
    }

    public void pushBack(int val) {
        dq2.addLast(val);
        balance();
    }

    public void pushMiddle(int val) {
        if(dq1.size() > dq2.size()) {
            dq2.addFirst(dq1.removeLast());
        }
        dq1.addLast(val);
        balance();
    }

    public int popFront() {
        if(dq1.isEmpty() && dq2.isEmpty()) return -1;
        int val;
        if(dq1.isEmpty()) {
            val = dq2.removeFirst();
        } else {
            val = dq1.removeFirst();
        }
        balance();
        return val;
    }

    public int popMiddle() {
        if(dq1.isEmpty() && dq2.isEmpty()) return -1;
        int val;
        if(dq1.size() == dq2.size()) {
            val = dq1.removeLast();
        } else {
            val = dq2.removeFirst();
        }
        balance();
        return val;
    }

    public int popBack() {
        if(dq1.isEmpty() && dq2.isEmpty()) return -1;
        int val = dq2.removeLast();
        balance();
        return val;
    }

    private void balance() {
        if(dq1.size() > dq2.size() + 1) {
            dq2.addFirst(dq1.removeLast());
        } else if (dq2.size() > dq1.size()) {
            dq1.addLast(dq2.removeFirst());
        }
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);
        q.pushBack(2);
        q.pushMiddle(3);
        q.pushMiddle(4);
        System.out.println("popFront(): " + q.popFront());
        System.out.println("popBack(): " + q.popBack());
        System.out.println("popMiddle(): " + q.popMiddle());
        System.out.println("popMiddle(): " + q.popMiddle());
        System.out.println("popFront(): " + q.popFront());
        System.out.println("popBack(): " + q.popBack());
    }
}
