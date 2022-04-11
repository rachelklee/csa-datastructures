package src.TT1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Queue2<T> implements Iterable<T> {
    LinkedList<T> head, tail;

    public static void main()
    {
        QueueTester2.main(null);

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
        return new QueueIterator2<>(this);
    }
}

/**
 * Queue Iterator
 *
 * 1. "has a" current reference in Queue
 * 2. supports iterable required methods for next that returns a data object
 */
class QueueIterator2<T> implements Iterator<T> {
    LinkedList<T> current;  // current element in iteration

    // QueueIterator is intended to the head of the list for iteration
    public QueueIterator2(Queue2<T> q) {
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
class QueueManager2<T> {
    // queue data
    private final String name; // name of queue
    private int count = 0; // number of objects in queue
    public Queue2<T> queue = new Queue2<>(); // queue object

    /**
     *  Queue constructor
     *  Title with empty queue
     */
    public QueueManager2(String name) {
        this.name = name;
    }

    /**
     *  Queue constructor
     *  Title with series of Arrays of Objects
     */
    public QueueManager2(String name, T[]... seriesOfObjects) {
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

    public void mergeQueue(Queue2<T> queue2){
        Queue2<T> newQueue = new Queue2<>();
        Iterator<T> iter1 = this.queue.iterator();
        Iterator<T> iter2 = queue2.iterator();
        while (iter1.hasNext() && iter2.hasNext()){
            newQueue.add(iter1.next());
            newQueue.add(iter2.next());
        }
        while (iter1.hasNext()){
            newQueue.add(iter1.next());
        }
        while (iter2.hasNext()){
            newQueue.add(iter2.next());
        }
        this.queue = newQueue;
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
    public Queue2<T> getQueue(){
        return queue;
    }

  
}

/**
 * Driver Class
 * Tests queue with string, integers, and mixes of Classes and types
 */
class QueueTester2 {
    public static void main(String[] args)
    {
        // Create iterable Queue of Words
        Object[] words = new String[] { "1", "3", "5", "8"};
        QueueManager2 qWords = new QueueManager2("Words", words );
        qWords.printQueue();
        Object[] words2 = new String[] { "2", "4", "6", "9"};
        QueueManager2 qWords2 = new QueueManager2("Words", words2 );
        qWords2.printQueue();

        qWords.mergeQueue(qWords2.getQueue());
        qWords.printQueue();

    }
}
