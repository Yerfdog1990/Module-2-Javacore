
public class CountdownRecursion {
    public static void main(String[] args) {
        countDown(10);
    }
    static void countDown(int x){
        if(x <= 0){
            System.out.println("Boom!");
        }else{
            System.out.println(x);
            //Recursion: By method calling itself, it first counts down by 2 each time until 0, printing each intermediate x value.
            countDown(x-2);
            //Backtracking: After reaching "Boom!", it "backtracks," printing each value of x again in ascending order as it returns from the recursive calls.
            System.out.println(x);
        }
    }
}