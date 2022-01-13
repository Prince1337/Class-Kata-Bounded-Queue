import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.PriorityQueue;
import java.util.concurrent.*;

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

  public boolean tryEnqueue (T element, int timeOutMSec){
    LocalDateTime start = LocalDateTime.now();
    LocalDateTime checkPoint = LocalDateTime.now();

    if(checkPoint.minusNanos(start.getNano()).getSecond() > timeOutMSec)
      return false;

    enqueue(element);
    return true;
  }

  public boolean tryDequeue (int timeOutMSec){
    LocalDateTime start = LocalDateTime.now();
    LocalDateTime checkPoint = LocalDateTime.now();

    if(checkPoint.minusNanos(start.getNano()).getSecond() > timeOutMSec)
      return false;

    System.out.println(dequeue());
    return true;
  }



  public PriorityQueue<T> getQueue() {
    return queue;
  }
}
