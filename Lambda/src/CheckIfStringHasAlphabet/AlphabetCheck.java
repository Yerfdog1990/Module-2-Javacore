package CheckIfStringHasAlphabet;

import java.util.Scanner;
import java.util.function.Predicate;

public class AlphabetCheck {
    public static void main(String[] args) {
        Predicate<String> isAlphabetOnly = string -> (string.chars().allMatch(Character::isLetter));
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nEnter text: ");
        String text = userInput.nextLine();
        System.out.println("The word " + "\""+text+ "\"" + " contains only alphabets: " + isAlphabetOnly.test(text));

        //Close scanner
        userInput.close();
    }
}
