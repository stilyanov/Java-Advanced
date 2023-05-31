package DefiningClasses.Exercise.P02_CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, Department> departmentHashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputData = scanner.nextLine().split("\\s+");
            String name = inputData[0];
            double salary = Double.parseDouble(inputData[1]);
            String position = inputData[2];
            String department = inputData[3];

            Employee employee = null;

            // Peter 120.00 Dev Development peter@abv.bg 28

            if (inputData.length == 6) {
                String email = inputData[4];
                int age = Integer.parseInt(inputData[5]);
                employee = new Employee(name, salary, position, department, email, age);

            } else if (inputData.length == 5) {
                String inputDataForth = inputData[4];
                if (inputDataForth.contains("@")) {
                    String email = inputDataForth;
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(inputData[4]);
                    employee = new Employee(name, salary, position, department, age);
                }
            } else if (inputData.length == 4) {
                employee = new Employee(name,salary,position,department);
            }

            if (!departmentHashMap.containsKey(department)) {
                departmentHashMap.put(department, new Department(department));
            }

            departmentHashMap.get(department).getEmployeeList().add(employee);
        }

        Department maxAverageSalaryDepartment = departmentHashMap.entrySet().stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary())).get().getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalaryDepartment.getName());
        maxAverageSalaryDepartment.getEmployeeList()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));
    }
}
