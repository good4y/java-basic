package chap10.genericsextra.extrachallenge.util;

import chap10.genericsextra.extrachallenge.model.Student;

import java.util.ArrayList;
import java.util.List;

// 여러 개의 upper bound를 지정할 수 있다.
// <T extends AbstractClass & Interface1 & Interface2> 와 같이 사용할 수 있다.
// 항상 클래스를 먼저 지정해야 한다.
// 클래스는 최대 하나만 지정할 수 있지만, 인터페이스는 여러 개 지정할 수 있다.
public class QueryList <T extends Student & QueryItem> extends ArrayList<T>{
    public QueryList(List<T> items) {
        super(items);
    }

    public QueryList() {
    }

    // 제네릭 메소드의 T와 제네릭 클래스의 T는 다른 타입이다.
    public static <S extends QueryItem> List<S> getMatches(List<S> items, String field, String value){

        List<S> matches = new ArrayList<>();

        for (S item : items) {
            if (item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }

        return matches;
    }

    public QueryList<T> getMatches(String field, String value){

        QueryList<T> matches = new QueryList<>();

        for (T item : this) {
            if (item.matchFieldValue(field, value)){
                matches.add(item);
            }
        }

        return matches;
    }
}
