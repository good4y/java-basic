package chap11.nestedclasses;

import chap11.nestedclasses.domain.Employee;
import chap11.nestedclasses.domain.StoreEmployee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>(List.of(
            new Employee(10001, "Ralph", 2015),
            new Employee(10005, "Carole", 2021),
            new Employee(10022, "Jane", 2013),
            new Employee(13151, "Laura", 2020),
            new Employee(10050, "Jim", 2018)));

//        var comparator = new EmployeeComparator<>();
//        employees.sort(comparator);

        employees.sort(new Employee.EmployeeComparator<>("yearStarted").reversed());

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("Store Members");

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
           new StoreEmployee(10015, "Meg", 2019, "Target"),
           new StoreEmployee(10515, "Joe", 2021, "Walmart"),
           new StoreEmployee(10105, "Tom", 2020, "Macys"),
           new StoreEmployee(10215, "Marty", 2018, "Walmart"),
           new StoreEmployee(10322, "Bud", 2016, "Target")
        ));

        // 내부 클래스를 초기화하기 위해 외부 클래스의 인스턴스가 필요하다.
        // 내부 클래스는 암시적으로 외부 클래스의 인스턴스를 참조하기 때문에 아래와 같이 인스턴스화된 외부 클래스로 초기화해야 한다.
        // 또는 내부 클래스를 static 으로 선언하면 외부 클래스의 인스턴스를 참조하지 않기 때문에 아래와 같이 인스턴스화된 외부 클래스로 초기화할 필요가 없다.
        var comparator = new StoreEmployee().new StoreComparator<>();
        storeEmployees.sort(comparator);

        for (StoreEmployee storeEmployee : storeEmployees) {
            System.out.println(storeEmployee);
        }

        System.out.println("Pig Latin Names");
        addPigLatinName(storeEmployees);
    }

    public static void addPigLatinName(List<? extends StoreEmployee> list){

        String lastName = "Piggy";
        class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee>{

            private String pigLatinName;
            private Employee originalInstance;

            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName + " " + lastName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
                return originalInstance.toString() + " " + pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }

        List<DecoratedEmployee> newList = new ArrayList<>(list.size());

        for (Employee  employee : list) {
            String name = employee.getName();
            String pigLatin = name.substring(1) + name.charAt(0) + "ay";
            newList.add(new DecoratedEmployee(pigLatin, employee));
        }

        newList.sort(null);
        for (DecoratedEmployee employee : newList) {
            System.out.println(employee.originalInstance.getName() + " " + employee.pigLatinName);
        }
    }
}
