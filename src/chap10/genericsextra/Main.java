package chap10.genericsextra;

import chap10.genericsextra.model.LPAStudent;
import chap10.genericsextra.model.Student;
import chap10.genericsextra.util.QueryItem;
import chap10.genericsextra.util.QueryList;

import java.util.ArrayList;
import java.util.List;

record Employee(String name) implements QueryItem {

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        return false;
    }
}

public class Main {
    public static void main(String[] args) {

        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
        students.add(new LPAStudent());
//        printList(students);
        printMoreList(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }

        printMoreList(lpaStudents);
//        printList(lpaStudents);

        testList(new ArrayList<>(List.of("a", "b", "c")));
        testList(new ArrayList<>(List.of(1, 2, 3)));

        var queryList = new QueryList<>(lpaStudents);
        var matches = queryList.getMatches("Course", "Python");
        printMoreList(matches);

        // 아래와 같은 방식으로 타입을 지정할 수 있다.
//        var students2021 = QueryList.<Student>getMatches(new ArrayList<>(), "YearStarted", "2021");
//        printMoreList(students2021);

        var students2021 = QueryList.getMatches(students, "YearStarted", "2021");
        printMoreList(students2021);

//        QueryList<Employee> employeeQueryList = new QueryList<>();
    }

    // List의 매개변수 타입을 원시 타입으로 지정하여 List<Student>와 List<LPAStudent>를 모두 처리할 수 있다.
    // 하지만, List의 매개변수 타입이 원시 타입이기 때문에 object 타입의 메서드만 사용할 수 있다.
    // 따라서 제네릭 메소드를 사용하여 매개변수 타입을 지정해야 한다.
    // 제네릭 메서드에서 extend 키워드를 이용하면 상단 바운드를 지정할 수 있다.
    // Type Erasure : 컴파일러가 제네릭 타입을 제거하는 것을 의미한다. 컴파일러는 제네릭 타입을 컴파일할 때만 사용하고, 런타임에는 제네릭 타입이 존재하지 않는다.
    // 유형 삭제 시 컴파일러는 모든 제네릭 타입을 Object 또는 경계 타입으로 변환한다.
    public static void printMoreList(List<? extends Student> students) {

        for (var student : students) {
            System.out.println(student.getYearStarted() + ": " + student);
        }
        System.out.println();
    }

    public static void testList(List<?> list) {

        for (var element : list) {
            if (element instanceof String s) {
                System.out.println("String : " + s.toUpperCase());
            } else if (element instanceof Integer i) {
                System.out.println("Integer : " + i.floatValue());
            } else {
                System.out.println("Object : " + element);
            }
        }
    }

//    // List의 경우 상단 바인딩이 되지 않아, Type Erasure에 의해 Object 타입으로 변경되고 아래의 메서드는 시그니처가 같아 오버로딩이 불가능하다.
//    public static void testList(List<String> list){
//
//        for (var element : list){
//            System.out.println("String: " + element.toUpperCase());
//        }
//    }
//
//    public static void testList(List<Integer> list){
//
//        for (var element : list){
//            System.out.println("String: " + element.floatValue());
//        }
//    }

//    public static <T extends Student> void printList(List<T> students){
//
//        for (var student : students) {
//            System.out.println(student.getYearStarted() + ": " + student);
//        }
//        System.out.println();
//    }
}
