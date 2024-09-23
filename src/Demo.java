import java.util.ArrayList;

public abstract class Demo {
    String cardName;
    int cardNumber;

    public Demo(int cardNumber, String cardName) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
    }
    void draw() {
    }
}
class King extends Demo{
    public King(int cardNumber, String cardName) {
        super(cardNumber, cardName);
    }
    @Override
    void draw() {
        System.out.println("Drawing a King.");
    }
}
class Queen extends Demo{
    String status;

    public Queen(int cardNumber, String cardName, String status) {
        super(cardNumber, cardName);
        this.status = status;
    }

    @Override
    void draw() {
        System.out.println("Drawing Queen.");
    }
}
class Diamond extends Demo{
    public Diamond(int cardNumber, String cardName) {
        super(cardNumber, cardName);
    }
    @Override
    void draw() {
        System.out.println("Drawing Diamond.");
    }
}
class Heart extends Demo{
    public Heart(int cardNumber, String cardName) {
        super(cardNumber, cardName);
    }
    @Override
    void draw() {
        System.out.println("Drawing Heart.");
    }
}
class MainApp{
    public static void main(String[] args) {
        King kingCard = new King(20,"King");
        kingCard.draw();
        System.out.println("Card name: " +kingCard.cardName+ ", Card number: " +kingCard.cardNumber);
        Heart heartCard = new Heart(30, "Heart");
        heartCard.draw();
        System.out.println("Card name: " +heartCard.cardName+ ", Card number: " +heartCard.cardNumber);
        Queen queenCard = new Queen(50, "Queen", "Royalty");
        queenCard.draw();
        System.out.println("Card name: " +queenCard.cardName+ ", Card number: " +queenCard.cardNumber+ ", My status is " + queenCard.status);
        Demo diamondCard = new Diamond(15, "Diamond");
        diamondCard.draw();
        System.out.println("Card name: " +diamondCard.cardName+ ", Card number: " +diamondCard.cardNumber);
        ArrayList<Demo> cards = new ArrayList<Demo>();
        for(Demo items : cards){
            items.draw();
        }
    }
}