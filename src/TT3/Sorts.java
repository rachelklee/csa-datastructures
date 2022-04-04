package TT3;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static TT3.Sort.bubble.bubbleSort;
import static TT3.Sort.insertion.insertionSort;
import static TT3.Sort.merge.mergeSort;
import static TT3.Sort.selection.selectionSort;


public class Sorts {
    private final ArrayList<Integer> data = new ArrayList<>();
    private final Duration timeElapsed;

    public static Double bubbleTime;
    public static Double insertionTime;
    public static Double mergeTime;
    public static Double selectionTime;

    public Sorts(int size) {
        Instant start = Instant.now();  // time capture -- start
        // build an array
        for (int i = 0; i < size; i++) {
            data.add((int)(Math.random() * (size+1)));
        }

        // use Inheritance and Polymorphism to replace data.sort with your own algorithm
        ArrayList<Integer> vals = new ArrayList<>(Arrays.asList(71, 86, 79, 36, 78, 35, 75, 86, 24, 11));
        System.out.println("Insertion");
        insertionSort(data);
        System.out.println("Merge");
        mergeSort(data);
        System.out.println("Bubble");
        bubbleSort(data);
        System.out.println("Selection");
        selectionSort(data);

        data.sort(Comparator.naturalOrder());
        Instant end = Instant.now();    // time capture -- end
        this.timeElapsed = Duration.between(start, end);
    }

    public ArrayList<Integer> getData() {
        return data;
    }

    public int getTimeElapsed() {
        return timeElapsed.getNano();
    }


    public static void main(String[] args) {
        int sum=0, time=0, TIMES=12, SIZE=5000;
        double bubbleSum = 0;
        double insertionSum = 0;
        double mergeSum = 0;
        double selectionSum = 0;

        for(int i=0; i< TIMES; i++) {
            Sorts s = new Sorts(SIZE);
            for(int j = 0; j<s.getData().size(); j++) {
                // To see data, uncomment next line
                //System.out.println(s.getData());
                sum += s.getData().get(j);
            }
            System.out.println("BUBBLE SORT Time Elapsed in millis: " + bubbleTime);
            bubbleSum += bubbleTime;
            System.out.println("INSERTION SORT Time Elapsed in millis: " + insertionTime);
            insertionSum += insertionTime;
            System.out.println("MERGE SORT Time Elapsed in millis: " + mergeTime);
            mergeSum += mergeTime;
            System.out.println("SELECTION SORT Time Elapsed in millis: " + selectionTime);
            selectionSum += selectionTime;
            System.out.println("Average random: " + sum / ((i+1)*SIZE));
            System.out.println("Nanoseconds: " + s.getTimeElapsed());
            time += s.getTimeElapsed();
        }
        System.out.println("Sum of all Bubble Sorts: " + bubbleSum);
        System.out.println("Average time of all Bubble Sorts: " + bubbleSum/TIMES);
        System.out.println("Sum of all Insertion Sorts: " + insertionSum);
        System.out.println("Average time of all Insertion Sorts: " + insertionSum/TIMES);
        System.out.println("Sum of all Merge Sorts: " + mergeSum);
        System.out.println("Average time of all Merge Sorts: " + mergeSum/TIMES);
        System.out.println("Sum of all Selection Sorts: " + bubbleSum);
        System.out.println("Average time of all Selection Sorts: " + selectionSum/TIMES);

        System.out.println("Average random: " + sum / (TIMES*SIZE));
        System.out.println("Total Nanoseconds: " + time );
        System.out.println("Total Seconds: " + time /1000000000.0);


        //Sort LinkedList
        //System.out.println("\n ------LinkedList------");
        //Sorts ll = new Sorts(12);

    }

}
