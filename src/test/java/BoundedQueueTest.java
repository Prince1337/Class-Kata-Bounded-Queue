import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class BoundedQueueTest {

  BoundedQueue<Integer> boundedQueue;

  @BeforeEach
  void setup(){

  }

  @Test
  void queueContainsSpecificElement(){
    int size = 10;
    boundedQueue = new BoundedQueue<>(size);
    int newElement = 42;

    boundedQueue.enqueue(newElement);
    PriorityQueue<Integer> queue = boundedQueue.getQueue();
    assertTrue(queue.contains(42));
  }

  @Test
  void queueDoesNotContainRemovedElement(){
    int size = 10;
    boundedQueue = new BoundedQueue<>(size);
    int firstElement = 42;
    int secondElement = 43;

    boundedQueue.enqueue(firstElement);
    boundedQueue.enqueue(secondElement);
    boundedQueue.dequeue();
    PriorityQueue<Integer> queue = boundedQueue.getQueue();
    assertFalse(queue.contains(42));
  }

  @Test
  void queueContainsThreeElements(){
    int size = 10;
    boundedQueue = new BoundedQueue<>(size);
    int firstElement = 42;
    int secondElement = 43;
    int thirdElement = 44;

    boundedQueue.enqueue(firstElement);
    boundedQueue.enqueue(secondElement);
    boundedQueue.enqueue(thirdElement);

    assertEquals(3, boundedQueue.count());
  }

}