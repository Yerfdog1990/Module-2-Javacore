import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Main {
    // Comparator to sort arrays by length
    static Comparator<String[]> sortByLength = new Comparator<String[]>() {
        @Override
        public int compare(String[] o1, String[] o2) {
            return o1.length - o2.length;
        }
    };

    public static void main(String[] args) {
        String[] array1 = {"Boy", "Girl", "Cow", "Tin", "Pot"};
        String[] array2 = {"I", "really", "love", "Java Programming"};
        String[] array3 = {"if", "then", "else"};

        List<String[]> arrayList = new ArrayList<>();
        arrayList.add(array1);
        arrayList.add(array2);
        arrayList.add(array3);

        // Sort the list by the length of each array using the Comparator instance
        arrayList.sort(sortByLength);

        // Print the sorted arrays
        System.out.println("\nSorted using Comparator instance:");
        for (String[] array : arrayList) {
            System.out.println(Arrays.toString(array));
        }

        // Similar results by creating an anonymous class
        arrayList.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1.length - o2.length;
            }
        });

        // Print the sorted arrays using the anonymous class
        System.out.println("\nSorted using anonymous class:");
        for (String[] array : arrayList) {
            System.out.println(Arrays.toString(array));
        }

        // Similar results by applying lambda expression
        arrayList.sort((o1, o2)-> o1.length - o2.length);

        //Printing sorted array
        System.out.println("\nSorted using lambda expression:");
        for(String[] array : arrayList){
            System.out.println(Arrays.toString(array));
        }
    }

}