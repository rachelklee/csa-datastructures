package src.TT1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Queue3<T> implements Iterable<T> {
    LinkedList<T> head, tail;

    public static void main()
    {
        QueueTester3.main(null);
    }

    /**
     *  Add a new object at the end of the Queue,
     *
     * @param  data,  is the data to be inserted in the Queue.
     */
    public void add(T data) {
        // add new object to end of Queue
        LinkedList<T> tail = new LinkedList<>(data, null);

        if (head == null)  // initial condition
            this.head = this.tail = tail;
        else {  // nodes in queue
            this.tail.setNextNode(tail); // current tail points to new tail
            this.tail = tail;  // update tail
        }
    }

    /**
     *  Returns the head object.
     *
     * @return  this.head, the head object in Queue.
     */
    public LinkedList<T> getHead() {
        return this.head;
    }

    /**
     *  Returns the tail object.
     *
     * @return  this.tail, the last object in Queue
     */
    public LinkedList<T> getTail() {
        return this.tail;
    }

    /**
     *  Returns the iterator object.
     *
     * @return  this, instance of object
     */
    public Iterator<T> iterator() {
        return new QueueIterator3<>(this);
    }
}

/**
 * Queue Iterator
 *
 * 1. "has a" current reference in Queue
 * 2. supports iterable required methods for next that returns a data object
 */
class QueueIterator3<T> implements Iterator<T> {
    LinkedList<T> current;  // current element in iteration

    // QueueIterator is intended to the head of the list for iteration
    public QueueIterator3(Queue3<T> q) {
        current = q.getHead();
    }

    // hasNext informs if next element exists
    public boolean hasNext() {
        return current != null;
    }

    // next returns data object and advances to next position in queue
    public T next() {
        T data = current.getData();
        current = current.getNext();
        return data;
    }
}

/**
 * Queue Manager
 * 1. "has a" Queue
 * 2. support management of Queue tasks (aka: titling, adding a list, printing)
 */
class QueueManager3<T> {
    // queue data
    private final String name; // name of queue
    private int count = 0; // number of objects in queue
    public Queue3<T> queue = new Queue3<>(); // queue object

    /**
     *  Queue constructor
     *  Title with empty queue
     */
    public QueueManager3(String name) {
        this.name = name;
    }

    /**
     *  Queue constructor
     *  Title with series of Arrays of Objects
     */
    public QueueManager3(String name, T[]... seriesOfObjects) {
        this.name = name;
        this.addList(seriesOfObjects);
    }

    /**
     * Add a list of objects to queue
     */
    public void addList(T[]... seriesOfObjects) {
        for (T[] objects: seriesOfObjects)
            for (T data : objects) {
                this.queue.add(data);
                this.count++;
            }
    }
    public void reverse(){
        Queue3<T> tempQueue = new Queue3<>();
        List<T> lst = new ArrayList<>();
        for (T data : this.queue){
            lst.add(data);
        }
        for (int i = lst.size() - 1; i >= 0; --i){
            tempQueue.add(lst.get(i));
        }
        queue = tempQueue;
    }
    /**
     * Print any array objects from queue
     */
    public void printQueue() {
        System.out.println(this.name + " count: " + count);
        System.out.print(this.name + " data: ");
        for (T data : queue)
            System.out.print(data + " ");
        System.out.println();
    }

  
}

/**
 * Driver Class
 * Tests queue with string, integers, and mixes of Classes and types
 */
class QueueTester3 {
    public static void main(String[] args)
    {
        // Create iterable Queue of Words
        Object[] words = new String[] { "1", "2", "3"};
        QueueManager3 qWords = new QueueManager3("Words", words );
        qWords.printQueue();
        qWords.reverse();
        qWords.printQueue();

    }
}
