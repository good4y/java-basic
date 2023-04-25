package chap5;

public class ThePojo {
//    POJO (Plain Old Java Object)
//    오직 인스턴스 필드로만 이루어진 클래스
//    자바 빈이라고도 불린다
//    엔티티 라고도 불리는데 데이터베이스의 엔티티를 미러링 할 때 사용되기도 하기 때문이다.
//    다른 말로는 데이터 전송 객체 (DTO)라고도 불린다.
//    오직 데이터를 저장하기 위한 목적으로 사용되기 때문에 메서드를 가지지 않는다.

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            PojoRecord s = new PojoRecord("S92300" + i,
                    switch (i) {
                        case 1 -> "홍길동";
                        case 2 -> "김길동";
                        case 3 -> "박길동";
                        case 4 -> "이길동";
                        case 5 -> "최길동";
                        default -> "이름 없음";
                    },
                    "05/11/1999",
                    "Java class");
            System.out.println(s);
        }

        PojoRecord s = new PojoRecord("S923001", "홍길동", "05/11/1999", "Java class");
        PojoStudent student = new PojoStudent("S923001", "홍길동", "05/11/1999", "Java class");

        System.out.println();
        System.out.println(s);
        System.out.println(student);

        System.out.println(s.name());
        System.out.println(student.getName());
    }
}

