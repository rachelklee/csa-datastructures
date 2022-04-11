package src.TT3.Sort;

import src.TT3.Sorts;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class bubble extends Sorts {
    public bubble(int size) {
        super(size);
    }

    public static void bubbleSort(ArrayList<Integer> arr){
        //start time
        Instant start = Instant.now();

        int n = arr.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    // swap arr[j+1] and arr[j]
                    Collections.swap(arr, j, j + 1);
                }
            }
        }

        //end time
        Instant end = Instant.now();


        Duration rawTime = Duration.between(start,end);
        bubbleTime = (double)rawTime.toMillis();
    }


    public static void main(String[] args) {
        ArrayList<Integer> vals = new ArrayList<>(Arrays.asList(71, 86, 79, 36, 78, 35, 75, 86, 24, 11));
        bubbleSort(vals);
        System.out.println("Bubble Sort" + vals);
    }
}
