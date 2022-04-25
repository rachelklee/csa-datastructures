<h2 align="center"> <a href="https://rachelklee.github.io/csa-datastructures/">Home</a> | <a href="https://rachelklee.github.io/csa-datastructures/techtalknotes">Tech Talk Notes</a> | <a href="https://rachelklee.github.io/csa-datastructures/testprep">Test Prep Notes</a></h2>

# Week 5

# Goals

| Goal | Detail | Complete |
| --- | --- | --- |
| Review Array, ArrayList, 2D Array | Review TT notes from Tri 1, Watch CB videos, Do practice quiz (CB) | X |
| In Class full practice exam | Full MC and FRQ Timed, completed in class | X |
| At least 1 extra FRQ | Full old FRQ from CB, Timed, outside of class | X |
| Barron's Book practice exam | Full Practice Exam 1, Timed, outside of class | X |

# Additional Notes
* Work on timing for exams
     * Be conscious of how much time is being used for each question

# Corrections
## MC: Score 25/39 (Initial), 32/39 (Final)
| Number | Original Choice | Correct Choice | Reasoning |
| --- | --- | --- | --- |
| 6 | B | A | containsArt ("rattrap", "similar", "today") This is because the "art" is found as a combination of "similar" and "today". That is not as intended based upon the description of what the method should do. |
| 9 | C | E | Dice 1: (int)(Math.random()*6)+1, Dice 2: (int)(Math.random()*6)+1, sum: (int)(Math.random()*6)+1+(int)(Math.random()*6)+1 = 2+(int)(Math.random()*6+(int)(Math.random)*6)
| 13 | B | A | Trace. 3 is passed in. First pass starts at position 1, as indicated in the four loop. That is 34. So, 17 remains the first number at position 0. ? = 17 + 3 which is 20. 2nd slot in numbers array is now 20. For loop's incrementer is k = k + 3, so 1 + 3 = 4. ? = 42 + 3 which is 45. 4th slot in numbers array is now 45. For ? = 42 + 3 which is 45. 4th slot in numbers array is now 45., so 4 + 3 = 7. ? = 48 + 3 which is 51. 7th slot in numbers array is now 51. The loop ends as loop's incrementer is k = k + 3, so 7 + 3 = 10 which is > 8, the array length. The loop ends |
| 25 | D | C | Inner loop starts at y=x so answer is not 5*5=25. At index 0, count adds 4 and goes to 4. At index 1, count adds 3 and goes to 7. At index 2, count adds 2 and goes to 9. At index 3, count adds 1 and goes to 10. |
| 36 | E | D | This is a binary search. The number of comparisions is approximately log2(2000) which is about 11 |
| 38 | B | C | Recursion is used in this method. First "if" block checks for a match of the searched variable to the last variable in the array. The recursion will back this up to the lower array. Second "if" block checks length. When the array only has 1 index, loop terminates. Loop calls mystery with the shorter numVals and adds 1 to the return value (since loop ends when k=1) At the end of the stack, the code will return the number of elements in the array that are equal to val |
| 40 | A | C | First "for" block sets each existing index to "Alex". When calling the "set" method on the students list the element that previously existed at the specified index is returned. This is why the first output that you see is "Bob" when it's replaced with "Alex" and "Carl" when it's replaced with "Alex". So, "Alex Bob Carl" is the first line output. After the second "for" block, "Alex Alex Alex" is populated and will print |

## FRQ Score: 27/33
![PXL_20220421_161824323](https://user-images.githubusercontent.com/77082379/165020104-2d1e486d-3963-4c3a-8c83-591bf23ac0f5.jpg)

(a) +2/2

(b) +3/4
- Accesses columns instead of rows, use for(int i = 0; i < arr2D.length(); i++) or for(int[] row : arr2D)

(c) +2/3
- int[][] not needed when calling 2D array, use int[] sums = rowSums(arr2D);

![PXL_20220421_161831733](https://user-images.githubusercontent.com/77082379/165020110-5dfe4484-bd13-40f9-8a27-6f7efd0515a6.jpg)

(a) +9/9

![PXL_20220421_161840881](https://user-images.githubusercontent.com/77082379/165020121-3f9596f3-7381-4093-a8a8-6746d2b4df6a.jpg)

(a) +3/3

(b) +2/3 missing numCols--; outside of for loop

![PXL_20220421_161844758](https://user-images.githubusercontent.com/77082379/165020135-fd7080b9-c809-4d26-902f-14e02ea0e59e.jpg)

(a) +2/2

(b) +4/5

- Computes and returns correct values from contains
```
public boolean contains(int num){
    return num >= min && num <= max;
    }
}
```
(c) +0/2
```
public boolean contains(int num){
    for(NumberGroup group : groupList){
        if(group.contains(num)){
            return true;
        }
    }
    return false;
}
```

## Github

| Artifact | Link |
| -- | -- |

