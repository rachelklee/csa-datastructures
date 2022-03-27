package TT2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.lang.Math;
//import java.util.Stack;

import TT2.LinkedLists.Stack;


// you can import the math for square root

// not allowed to import queue or stack
// this is used by importing the stacks function from the stack code



public class Calculator {

    private final String expression;
    private ArrayList<String> tokens;
    private ArrayList<String> reverse_polish;
    private Double result = 0.0;

    // here we're setting up our variables


    private final Map<String, Integer> OPERATORS = new HashMap<>();
    {
        OPERATORS.put("?", 3); //pythagorean theorem
        OPERATORS.put("v", 3); // square root
        OPERATORS.put("^", 3); // n power p
        OPERATORS.put("*", 3);
        OPERATORS.put("/", 3);
        OPERATORS.put("%", 3);
        OPERATORS.put("+", 4);
        OPERATORS.put("-", 4);


        // determining our operators
    }


    private final Map<String, Integer> SEPARATORS = new HashMap<>();
    {

        SEPARATORS.put(" ", 0);
        SEPARATORS.put("(", 0);
        SEPARATORS.put(")", 0);

        // determining our parenthesis
    }


    public Calculator(String expression) {

        this.expression = expression;


        this.termTokenizer();


        this.tokensToReversePolishNotation();


        this.rpnToResult();
    }


    private boolean isOperator(String token) {

        return OPERATORS.containsKey(token);
    }


    private boolean isSeperator(String token) {

        return SEPARATORS.containsKey(token);

        // determines if the string is seperated into the seperate tokens
    }


    private Boolean isPrecedent(String token1, String token2) {

        return (OPERATORS.get(token1) - OPERATORS.get(token2) >= 0) ;
    }

    // you're splitting on multiple things. its split your token using the signs and parenthesis
    // rpn is a thing computers understand. it helps them calculate math better.
    // back in the 80s, you'd have to type your stuff in a certain way.

    // steps

    // 1. get the notations
    // 2. split the token
    // 3. tokenize the expression
    // 4. reverse polish notation
    // this splits by number and operator. if its an operator, it goes into one array. if its a number, that's a seperate array.
    // you also need to set an order of precedence. for example, * is above +.
    // when you're order of precedence, you're just popping the stack
    // the first operator will take two guys off of the stack, and then calculate. two of the tokens go out.
    // then the new number and the other operator work on the next in the stack, and we have a new number.
    // if that stack has nothing left, it will return the current number.
    // 5. rpn result on the result of the above
    // what rpn does is convert everything into tokens
    // we're passing in a string
    // we tokenize by number, sign and operation


    private void termTokenizer() {

        // purpose of this is to split the string into tokens

        this.tokens = new ArrayList<>();

        int start = 0;
        StringBuilder multiCharTerm = new StringBuilder();
        for (int i = 0; i < this.expression.length(); i++) {
            Character c = this.expression.charAt(i);
            if ( isOperator(c.toString() ) || isSeperator(c.toString())  ) {

                if (multiCharTerm.length() > 0) {
                    //here, we're adding the token to a stack
                    tokens.add(this.expression.substring(start, i));
                }

                if (c != ' ') {
                    // just looking for spaces
                    tokens.add(c.toString());
                }

                start = i + 1;
                multiCharTerm = new StringBuilder();
            } else {

                multiCharTerm.append(c);
            }

        }

        if (multiCharTerm.length() > 0) {
            tokens.add(this.expression.substring(start));
        }
    }

    // we need to know if its a seperator, or an operator. for these tests, we're going to build data structure .
    // these are the things that will help us tokenize and help us later on when we're doing our math expressions


    private void tokensToReversePolishNotation () {

        this.reverse_polish = new ArrayList<>();


        Stack tokenStack = new Stack(); // tokenStack is an object of Stack
        for (String token : tokens) {
            switch (token) {

                case "(":
                    tokenStack.push(token);
                    break;
                case ")":
                    while (tokenStack.peek() != null && !tokenStack.peek().equals("("))
                    {
                        reverse_polish.add( (String)tokenStack.pop() );
                    }
                    tokenStack.pop();
                    break;
                // we're going to push stuff into the stack, and that's going to cause thing sto go out of the stack.
                //helps parenthesis. remember PEMDAS
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                case "^": // power
                case "v": // sqrt
                case "?": // pythagorean theorem

                    while (tokenStack.peek() != null && isOperator((String) tokenStack.peek()))
                    {
                        if ( isPrecedent(token, (String) tokenStack.peek() )) {
                            reverse_polish.add((String)tokenStack.pop());
                            continue;
                        }
                        break;
                    }

                    tokenStack.push(token);
                    break;
                default:
                    this.reverse_polish.add(token);
            }
        }

        while (tokenStack.peek() != null) {
            reverse_polish.add((String)tokenStack.pop());
        }

    }


    private void rpnToResult()
    {

        Stack stack = new Stack();


        for (String token : this.reverse_polish)
        {

            if (!isOperator(token))
            {
                stack.push(token);
            }
            else
            {

                Double operand1 = Double.valueOf( (String)stack.pop() );
                Double operand0 = Double.valueOf( (String)stack.pop() );


                Double result;
                switch (token) {
                    case "+":
                        result = operand0 + operand1;
                        break;
                    case "-":
                        result = operand0 - operand1;
                        break;
                    case "*":
                        result = operand0 * operand1;
                        break;
                    case "/":
                        result = operand0 / operand1;
                        break;
                    case "%":
                        result = operand0 % operand1;
                        break;
                    case "^": //this is for power
                        result = Math.pow(operand0, operand1);
                        break;
                    case "v": //this is for sqrt
                        result = Math.sqrt(operand0);
                        break;
                    case "?": //this is for pythagorean theorem
                        result = Math.sqrt(Math.pow(operand0, 2) + Math.pow(operand1, 2));
                        break;
                    default:
                        result = 0.0;
                }


                stack.push( String.valueOf( result ));
            }
        }

        this.result = Double.valueOf((String)stack.pop());
    }

    //
    public String toString() {
        return ("Original expression: " + this.expression + "\n" +
                "Tokenized expression: " + this.tokens.toString() + "\n" +
                "Reverse Polish Notation: " +this.reverse_polish.toString() + "\n" +
                "Final result: " + String.format("%.2f", this.result));
    }


    public static void main(String[] args) {

        Calculator simpleMath = new Calculator("100 + 200  * 3");
        System.out.println("SIMPLE (BASIC)\n" + simpleMath);

        // what is simpleMath? simpleMath is an object of the Calculator class
        // you can do scanner, but that's a seperate option. we want it so that we can calculate testing
        // consider parenthesis, we want to break down a string of numbers
        System.out.println();

        Calculator parenthesisMath = new Calculator("(100 + 200)  * 3"); // The stuff in the parenthesis is a token
        System.out.println("PARENTHESIS\n" + parenthesisMath);

        //


        System.out.println();

        Calculator fractionMath = new Calculator("100.2 - 99.3");
        System.out.println("FRACTION\n" + fractionMath);

        System.out.println();

        Calculator moduloMath = new Calculator("300 % 200");
        System.out.println("MODULO\n" + moduloMath);

        System.out.println();

        Calculator divisionMath = new Calculator("300/200");
        System.out.println("DIVISION\n" + divisionMath);

        System.out.println();

        Calculator multiplicationMath = new Calculator("300 * 200");
        System.out.println("MULTIPLICATION\n" + multiplicationMath);

        System.out.println();

        Calculator allMath = new Calculator("200 % 300 + 5 + 300 / 200 + 1 * 100");
        System.out.println("EXPRESSION 1\n" + allMath);

        System.out.println();

        Calculator allMath2 = new Calculator("200 % (300 + 5 + 300) / 200 + 1 * 100");
        System.out.println("EXPRESSION 2\n" + allMath2);

        System.out.println();

        Calculator allMath3 = new Calculator("200%(300+5+300)/200+1*100");
        System.out.println("EXPRESSION 3\n" + allMath3);

        // add the same, but for power
        System.out.println();

        Calculator powerMath = new Calculator("3 ^ 2");
        System.out.println("POWER\n" + powerMath);

        // add the same, but for square root
        System.out.println();

        Calculator sqrtMath = new Calculator("9 v 0");
        System.out.println("SQUARE ROOT\n" + sqrtMath);

        // add the same, but for pythagorean
        System.out.println();

        Calculator ptMath = new Calculator("3 ? 4");
        System.out.println("PYTHAGOREAN THEOREM\n" + ptMath);

    }
}