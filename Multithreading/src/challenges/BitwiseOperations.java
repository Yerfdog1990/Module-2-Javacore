package challenges;

public class BitwiseOperations {
    public static void main(String[] args){
        int a = 10;
        int b = 20;
        int c = a & b; // AND operation
        int d = a | b; // OR operation
        int e = a ^ b; // Exclusive OR
        int f = ~a; // Complement of a
        int g = a << 2; //Left shift 2 times
        int h = a >> 2; //Right shift 2 times

        System.out.println("10 & 20 = " +c);
        System.out.println("10 | 20 = " +d);
        System.out.println("10 ^ 20 = " +e);
        System.out.println("~10 = " +f);
        System.out.println("10 << 2 = " +g);
        System.out.println("10 >> 2 = " +h);
    }
}
