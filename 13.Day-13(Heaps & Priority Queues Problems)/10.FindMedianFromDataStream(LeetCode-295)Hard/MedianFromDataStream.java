import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFromDataStream {
    public MedianFromDataStream() {}
    
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
    
    public void addNum(int num) {
        if(max.isEmpty() || num <= max.peek())
            max.offer(num);
        else
            min.offer(num);

        if(max.size() < min.size())
            max.offer(min.poll());
        else if(max.size() > min.size() + 1)
            min.offer(max.poll());
    }
    
    public double findMedian() {
        if(min.size() == max.size()){
            return (min.peek() + max.peek()) / 2.0;
        }
        return max.peek();
    }

    public static void main(String[] args) {
        MedianFromDataStream medianFinder = new MedianFromDataStream();
        System.out.println("Adding numbers: 1, 2, 3");
        medianFinder.addNum(1);
        System.out.println("After adding 1, Median: " + medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println("After adding 2, Median: " + medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println("After adding 3, Median: " + medianFinder.findMedian());
    }
}
