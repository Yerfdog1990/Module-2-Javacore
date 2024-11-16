package ArrayToHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class ListItems {
    String key;
    int value;

    //Constructor
    public ListItems(int value, String key) {
        this.value = value;
        this.key = key;
    }
    //Getters
    public int getValue() {
        return value;
    }
    public String getKey() {
        return key;
    }
    //Main method
    public static void main(String[] args) {
        //Create a list collection to store the elements
        List<ListItems> list = new ArrayList<>();
        list.add(new ListItems(1,"I"));
        list.add(new ListItems(2,"love"));
        list.add(new ListItems(3,"java"));
        list.add(new ListItems(4,"programming"));

        //Create a hashmap to store elements
        HashMap<Integer, String> hashMap = new HashMap<>();

        //Covert list to HashMap
        list.forEach((n)-> hashMap.put(n.getValue(), n.getKey()));

        //print hashmap
        System.out.println("Map using lambda expression: " +hashMap);

        //Using Anonymous Class
        list.forEach(new Consumer<ListItems>() {
            @Override
            public void accept(ListItems listItems) {
                hashMap.put(listItems.getValue(), listItems.getKey());
            }
        });
        System.out.println("Map using anonymous class: " +hashMap);
    }
}
