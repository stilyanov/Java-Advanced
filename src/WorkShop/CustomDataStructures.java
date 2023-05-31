package WorkShop;

import java.util.Scanner;

public class CustomDataStructures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SmartArray smartArray = new SmartArray();
        smartArray.add(10);
        smartArray.add(20);
        smartArray.add(30);
        smartArray.add(40);
        smartArray.add(50);

        int get2 = smartArray.get(2);
        int get1 = smartArray.get(1);
        int get4 = smartArray.get(4);
//        int get8 = smartArray.get(8);

        System.out.println(get2);
        System.out.println(get1);
        System.out.println(get4);
//        System.out.println(get8);

        smartArray.remove(0);

        boolean isItContains = smartArray.contains(20);
        boolean isItContains2 = smartArray.contains(10);

        System.out.println(isItContains);
        System.out.println(isItContains2);

        smartArray.add(0, 10);
        System.out.println();
    }
}
