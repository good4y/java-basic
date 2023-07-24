package chap11.challenge;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Employee e1 = new Employee("John", "Doe", 2010);
        Employee e2 = new Employee("Mary", "Jane", 2012);
        Employee e3 = new Employee("Sam", "Smith", 2014);
        Employee e4 = new Employee("Sue", "Smith", 2014);
        Employee e5 = new Employee("Jane", "Doe", 2010);
        Employee e6 = new Employee("John", "Smith", 2013);

        List<Employee> employeeList = List.of(e1, e2, e3, e4, e5, e6);
        printEmployees(employeeList, "yearsWorked");
    }

    public static void printEmployees(List<Employee> employees, String sortType) {
        class DecoratedEmployee {
            Employee containedEmployee;
            private String fullName;
            private int yearsWorked;

            public DecoratedEmployee(Employee containedEmployee) {
                this.containedEmployee = containedEmployee;
                this.fullName = containedEmployee.firstName() + " " + containedEmployee.lastName();
                this.yearsWorked = LocalDate.now().getYear() - containedEmployee.hireDate();
            }

            @Override
            public String toString() {
                return "%s has been an employee for %d years".formatted(fullName, yearsWorked);
            }
        }

        List<DecoratedEmployee> decoratedEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            decoratedEmployees.add(new DecoratedEmployee(employee));
        }

        Comparator<DecoratedEmployee> comparator = new Comparator<DecoratedEmployee>() {
            @Override
            public int compare(DecoratedEmployee o1, DecoratedEmployee o2) {

                if(sortType.equalsIgnoreCase("name"))
                    return o1.fullName.compareTo(o2.fullName);
                else if(sortType.equalsIgnoreCase("yearsWorked"))
                    return o1.yearsWorked - o2.yearsWorked;
                else
                    return 0;
            }
        };

        decoratedEmployees.sort(comparator);

        for (DecoratedEmployee decoratedEmployee : decoratedEmployees) {
            System.out.println(decoratedEmployee);
        }
    }
}
