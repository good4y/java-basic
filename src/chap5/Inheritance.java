package chap5;

public class Inheritance {

    public static void main(String[] args) {
        Animal animal = new Animal("동물", "중간", 10.0);
        doAnumalStuff(animal, "빠르게");

        Dog dog = new Dog();
        doAnumalStuff(dog, "느리게");
    }

    public static void doAnumalStuff(Animal animal, String speed) {
        animal.move(speed);
        animal.makeNoise();
        System.out.println(animal);
        System.out.println("-----------------");
    }

}

class Animal {
    private String type;
    private String size;
    private double weight;

    public Animal() {
    }

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", weight=" + weight +
                '}';
    }

    public void move(String speed) {
        System.out.println(type + "이 " + speed + " 움직입니다.");
    }

    public void makeNoise() {
        System.out.println(type + "이 소리를 냅니다.");
    }
}

class Dog extends Animal {
    public Dog() {
        super();
    }

//        super()는 부모 클래스의 생성자를 호출한다.
//        super()는 반드시 생성자의 첫 번째 문장으로 와야 한다.
//        super()를 호출하지 않으면 컴파일러가 자동으로 super()를 호출한다.
//        만약 부모 클래스에서 기본 생성자가 없다면, super()를 호출하는 생성자를 명시적으로 작성해야 한다.
}