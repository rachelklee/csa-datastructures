package TT3.Sort;

import TT3.Sorts;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class selection extends Sorts {
        public selection(int size) {
            super(size);
        }

        public static void selectionSort(ArrayList<Integer> arr){
            //start time
            Instant start = Instant.now();
            for (int i = 0; i < arr.size(); i++) {
                int smallestIdx = i;
                for (int c = i+1; c < arr.size(); c++) {
                    if (arr.get(c) < arr.get(smallestIdx)) {
                        smallestIdx = c;
                    }
                }
                Collections.swap(arr,i,smallestIdx);
            }
            //end time
            Instant end = Instant.now();


            Duration rawTime = Duration.between(start,end);
            selectionTime = (double)rawTime.toMillis();
        }

        public static void main(String[] args) {
            ArrayList<Integer> vals = new ArrayList<>(Arrays.asList(71, 86, 79, 36, 78, 35, 75, 86, 24, 11));
            selectionSort(vals);
            System.out.println(vals);
        }
}
