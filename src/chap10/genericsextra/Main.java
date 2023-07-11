package chap10.genericsextra;

import chap10.genericsextra.model.LPAStudent;
import chap10.genericsextra.model.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            students.add(new Student());
        }
        students.add(new LPAStudent());
        printList(students);

        List<LPAStudent> lpaStudents = new ArrayList<>();
        for (int i = 0; i < studentCount; i++) {
            lpaStudents.add(new LPAStudent());
        }

        printList(lpaStudents);
    }

    // List의 매개변수 타입을 원시 타입으로 지정하여 List<Student>와 List<LPAStudent>를 모두 처리할 수 있다.
    public static void printList(List students){

        for (var student : students) {
            System.out.println(student);
        }
        System.out.println();
    }
}
