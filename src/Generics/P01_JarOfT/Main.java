package Generics.P01_JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<Integer> integerJar = new Jar<>();

        integerJar.add(5);
        integerJar.add(9);
        integerJar.add(7);
        integerJar.add(4);
        integerJar.add(1);
        System.out.println();

        integerJar.remove();
        System.out.println();
    }
}
