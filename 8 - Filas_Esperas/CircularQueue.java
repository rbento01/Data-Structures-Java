public class CircularQueue implements Queue {
    private Object[] array;
    private int front, rear, size;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
        front = rear = size = 0;
    }

    @Override
    public void queue(Object o) {
        if (size == capacity) {
            throw new RuntimeException("Queue is full");
        }
        array[rear] = o;
        rear = (rear + 1) % capacity;
        size++;
    }

    @Override
    public Object dequeue() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        Object item = array[front];
        array[front] = null;
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    @Override
    public Object peek() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty");
        }
        return array[front];
    }
}
