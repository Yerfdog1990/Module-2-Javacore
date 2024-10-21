package SwitchExpression;

import java.util.Scanner;

public class Citizenship {
    public static void main(String[] args) {
        try (Scanner userInput = new Scanner(System.in)){
            System.out.print("Enter county: ");
            String country = userInput.nextLine();
            useSwitchStatement(country);
            useSwitchExpression(country);
            useYieldKeyword(country);
        }
    }
    static void useSwitchStatement(String country){
        String continent = " ";
        switch (country){
            case "Kenya":
                continent = "Africa";
                break;
            case "Zambia":
                continent = "Africa";
                break;
            case "Benin":
                continent = "Africa";
                break;
            case "Brazil":
                continent = "South America";
                break;
            case "Uruguay":
                continent = "South America";
                break;
            case "Argentina":
                continent = "South America";
                break;
            case "France":
                continent = "Europe";
                break;
            case "England":
                continent = "Europe";
                break;
            case "Spain":
                continent = "Europe";
                break;
            case "Canada":
                continent = "North America";
                break;
            case "USA":
                continent = "North America";
                break;
            case "Thailand":
                continent = "Asia";
                break;
            case "China":
                continent = "Asia";
                break;
            case "India":
                continent = "Asia";
                break;
            case "Australia":
                continent = "Australia";
                break;
            default:
                System.out.println("Unknown continent.");
        }
        System.out.println("\nResult using switch statement:");
        System.out.println(country+ " is found in " +continent);
    }
    static void useSwitchExpression(String country){
        String continent = " ";
        switch (country){
            case "Kenya", "Zambia", "Benin" -> continent = "Africa";
            case "Brazil", "Uruguay", "Argentina" -> continent = "South America";
            case "France", "England", "Spain" -> continent = "Europe";
            case "Canada", "USA" -> continent = "North America";
            case "Thailand", "China", "India" -> continent = "Asia";
            case "Australia" -> continent = "Australia";
            default -> continent = "Unknown continent.";
        }
        System.out.println("\nResult using switch expression:");
        System.out.println(country+ " is found in " +continent);
    }
    static String useYieldKeyword(String country){
        var result = switch (country){
            case "Kenya", "Zambia", "Benin" -> {
                System.out.println("\nResult using yield keyword:");
                System.out.println(country + " is found in Africa.");
                yield "Africa";
            }
            case "France", "England", "Spain" -> {
                System.out.println("\nResult using yield keyword:");
                System.out.println(country + " is found in Europe.");
                yield "Europe";
            }
            case "Canada", "USA" -> {
                System.out.println("\nResult using yield keyword:");
                System.out.println(country + " is found in North America.");
                yield "North America";
            }
            case "Brazil", "Uruguay", "Argentina" -> {
                System.out.println("\nResult using yield keyword:");
                System.out.println(country + " is found in South America.");
                yield "South America";
            }
            case "Thailand", "China", "India" ->  {
                System.out.println("\nResult using yield keyword:");
                System.out.println(country + " is found in Asia.");
                yield "Asia";
            }
            case "Australia" ->  {
                System.out.println("\nResult using yield keyword:");
                System.out.println(country + " is found in Australia.");
                yield "Australia";
            }
            default -> {
                System.out.println("Unknown continent");
                yield "Unknown continent";
            }
        };
        return result;
    }
}
