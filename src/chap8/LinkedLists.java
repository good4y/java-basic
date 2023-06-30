package chap8;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedLists {

    public static void main(String[] args) {
//        LinkedList<String> list = new LinkedList<>();
        var placesToVisit = new LinkedList<String>();

        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra");
        System.out.println(placesToVisit);

        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);

//        removeElements(placesToVisit);
//        System.out.println(placesToVisit);

//        gettingElements(placesToVisit);

        printItinerary(placesToVisit);
        printItinerary2(placesToVisit);
        printItinerary3(placesToVisit);

        testIterator(placesToVisit);
    }

    private static void addMoreElements(LinkedList<String> list) {

        list.addFirst("Darwin");
        list.addLast("Hobart");

        // linkedList는 queue의 구현체이기 때문에 queue의 메서드를 사용할 수 있다.
        list.offer("Melbourne");
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");

        // stack의 구현체이기 때문에 stack의 메서드를 사용할 수 있다.
        list.push("Alice Springs");
    }

    private static void removeElements(LinkedList<String> list){

        list.remove(4);
        list.remove("Brisbane");

        System.out.println(list);
        String s1 = list.remove();
        System.out.println(s1 + " was removed");

        String s2 = list.remove();
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast();
        System.out.println(s3 + " was removed");

        // Queue/Deque poll() : 큐의 첫번째 요소를 반환하고 제거한다.
        String p1 = list.poll();
        System.out.println(p1 + " was removed");

        String p2 = list.pollFirst();
        System.out.println(p2 + " was removed");

        String p3 = list.pollLast();
        System.out.println(p3 + " was removed");

        list.push("Sydney");
        list.push("Brisbane");
        list.push("Canberra");
        System.out.println(list);

        // Stack pop() : 스택의 첫번째 요소를 반환하고 제거한다.
        String p4 = list.pop();
        System.out.println(p4 + " was removed");
    }

    private static void gettingElements(LinkedList<String> list){

        // linkedlist의 get 메서드는 index를 받아 해당 index의 요소를 반환한다.
        // 전체 길이의 반을 넘어가는 index를 입력하면, 뒤에서부터 index를 계산한다.
        System.out.println("Retrieved Fifth Element = " + list.get(4));

        System.out.println("First Element = " + list.getFirst());
        System.out.println("Last Element = " + list.getLast());

        // indexOf() : 해당 요소의 index를 반환한다.
        System.out.println("Darwin is at position: " + list.indexOf("Darwin"));
        System.out.println("Melbourne is at position: " + list.indexOf("Melbourne"));

        // Queue element() : 큐의 첫번째 요소를 반환한다.
        System.out.println("Element from element() = " + list.element());

        // stack peek() : 스택의 첫번째 요소를 반환한다.
        System.out.println("Element from peek() = " + list.peek());
        System.out.println("Element from peekFirst() = " + list.peekFirst());
        System.out.println("Element from peekLast() = " + list.peekLast());
    }

    public static void printItinerary(LinkedList<String> list){
        System.out.println("Trip starts at " + list.getFirst());
        for (int i = 1; i < list.size(); i++) {
            System.out.println("--> From: " + list.get(i - 1) + " to " + list.get(i));
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItinerary2(LinkedList<String> list){
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();
        for (String town : list) {
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    public static void printItinerary3(LinkedList<String> list){
        System.out.println("Trip starts at " + list.getFirst());
        String previousTown = list.getFirst();

        // listIterator() : list의 iterator를 반환한다.
        // listIterator(int index) : index부터 시작하는 iterator를 반환한다.
        ListIterator<String> iterator = list.listIterator(1);
        while(iterator.hasNext()){
            var town = iterator.next();
            System.out.println("--> From: " + previousTown + " to " + town);
            previousTown = town;
        }
        System.out.println("Trip ends at " + list.getLast());
    }

    private static void testIterator(LinkedList<String> list){

        // iterator() : list의 iterator를 반환한다.
        // iterator란, list의 요소를 순회하며 접근할 수 있는 객체이다.
        // iterator의 커서는 list의 요소들 사이에 위치한다.
        ListIterator<String> iterator = list.listIterator();
        while(iterator.hasNext()){
//            System.out.println("iterator : " + iterator.next());

            // iterator를 이용하여 remove를 수행하면 list와 다르게 ConcurrentModificationException이 발생하지 않는다.
            // 왜냐하면, iterator는 list의 요소를 순회하며 접근하는 객체이기 때문에, list의 요소를 직접적으로 수정하지 않기 때문이다.
            if(iterator.next().equals("Brisbane")){
                iterator.add("Lake Wivenhoe");
            }
        }

        while (iterator.hasPrevious()){
            System.out.println("previous : " + iterator.previous());
        }
        System.out.println(list);

       ListIterator<String> iterator2 = list.listIterator(3);
        // cursor 위치는 3번째 인덱스 요소의 뒤에 위치한다.
        System.out.println("move cursor to forward : " + iterator2.next());
        // cursor 위치는 4번째 인덱스 요소의 뒤에 위치한다.
        System.out.println("move cursor to backward : " + iterator2.previous());
        // cursor 위치는 3번째 인덱스 요소의 뒤에 위치한다.
    }
}
