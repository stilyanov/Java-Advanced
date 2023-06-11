package IteratorsAndComparators.Exercise.P05_ComparationObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String inputData = scanner.nextLine();
        while (!inputData.equals("END")) {
            String[] data = inputData.split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String town = data[2];

            Person person = new Person(name, age, town);
            people.add(person);

            inputData = scanner.nextLine();
        }

        int importantPersonIndex = Integer.parseInt(scanner.nextLine());
        int allPeopleCount = people.size();
        int samePeople = 1;
        boolean founded = false;

        Person mainPerson = people.get(importantPersonIndex - 1);

        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).compareTo(people.get(importantPersonIndex - 1)) == 0 && i != importantPersonIndex - 1) {
                samePeople++;
                founded = true;
            }
        }

        if (founded) {

            System.out.println(String.join(" ", String.valueOf(samePeople), String.valueOf(people.size() - samePeople), String.valueOf(allPeopleCount)));
        } else {
            System.out.println("No matches");
        }

    }
}
