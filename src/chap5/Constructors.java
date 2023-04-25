package chap5;

public class Constructors {
    //      생성자는 새로운 객체를 생성할 때 호출된다.
    //      자바는 생성자를 명시하지 않으면 컴파일러가 기본 생성자를 추가한다. (No argument constructor)
    //      다른 생성자가 하나라도 존재하면 컴파일러는 기본 생성자를 추가하지 않는다.

    private String number;
    private double balance;
    private String customerName;
    private String email;
    private String phone;

    public Constructors(){
        this("12345", 2.50, "Default name", "Default address", "Default phone");
        System.out.println("기본 생성자");
    }

    public Constructors(String number, double balance, String customerName, String email, String phone) {
        System.out.println("매개변수가 있는 생성자");
        this.number = number;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
    }

//    생성자 오버로딩
//    생성자는 매개 변수의 타입과 개수를 다르게 하여 여러 개를 정의할 수 있다.

//    생성자 체이닝
//    생성자는 다른 생성자를 호출할 수 있다.
//    this()를 사용하여 생성자를 호출한다.
//    생성자 체이닝은 생성자의 첫 번째 문장에서만 사용할 수 있다.
    public Constructors(String customerName, String email, String phone) {
        this("99999", 100.55, customerName, email, phone);
//        this.customerName = customerName;
//        this.email = email;
//        this.phone = phone;
    }

//    생성자를 정의할 때 this를 쓰지 않고 setter를 사용할 수도 있다.
//    하지만 일반적으로 생성자에서 setter이나 다른 메서드를 사용하지 않는데 이는 객체가 완전히 생성되지 않은 상태에서 다른 메서드를 호출할 수 있기 때문이다.

}
