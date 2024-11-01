public class PrimeFactors {
    public static void main(String[] args) {
     findPrimaNumbers(132);
    }
    static void findPrimaNumbers(int n){
        if(n <= 1){
            return; 
        }
        for (int i = 2; i <= n; i++) {
            if(n % i == 0){
                System.out.print(i+ ", ");
                findPrimaNumbers(n/i);
                break;
            }
        }
    }
}
