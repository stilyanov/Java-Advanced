package Generics.P03_GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale scale = new Scale<>(10, 5);
        System.out.println(scale.getHeavier());
    }
}
