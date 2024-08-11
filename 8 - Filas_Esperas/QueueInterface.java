public interface Queue {
    void queue(Object o); // Adds an element to the queue
    Object dequeue();    // Removes an element from the queue
    Object peek();       // Returns the next element without removing it
}
