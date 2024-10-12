package Super_Extend_List;

//Creating Generic Classes:
// To create a generic class, you need to use a type parameter, which is specified within angle brackets (<T>) following the class name.
public class GenericsIntro <T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
class GenericsUtil{
    //Creating Generic Methods:
    //To create a generic method, you need to specify the type parameter(s) within angle brackets before the return type of the method.
    public static <T> void printData(T data){
        System.out.println("Data: " +data);
    }
}
class MainMethod{
    public static void main(String[] args) {
        GenericsIntro<String> stringGenericsIntro = new GenericsIntro<>();
        stringGenericsIntro.setData("Hello word");
        GenericsIntro<Integer> integerGenericsIntro = new GenericsIntro<>();
        integerGenericsIntro.setData(34);
        GenericsIntro<Double> doubleGenericsIntro = new GenericsIntro<>();
        doubleGenericsIntro.setData(4.56);

        GenericsUtil.printData("Hello world.");
        GenericsUtil.printData(56);
        GenericsUtil.printData("4.57");
    }
}
