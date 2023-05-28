package DefiningClasses.BankAccount;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        while (!input.equals("End")) {
            String[] inputParts = input.split("\\s+");
            String command = inputParts[0];

            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                accounts.put(bankAccount.getId(), bankAccount);
                System.out.println("Account ID" + bankAccount.getId() + " created");

            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(inputParts[1]);
                int deposit = Integer.parseInt(inputParts[2]);

                if (!accounts.containsKey(id)) {
                    System.out.println("Account does not exist");
                } else {
                    accounts.get(id).deposit(deposit);
                    System.out.println("Deposited " + deposit + " to ID" + accounts.get(id).getId());                }

            } else if (command.equals("SetInterest")) {
                double interest = Double.parseDouble(inputParts[1]);
                BankAccount.setInterestRate(interest);

            } else if (command.equals("GetInterest")) {
                int id = Integer.parseInt(inputParts[1]);
                int years = Integer.parseInt(inputParts[2]);

                if (!accounts.containsKey(id)) {
                    System.out.println("Account does not exist");
                } else {
                    System.out.printf("%.2f%n", accounts.get(id).getInterestRate(years));
                }
            }


            input = scanner.nextLine();
        }
    }
}