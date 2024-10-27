
public class CountupRecursion {
    public static void main(String[] args) {
        countDown(0);
    }
    static void countDown(int x){
        if(x >= 10){
            System.out.println("Boom!");
        }else{
            System.out.println(x);
            //Recursion: By method calling itself, it first counts up by 2 each time until 10, printing each intermediate x value.
            countDown(x+2);
            //Backtracking: After reaching "Boom!", it "backtracks," printing each value of x again in ascending order as it returns from the recursive calls.
            System.out.println(x);
        }
    }
}