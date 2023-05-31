package DefiningClasses.Exercise.P07_Google;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Person> personData = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] inputData = input.split("\\s+");
            String personName = inputData[0];

            if (!personData.containsKey(personName)) {
                personData.put(personName, new Person());
            }
            String typeCommand = inputData[1];
            switch (typeCommand) {
                //•	"{Name} company {companyName} {department} {salary}"
                //•	"{Name} pokemon {pokemonName} {pokemonType}"
                //•	"{Name} parents {parentName} {parentBirthday}"
                //•	"{Name} children {childName} {childBirthday}"
                //•	"{Name} car {carModel} {carSpeed}"
                case "company":
                    String companyName = inputData[2];
                    String department = inputData[3];
                    double salary = Double.parseDouble(inputData[4]);
                    Company company = new Company(companyName, department, salary);
                    personData.get(personName).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = inputData[2];
                    String pokemonType = inputData[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personData.get(personName).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = inputData[2];
                    String parentBirthday = inputData[3];
                    Parent parent = new Parent(parentName, parentBirthday);
                    personData.get(personName).getParents().add(parent);
                    break;
                case "children":
                    String childName = inputData[2];
                    String childBirthday = inputData[3];
                    Child child = new Child(childName, childBirthday);
                    personData.get(personName).getChildren().add(child);
                    break;
                case "car":
                    String carModel = inputData[2];
                    int carSpeed = Integer.parseInt(inputData[3]);
                    Car car = new Car(carModel, carSpeed);
                    personData.get(personName).setCar(car);
                    break;
            }

            input = scanner.nextLine();
        }
        String searchedPerson = scanner.nextLine();
        System.out.println(searchedPerson);

        Person personalData = personData.get(searchedPerson);
        System.out.println(personalData);
    }
}