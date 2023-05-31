package DefiningClasses.Exercise.P02_CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;

    public Department(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public double getAverageSalary() {
        double sumSalary = 0;
        for (Employee employee : employeeList) {
            sumSalary += employee.getSalary();
        }
        return sumSalary / employeeList.size();
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public String getName() {
        return this.name;
    }
}
