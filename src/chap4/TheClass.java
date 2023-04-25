package chap4;

public class TheClass {
    public static void main(String[] args) {
        // 객체
        // 클래스를 이용하여 객체로 실체화
        People people1 = new People();
        People people2 = new People();

        people2.setName("lee");
        People.toString("leeseoul");
    }


}
// 객체를 만들기 위한 설계도
// 사용자 지정 데이터 타입.
class People{
    String name;
    String address;
    // 인스턴스 메서드
    // 객체를 생성해야만 사용할 수 있다.
    public void setName(String name){
        this.name = name;
    }

    // 클래스 메서드
    public static void toString(String nameAndAddress){
        String name = nameAndAddress.substring(0, 3);
        String address = nameAndAddress.substring(3);
        System.out.println("name = " + name);
        System.out.println("address = " + address);
    }
}