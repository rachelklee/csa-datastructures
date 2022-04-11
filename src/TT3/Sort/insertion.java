package src.TT3.Sort;

import src.TT3.Sorts;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class insertion extends Sorts {
    public insertion(int size) {
        super(size);
    }

    public static void insertionSort(ArrayList<Integer> arr)
    {
        //start time
        Instant start = Instant.now();
        for (int j = 1; j < arr.size(); j++) {
            Integer current = arr.get(j);
            int i = j-1;
            while ((i > -1) && ((arr.get(i).compareTo(current)) == 1)) {
                arr.set(i+1, arr.get(i));
                i--;
            }
            arr.set(i+1, current);
        }

        //end time
        Instant end = Instant.now();


        Duration rawTime = Duration.between(start,end);
        insertionTime = (double)rawTime.toMillis();

    }

    public static void main(String[] args)
    {
        ArrayList<Integer> vals = new ArrayList<>(Arrays.asList(71, 86, 79, 36, 78, 35, 75, 86, 24, 11));
        insertionSort(vals);
        System.out.println("Insertion Sort" + vals);
    }
}
