public class TowerOfHanoi {
    public static void main(String[] args) {

        solveTowerOfHanoi(3, 'A', 'B', 'C');
    }
    static void solveTowerOfHanoi(int n, char fromRod, char toRod, char auxRod){
        if(n == 1){
            System.out.printf("\nMove disc 1 from rod %s to rod %s.", fromRod, toRod);
        }else{
            solveTowerOfHanoi(n - 1, fromRod, auxRod, toRod);
            System.out.printf("\nMove disc 2 from rod %s to rod %s.", fromRod, toRod);
            solveTowerOfHanoi(n - 1, auxRod, toRod, fromRod);
        }
    }
}
