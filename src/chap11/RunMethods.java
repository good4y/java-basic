package chap11;

import chap11.domain.Employee;
import chap11.domain.EmployeeComparator;
import chap11.domain.StoreEmployee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {

    public static void main(String[] args) {

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Meg", 2019, "Target"),
                new StoreEmployee(10515, "Joe", 2021, "Walmart"),
                new StoreEmployee(10105, "Tom", 2020, "Macys"),
                new StoreEmployee(10215, "Marty", 2018, "Walmart"),
                new StoreEmployee(10322, "Bud", 2016, "Target")
        ));

        EmployeeComparator<StoreEmployee> c0 = new EmployeeComparator<>();
        Employee.EmployeeComparator<StoreEmployee> c1 = new Employee.EmployeeComparator<>();
        StoreEmployee.StoreComparator<StoreEmployee> c2 = new StoreEmployee().new StoreComparator<>();

        // local class
        class NameSort<T> implements  Comparator<StoreEmployee>{

            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }

        NameSort<StoreEmployee> c3 = new NameSort<>();

        // Using annoymous class
        // 표현식이기 때문에 세미콜론으로 끝난다.
        var c4 = new Comparator<StoreEmployee>(){
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        sortIt(storeEmployees, c0); // 이름순
        sortIt(storeEmployees, c1); // 입사연도순
        sortIt(storeEmployees, c2); // 매장이름순, 이름이 같으면 연도순
        sortIt(storeEmployees, c3); // 지역 클래스를 이용한 sorting
        sortIt(storeEmployees, c4); // 익명 클래스를 이용한 sorting
        sortIt(storeEmployees, (o1, o2) -> o1.getName().compareTo(o2.getName())); // 람다 표현식을 이용한 sorting

    }

    public static <T> void sortIt(List<T> list, Comparator<? super T> comparator) {

        System.out.println("Sorting with Comparator: " + comparator.toString());
        list.sort(comparator);
        for (T employee : list) {
            System.out.println(employee);
        }
    }
}
