<h2 align="center"> <a href="https://rachelklee.github.io/csa-datastructures/">Home</a> | <a href="https://rachelklee.github.io/csa-datastructures/techtalknotes">Tech Talk Notes</a> | <a href="https://rachelklee.github.io/csa-datastructures/testprep">Test Prep Notes</a></h2>

# Week 6

# Goals

| Goal | Detail | Complete |
| --- | --- | --- |
| Review Iteration, Recursion, Inheritance | Review TT notes from Tri 1, Watch CB videos, Do practice quiz (CB)	| x |
| In Class full practice exam | Full MC and FRQ Timed, completed in class | x |
| At least 1 extra FRQ | Full old FRQ from CB, Timed, outside of class | x |
| Barron's Book practice exam |	Full Practice Exam 1, Timed, outside of class |

# Additional Notes

* Continue to work on timing so you don't have to guess on mc and have time to check answers
* Make sure to be super careful on mc, eliminate silly mistakes

# Corrections

## MC: Live Score 24/40

| Number | Original Choice | Correct Choce | Reasoning |
| --- | --- | --- | --- |
| 3 | E | C | The code segment takes the absolute value of the difference between marker1 and marker2, always producing a positive distance, and then divides the result by the vehicle’s speed. |
| 10 | C | D | The for loop iterates from i = 0 to i = 19. The expression i % num2 == 0 evaluates to true when i is divisible by 5 and the expression i % 2 == 0 evaluates to true when i is even. The only values in the range 0 to 19, inclusive, that are both divisible by 5 and even are 0 and 10, so the statement prints "0 10 ". | 11 | D | C | During the first iteration of the while loop, num is decremented and "9" is printed. During the second iteration, num is decremented and "8" is printed. This continues until the last iteration of the loop, when num is decremented and "1" is printed. At this point, the Boolean expression in the while loop evaluates to false and the loop terminates. The code segment prints "987654321". |
| 12 | C | B | Condition I is incorrect. If no Person object has been assigned to borrower, the method call borrower.equals(null) throws a NullPointerException. Condition II is correct. This condition ensures that borrower contains a reference to an object when it is used in the println method call that follows. Condition III is incorrect. If no Person object has been assigned to borrower, the method call borrower.getName() throws a NullPointerException. |
| 13 | B | E | By De Morgan’s laws, !(a && b) is equivalent to !a || !b and the entire expression is equivalent to !a || !b || c. |
| 14 | E | D | Code segment I uses multi-way selection to assign and return the correct category. Code segment II returns "rural" for all values of density because it uses a series of one-way selection statements instead of multi-way selection. Code segment III returns the correct category through the use of an immediate return within each of the one-way selection statements. |
| 15 | D | E | The random method returns a value between 0.0, inclusive, and 1.0, exclusive. Multiplying that value by a and casting to an int produces a result between 0 and a - 1, inclusive. The sum of a and a value between 0 and a - 1, inclusive, is a value between a and 2 * a - 1, inclusive. |
| 16 | D | B | The recursive call of the stars method occurs before any output is printed, so the method call stars(5) results in a recursive call to stars(4), then to stars(3), then to stars(2), and finally to stars(1). The call to stars(1) returns immediately without printing any output, so the first call that produces output is stars(2), which prints a row of two stars. Then, stars(3) prints a row of three stars, stars(4) prints a row of four stars, and finally stars(5) prints a row of five stars. |
| 17 | E | D | Since j is instantiated as a SuperHero object, the j.powerUp(10) method call accesses the subclass method. The subclass method uses the super keyword to access the superclass method with the parameter 20. As a result, the instance variable power is incremented by 20. |
| 22 | B | A | Line 12 is executed each time the variable sm is updated because a new smallest value is found. When j has the value 0, sm is updated for "day" and "of". When j has the value 1, sm is updated for "of". When j has the value 4, sm is updated for "year". When j has any of the values 2, 3, or 5, sm is not updated. Line 12 is executed four times. |
| 24 | A | D | Since y is declared as a static variable, it is associated with the class and all objects of the class share the single variable y. Each time a new SomeClass object is instantiated, the value of y is incremented by 1. After the third object is instantiated, the value of y is 3. The call to incrementY with no parameter increments the value of y by 1, and the call to incrementY with a parameter value of 10 adds 10 to the value of y, resulting in 14. |
| 26 | D | C | There are m * n iterations of the for loop in code segment I. In code segment II, the outer loop executes m times and the inner loop executes n - 1 times for each iteration of the outer loop. There are m * n - m iterations of the inner loop in code segment II, so "A" is printed m more times than "B" is printed. |
| 27 | B | E | When b has the value false, both of the expressions (a && b) and (!a && b) evaluate to false, regardless of the value of a. The entire expression evaluates to (false or false), or false. When b has the value true, one of the expressions (a && b) or (!a && b) evaluates to true. The entire expression, in this case, is either (true or false) or (false or true), or true. A truth table can be used to summarize these results. |
| 28 | D | B | The method abMethod(String a, String b) removes all non-overlapping occurrences of string b from string a and returns the resulting String. It does this by repeatedly setting x to the index of an occurrence of b in a, then assigning a the result of the concatenation of the parts of a before and after the occurrence of b. The method call abMethod("sing the song", "ng") removes all occurrences of "ng" from "sing the song", returning "si the so". |
| 40 | E | A | At compile time, methods in or inherited by the declared type determine the correctness of a non-static method call. In line 1, obj1 is declared as an object of type A. Therefore, at compile time, there must be a message method in class A or its superclass. If the message method in class A is removed, the statement in line 3 will no longer compile. |


## FRQ: Live Score

### REPL: 

### Paper

![PXL_20220428_155120654](https://user-images.githubusercontent.com/77082379/166162489-fd3cbc89-9037-4ba6-9b59-2e831b23b260.jpg)
![PXL_20220428_155127147](https://user-images.githubusercontent.com/77082379/166162495-996a0606-542c-43a7-890f-4971816c5067.jpg)
![PXL_20220428_155132139](https://user-images.githubusercontent.com/77082379/166162500-524f20a0-2177-4a51-861c-9b808d20038d.jpg)


## Github

| Artifact | Link |
| -- | -- |
| Ticket | [Issue](https://github.com/rachelklee/csa-datastructures/issues/7) |

