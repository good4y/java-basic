package chap8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoreLists {
    public static void main(String[] args) {
        String[] items = {"apples", "bananas", "milk", "eggs"};

        // List.of() 메소드는 불변 리스트를 생성한다. (Immutable collection)
        List<String> list = List.of(items);
        System.out.println(list);

        System.out.println(list.getClass().getName());
//        // list.of 를 사용하여 생성한 리스트는 ImmutableCollections 클래스로 만들어지기 때문에 add메서드가 없다.
//        list.add("yogurt");

        // ArrayList는 가변 리스트이다.
        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println(groceries);

        ArrayList<String> nextList = new ArrayList<>(List.of("pickles", "mustard", "cheese"));
        System.out.println(nextList);

        // addAll 메서드를 사용하여 리스트를 합칠 수 있다.
        groceries.addAll(nextList);
        System.out.println(groceries);

        // get 메서드를 사용하여 리스트의 요소를 가져올 수 있다.
        System.out.println("Third item = " + groceries.get(2));

        // contains 메서드는 indexof 메서드를 사용하여 리스트에 특정 요소가 있는지 확인할 수 있다.
        if (groceries.contains("pickles")) {
            System.out.println("We have pickles");
        }

        // indexOf 메서드는 리스트에서 특정 요소의 인덱스를 찾는다.
        // lastIndexOf 메서드는 리스트에서 특정 요소의 마지막 인덱스를 찾는다.
        groceries.add("yogurt");
        System.out.println("first = " + groceries.indexOf("yogurt"));
        System.out.println("last = " + groceries.lastIndexOf("yogurt"));

        // remove 메서드는 리스트에서 특정 요소를 제거한다.
        // remove 메서드는 인덱스를 받을 수도 있고, 요소를 받을 수도 있다.
        // remove 메서드는 내부 코드에서 label을 이용하고 있다.
        System.out.println(groceries);
        groceries.remove(1);
        System.out.println(groceries);
        groceries.remove("yogurt");
        System.out.println(groceries);

        // removeall 메서드는 리스트에서 특정 요소들을 제거한다.
        groceries.removeAll(List.of("apples", "eggs"));
        System.out.println(groceries);

        // retainAll 메서드는 리스트에서 특정 요소들을 제외한 나머지 요소들을 제거한다.
        groceries.retainAll(List.of("apples", "milk", "mustard", "cheese"));
        System.out.println(groceries);

        // clear 메서드는 리스트를 비운다.
        // isEmpty 메서드는 size가 0이면 true를 반환한다.
        groceries.clear();
        System.out.println(groceries);
        System.out.println("isEmpty = " + groceries.isEmpty());

        // List.of 메서드는 불변 리스트를 생성하고, Arrays.asList 메서드는 크기를 늘릴 수 없지만, 요소를 변경할 수 있는 리스트를 생성한다.
        // 따라서 thread safe 한 리스트를 만들기 위해 List.of 메서드를 사용하는 것을 권장한다.
        groceries.addAll(List.of("apples", "milk", "mustard", "cheese"));
        groceries.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham"));

        // Sort 메서드는 리스트를 정렬한다.
        // Comparator를 사용하여 정렬 방법을 지정할 수 있다.
        System.out.println(groceries);
        groceries.sort(Comparator.naturalOrder());
        System.out.println(groceries);

        groceries.sort(Comparator.reverseOrder());
        System.out.println(groceries);

        // toArray 메서드는 리스트를 배열로 변환한다.
        var groceryArray = groceries.toArray(new String[groceries.size()]);
        System.out.println("copied array : " + Arrays.toString(groceryArray));
    }
}
