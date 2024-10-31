public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {13, 23, 34, 39, 40, 41, 51, 67, 79, 80, 91};
        int target = 91;
        int low = 0;
        int high = array.length - 1;
        int binaryResult = recursiveBinarySearch(array, target, low, high);
        if(binaryResult == -1){
            System.out.printf("Sorry, %d does not exist. Try again.", target);
        }else{
            System.out.printf("Binary search successful! %d is located are index %d.", target, binaryResult);
        }
        int iterativeResult = iterativeBinarySearch(array, 99, 0, array.length-1);
        if(binaryResult == -1){
            System.out.printf("\nSorry, %d does not exist. Try again.", target);
        }else{
            System.out.printf("\nBinary search successful! %d is located are index %d.", target, iterativeResult);
        }
    }
    //Binary search using recursion
    static int recursiveBinarySearch(int[] array, int target, int low, int high){
        while(low <= high){
            return -1;
        }
        int mid = (high + low)/2;
        if(array[mid] == target){
            return mid;
        }
        if(array[mid] > target){
            return recursiveBinarySearch(array, target, low, mid-1);
        }else{
            return recursiveBinarySearch(array, target, mid+1, high);
        }
    }
    //Binary search using iteration
    static int iterativeBinarySearch(int[] array, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
