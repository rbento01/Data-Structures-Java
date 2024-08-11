import java.util.PriorityQueue;

public class PriorityQueueWrapper implements Queue {
    private PriorityQueue<Object> queue = new PriorityQueue<>();

    @Override
    public void queue(Object o) {
        queue.add(o);
    }

    @Override
    public Object dequeue() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue.poll();
    }

    @Override
    public Object peek() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue.peek();
    }
}
