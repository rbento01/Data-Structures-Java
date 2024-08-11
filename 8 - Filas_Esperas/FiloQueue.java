import java.util.LinkedList;

public class FiloQueue implements Queue {
    private LinkedList<Object> list = new LinkedList<>();

    @Override
    public void queue(Object o) {
        list.addLast(o);
    }

    @Override
    public Object dequeue() {
        if (list.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list.removeLast();
    }

    @Override
    public Object peek() {
        if (list.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return list.getLast();
    }
}
