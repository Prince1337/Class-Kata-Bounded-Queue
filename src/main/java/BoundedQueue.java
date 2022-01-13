import java.util.PriorityQueue;

public class BoundedQueue<T> {

  private final PriorityQueue<T> queue;
  private final int size;

  public BoundedQueue(int size) {
    this.size = size;
    this.queue = boundedQueue(this.size);
  }

  private PriorityQueue<T> boundedQueue (int size){
    return new PriorityQueue<>(size);
  }

  public void enqueue (T element){
    queue.add(element);
  }

  public T dequeue (){
    return queue.remove();
  }

  public int count (){
    return queue.size();
  }

  public int size(){
    return this.size;
  }

  public PriorityQueue<T> getQueue() {
    return queue;
  }
}
