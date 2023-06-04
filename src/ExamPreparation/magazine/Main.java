package ExamPreparation.magazine;

public class Main {
    public static void main(String[] args) {

        Magazine magazine = new Magazine("Zara", 20);

        Cloth cloth1 = new Cloth("red", 36, "dress");

        System.out.println(cloth1);

        magazine.addCloth(cloth1);

        System.out.println(magazine.removeCloth("black"));

        Cloth cloth2 = new Cloth("brown", 34, "t-shirt");
        Cloth cloth3 = new Cloth("blue", 32, "jeans");

        magazine.addCloth(cloth2);
        magazine.addCloth(cloth3);

        Cloth smallestCloth = magazine.getSmallestCloth();

        System.out.println(smallestCloth);

        Cloth getCloth = magazine.getCloth("brown");

        System.out.println(getCloth);

        System.out.println(magazine.report());
    }
}