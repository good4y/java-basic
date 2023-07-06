package chap9.abstractclass;

public class Horse extends Mammal{

    public Horse(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void shedHair() {
        System.out.println(getExplicitType() + " shedding hair");
    }

    @Override
    public void makeNoise() {

    }
}
