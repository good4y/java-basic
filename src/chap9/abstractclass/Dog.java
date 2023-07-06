package chap9.abstractclass;

// 추상클래스를 상속받은 클래스는 추상클래스의 추상메소드를 반드시 구현해야 한다.
// 기본 생성자가 없는 추상클래스는 상속받은 클래스에서 반드시 추상클래스의 생성자를 호출해야 한다.
public class Dog extends Mammal{

    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if(speed.equals("slow")){
            System.out.println(getExplicitType() + " walking");
        } else{
            System.out.println(getExplicitType() + " running");
        }
    }

    @Override
    public void shedHair() {

        System.out.println(getExplicitType() + " shed hair all the time");
    }

    @Override
    public void makeNoise() {
        // type은 protected로 선언되어 있기 때문에 자식클래스에서 접근 가능하다.
        if (type == "Wolf"){
            System.out.print("Howling! ");
        }else{
            System.out.print("Woof! ");
        }
    }
}
