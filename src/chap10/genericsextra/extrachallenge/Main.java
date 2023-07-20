package chap10.genericsextra.extrachallenge;

import chap10.genericsextra.extrachallenge.model.LPAStudent;
import chap10.genericsextra.extrachallenge.model.StudentComparator;
import chap10.genericsextra.extrachallenge.util.QueryList;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        QueryList<LPAStudent> queryList = new QueryList<>();

        for (int i = 0; i < 25; i++) {
            queryList.add(new LPAStudent());
        }

        System.out.println("Ordered");
        queryList.sort(Comparator.naturalOrder());
        printList(queryList);

        System.out.println("Matches");
        QueryList<LPAStudent> matches = queryList.getMatches("PercentComplete", "50") // 50% 미만
                .getMatches("Course", "Python"); // Python 수강생

        matches.sort(new StudentComparator()); // 진행률 순으로 정렬
        printList(matches);

        System.out.println("Ordered");
        matches.sort(null);
        printList(matches); // id 순으로 정렬
    }
    
    public static void printList(List<?> students){

        for (Object student : students) {
            System.out.println(student);
        }
    }
}
