package OOP3_Composition_Aggregation_Inheritance;
/*
Aggregation
Description: A specialized form of association where a class is made up of one or more classes,
but they can exist independently.
 */
public class Dad {
    private String name;
    private String citizenship;

    public Dad(String citizenship, String name) {
        this.citizenship = citizenship;
        this.name = name;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Son{
    private String sonName;
    private Dad dadCitizenship;

    public Son(Dad dadCitizenship, String sonName) {
        this.dadCitizenship = dadCitizenship;
        this.sonName = sonName;
    }

    public Dad getDadCitizenship() {
        return dadCitizenship;
    }

    public void setDadCitizenship(Dad dadCitizenship) {
        this.dadCitizenship = dadCitizenship;
    }

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

    public void displayInfo(){
        System.out.println("My name is " +getSonName()+ " and my dad's name is " + dadCitizenship.getName()+ ", coming from " +dadCitizenship.getCitizenship());
    }
}
class AggregationDemo{
    public static void main(String[] args) {
        Dad dad = new Dad("Kenya", "Godfrey");
        Son son = new Son(dad,"Cyril");
        son.displayInfo();
    }
}
