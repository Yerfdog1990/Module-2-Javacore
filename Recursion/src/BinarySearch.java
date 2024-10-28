public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int target = 70;
        int result = performBinarySearch(array, target, 0, array.length-1);
        if(result == -1){
            System.out.println("Target number not found");
        }else{
            System.out.println("Target number is located at index: " +result);
        }
    }
      private static int performBinarySearch(int[] array, int target, int low, int high){
          if(low > high){
              return -1;
          }
          int mid = (low + high)/2;
          if(array[mid] == target){
              return mid;
          }
          if(array[mid] > target){
              return performBinarySearch(array, target, low, mid-1);
          }else{
              return performBinarySearch(array, target, mid+1, high);
          }
      }
}
