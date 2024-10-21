//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Object obj1 = new Integer(5);
        boolean init1 = obj1 instanceof Integer;
        System.out.println(init1);

        Object obj2 = "Mama";
        boolean init2 = obj2 instanceof String;
        System.out.println(init2);
    }
}