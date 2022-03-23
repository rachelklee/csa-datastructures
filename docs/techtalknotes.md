<h2 align="center"> <a href="https://rachelklee.github.io/csa-datastructures/">Home</a> | <a href="https://rachelklee.github.io/csa-datastructures/techtalknotes">Tech Talk Notes</a> | <a href="https://rachelklee.github.io/csa-datastructures/testprep">Test Prep Notes</a></h2>

# Tech Talk Notes

## Tech Talk Week 0
- data structure is a method of organizing data
     - variable holding value, sequence of numbers, tables of data, databases
- Data structures and algorithms all programmers to build computer programs and create efficient code
- Imperative Paradigm --> using statements to change a programs state, commands for computer to do something
     - procedural programming like Python
- Object Oriented Paradigm --> Relies on classes and objects, reusable pieces of code
     - Java
     - Data structures include arrays/lists, dictionaries/hashmaps 

## Tech Talk Week 1
- array (any variable assignment) can be considered a data structure
- generic type --> you can pass any type of value into the angle brackets, wildcard
- implements has no code, just the abstract method definition as opposed to extends
- use iterable to make enhanced for loop (iterable) work for data structure
- in-queue, push: adding to the queue, add to tail (end)
     - head remains constant as you in-queue 
- de-queue, pop: removing from the queue, remove from head (start)
     - tail remains constant as you de-queue
- Queue has a linked list (it is a data structure)

Challenge 1:
- add/delete from queue

Challenge 2: 
- function called peek to peek into data and return, does not pop or push
     - ordered queues, de-queue the two queues

Challenge 3: 
- Build a queue: load it up, print it (standard order), push into the stack (reverse order)
     - [Example](https://github.com/nighthawkcoders/nighthawk_csa/blob/master/src/main/java/com/nighthawk/csa/utility/LinkedLists/Stack.java)
- null --> done with loop


## Tech Talk Week 2
- Start with calc class, give it a string (mostly mathematical expressions)
- Create an object, use a toString to print output
- Mathmatical expression into tokens (numbers, operators)
- Turn tokens into reverse polish notation (??)
- write rpmtoresult function
- Things to use
     - Use split with multiple operators (use hashmap to look them up)
     - Separators are spaces, parenthesis
     - walk thorugh with debugger to understand how data is constructed
- Process RPN with stack
     - Off RPN list
          - if number: push token
          - if op: pop 2, eval, push result
     - pop result 
        
1. Term tokenizer (separate string using separators and operators using loops)
2. Reverse polish notation (shuffle around and pop)
- Tokens 1+2*3
- RPN: 123*+
- Tokens: 1*2+3
- RPN: 12*3+
3. Calculate result (for loop on the list)
- If token is number push to stack
- else pop two entries and calculate 
Challenge:
- Build n power of operator (need to keep track of second operator)
- EC
     - assign variable (a=2; a+1)
     - build algorithm like SQRT(), look at shunting yard algorithm
