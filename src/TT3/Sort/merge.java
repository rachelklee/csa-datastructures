package TT3.Sort;

import TT3.Sorts;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class merge extends Sorts{
    public merge(int size) {
        super(size);
    }

    public static void mergeSort(ArrayList<Integer> arr){
        //start time
        Instant start = Instant.now();

        int mid;
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        if(arr.size()>1){
            mid = arr.size()/2;
            //left
            for(int i=0; i<mid; i++){
                left.add(arr.get(i));
            }
            //right
            for (int j = mid; j<arr.size(); j++)
            right.add(arr.get(j));
            //recursive call
            mergeSort(left);
            mergeSort(right);
            //merge arrays
            merge(arr,left,right);
        }
        //end time
        Instant end = Instant.now();


        Duration rawTime = Duration.between(start,end);
        mergeTime = (double)rawTime.toMillis();
    }

    public static void merge(ArrayList<Integer> arr, ArrayList<Integer> left, ArrayList<Integer> right){
        //temporary arraylist to build merge
        ArrayList<Integer> temp = new ArrayList<>();

        //indexes
        int numIdx = 0;
        int rightIdx = 0;
        int leftIdx=0;
        //traverse for merging
        while(leftIdx<left.size() && rightIdx<right.size()){
            if(left.get(leftIdx)<right.get(rightIdx)){
                arr.set(numIdx, left.get(leftIdx));
                leftIdx++;
            }
            else{
                arr.set(numIdx, right.get(rightIdx));
                rightIdx++;
            }
            numIdx++;
        }

        //copy remaining elements
        int tempIdx = 0;
        if (leftIdx >= left.size()) {
            temp = right;
            tempIdx = rightIdx;
        }
    else {
            temp = left;
            tempIdx = leftIdx;
        }

        for (int i = tempIdx; i < temp.size(); i++) {
            arr.set(numIdx, temp.get(i));
            numIdx++;
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> vals = new ArrayList<>(Arrays.asList(71, 86, 79, 36, 78, 35, 75, 86, 24, 11));
        mergeSort(vals);
        System.out.println("Merge Sort" + vals);
    }
}