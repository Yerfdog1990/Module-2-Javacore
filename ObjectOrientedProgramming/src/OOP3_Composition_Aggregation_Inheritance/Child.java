package OOP3_Composition_Aggregation_Inheritance;
/*
Association represents a general relationship between two classes where one class uses or interacts with another.
This relationship can be one-to-one, one-to-many, or many-to-many.
1. One-to-One Association
Description: In a one-to-one association, one instance of a class is associated with one instance of another class.
For example, each child has one mother.
 */
class Child {
    private String childName;
    private Mother mother;

    public Child(String childName) {
        this.childName = childName;
    }

    public Mother getMother() {
        return mother;
    }
    public void displayInfo(){
        String childMother = (mother != null)? mother.getMotherName() : "No mother";
        System.out.println(getChildName()+"'s " +"mother is called " +childMother);
        String childCitizenship = (mother != null)? mother.getCitizenship() : "Country of birth unknown";
        System.out.println(getChildName() + " was born in " +childCitizenship);
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    public String getChildName() {
        return childName;
    }
}
class Mother{
    private String motherName;
    private String citizenship;

    public Mother(String citizenship, String motherName) {
        this.citizenship = citizenship;
        this.motherName = motherName;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }
}
class oneToOneAssociation{
    public static void main(String[] args) {
        Child child = new Child("Godfrey");
        Mother mother = new Mother("Kenya", "Seline");
        child.setMother(mother);
        child.displayInfo();
    }
}

