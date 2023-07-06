package chap9.abstractclass;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 추상 클래스는 인스턴스를 생성할 수 없다.
//        Animal animal = new Animal("animal", "big", 100);

        Dog dog = new Dog("Wolf", "big", 100);
        dog.makeNoise();
        doAnimalStuff(dog);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard", "big", 150));
        animals.add(new Fish("Goldfish", "small", 1));
        animals.add(new Fish("Barracuda", "big", 75));
        animals.add(new Dog("Pug", "small", 20));

        animals.add(new Horse("Clydesdale", "large", 1000));

        // 다형성 활용
        for (Animal animal : animals) {
            doAnimalStuff(animal);
            if(animal instanceof Mammal currentMammal){
                currentMammal.shedHair();
            }
        }

    }

    private static void doAnimalStuff(Animal animal){

        animal.makeNoise();
        animal.move("slow");

    }
}
