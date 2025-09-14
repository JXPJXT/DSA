import java.util.Arrays;

class DesignCircularQueue {
    private int[] v;
    private int front, back, size, capacity;

    public MyCircularDeque(int k) {
        v = new int[k];
        Arrays.fill(v, -1); 
        front = 0;
        back = 0;
        size = 0; 
        capacity = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front = 0;
            back = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }

        v[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            front = 0;
            back = 0;
        } else {
            back = (back + 1) % capacity;
        }
        v[back] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        v[front] = -1;
        front = (front + 1) % capacity;
        size--;
        if (isEmpty()) {
            back = front;
        }
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        v[back] = -1;
        back = (back - 1 + capacity) % capacity;
        size--;
        if (isEmpty()) {
            front = back;
        }
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return v[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return v[back];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
    
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println("Insert last 1: " + myCircularDeque.insertLast(1));    // return True
        System.out.println("Insert last 2: " + myCircularDeque.insertLast(2));    // return True
        System.out.println("Insert front 3: " + myCircularDeque.insertFront(3));    // return True
        System.out.println("Insert front 4: " + myCircularDeque.insertFront(4));    // return False, the deque is full
        System.out.println("Get rear: " + myCircularDeque.getRear());              // return 2
        System.out.println("Is full: " + myCircularDeque.isFull());              // return True
        System.out.println("Delete last: " + myCircularDeque.deleteLast());        // return True
        System.out.println("Insert front 4: " + myCircularDeque.insertFront(4));    // return True
        System.out.println("Get front: " + myCircularDeque.getFront());            // return 4
    }
}
