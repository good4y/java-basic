package chap5.inheritance;

public class Animal {
    protected String type;
    private String size;
    private double weight;

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
        System.out.println(type + "이(가) 움직입니다 " + speed);
    }

    public void makeNoise() {
        System.out.println(type + "이(가) 소리를 냅니다.");
    }
}
