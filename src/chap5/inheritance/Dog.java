package chap5.inheritance;

public class Dog extends Animal{

    private String earShape;
    private String tailShape;

    // super()
    // 부모 클래스의 생성자를 호출한다.
    // super()는 반드시 생성자의 첫 번째 문장으로 와야 한다.
    // 만약 부모 클래스에 기본 생성자가 없다면 자식 클래스에서 명시적으로 super()를 호출해야 한다.
    // super()를 호출하지 않으면 컴파일러가 자동으로 super()를 추가한다.
    public Dog(){
        super("개", "소형", 7.0);
    }

    public Dog(String type, double weight){
        this(type, weight, "뾰족귀", "말린꼬리");
    }

    public Dog(String type, double weight, String earShape, String tailShape) {
        // 항상 super()가 먼저 와야 하기 때문에 내부에서 삼항연산자를 이용해 조건문을 이용할 수 있다.
        super(type, weight < 15 ? "소형" : (weight < 35 ? "중형" : "대형"), weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString();
    }

    // override 어노테이션이 없어도 좌측 코드라인에 파란색 오버라이드 아이콘이 생긴다.
    public void makeNoise(){
        if(type == "늑대"){
            System.out.println("아우우우우우");
        }
        bark();
        System.out.println();
    }

    @Override
    public void move(String speed) {
        super.move(speed);
        if (speed.equals("느리게")) {
            walk();
            wag();
        } else {
            run();
            bark();
        }
    }

    private void bark(){
        System.out.println("멍멍");
    }

    private void walk(){
        System.out.println("개가 걷습니다.");
    }

    private void wag() {
        System.out.println("개가 꼬리를 흔듭니다.");
    }

    private void run(){
        System.out.println("개가 달립니다.");
    }
}
