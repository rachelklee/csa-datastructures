<h2 align="center"> <a href="https://rachelklee.github.io/csa-datastructures/">Home</a> | <a href="https://rachelklee.github.io/csa-datastructures/techtalknotes">Tech Talk Notes</a> | <a href="https://rachelklee.github.io/csa-datastructures/testprep">Test Prep Notes</a></h2>

# Week 2 Data Structures

## Code Snippets

### Sorts

#### Parent Class - Sorts
```java
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

```

#### Bubble Sort
```java
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

```

#### Insertion Sort
```java
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

```

#### Merge Sort
```java
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

```

#### Selection Sort
```java
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
```

## Github

| Challenge | Link |
| -- | -- |
| Sort (Parent Class) | [Sorts](https://github.com/rachelklee/csa-datastructures/blob/main/src/TT3/Sorts.java) |
| Sort (Child Class) | [Bubble](https://github.com/rachelklee/csa-datastructures/blob/main/src/TT3/Sort/bubble.java) |
| Sort (Child Class) | [Insertion](https://github.com/rachelklee/csa-datastructures/blob/main/src/TT3/Sort/insertion.java) |
| Sort (Child Class) | [Merge](https://github.com/rachelklee/csa-datastructures/blob/main/src/TT3/Sort/merge.java) |
| Sort (Child Class) | [Selection](https://github.com/rachelklee/csa-datastructures/blob/main/src/TT3/Sort/selection.java) |


## Sorts Explanation & Analysis

### Big O Complexity
**Bubble Sort:**

Best case: O(n)

Worst case: O(n^2)

**Insertion Sort:**

Best case: O(n)

Worst case: O(n^2)

**Selection Sort**

Best case: O(n^2)

Worst case: O(n^2)

**Merge Sort**

Best case: O(nlogn)

Worst case: O(nlogn)
