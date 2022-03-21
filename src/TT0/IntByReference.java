package TT0;

public class IntByReference {
    public int value;

    // Hack: create TT0.IntByReference, swapToLowHighOrder and toString methods
    public IntByReference(int n){
        value = n;
    }
    public void swapToLowHighOrder(IntByReference n){
   
        //If the the current value is larger, then swap the values
        //If you use n.value instead of temp, then it makes 
        //both values to what the original value was
        if (value > n.value){
            //Create a temperary value for switching
            int temp = n.value;
            n.value = value;
            value = temp;
        }
    }
    public String intoString(){
        return String.valueOf(value);
    }
    // static method that enables me to see numbers swapped by reference (before, after)
    public static void swapper(int n0, int n1) {
        IntByReference a = new IntByReference(n0);
        IntByReference b = new IntByReference(n1);
        System.out.println("Before: " + a.intoString() + " " + b.intoString());
        a.swapToLowHighOrder(b);  // conditionally build swap method to change values of a, b
        System.out.println("After: " + a.intoString() + " " + b.intoString());
        System.out.println();
    }

    // static main method that provides some simple test cases
    public static void main(String[] ags) {
        IntByReference.swapper(21, 16);
        IntByReference.swapper(16, 21);
        IntByReference.swapper(16, -1);
    }
}
