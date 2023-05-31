package chap5.inheritance;

public class AnimalMain {
    public static void main(String[] args) {
        doAnimalStuff(new Animal("동물", "중간", 10.0), "빠르게");

        doAnimalStuff(new Dog(), "느리게");

        doAnimalStuff(new Dog("요크셔테리어", 7.0), "빠르게");

        doAnimalStuff(new Dog("리트리버", 65.0, "접힌귀", "긴꼬리"), "느리게");

        doAnimalStuff(new Dog("늑대", 40.0), "느리게");

        doAnimalStuff(new Fish("구피", 0.5, 2, 3), "빠르게");
    }

    public static void doAnimalStuff(Animal animal, String speed) {
        animal.makeNoise();
        animal.move(speed);
        System.out.println(animal);
        System.out.println("-----------------");
    }
}
