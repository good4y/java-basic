package chap5.inheritance;

public class Fish extends Animal{

    private int gills;
    private int fins;

    public Fish(String type, double weight, int gills, int fins) {
        super(type, "소형", weight);
        this.gills = gills;
        this.fins = fins;
    }

    private void moveMuscles(){
        System.out.println("꼬리로 움직입니다 ");
    }

    private void moveBackFin(){
        System.out.println("등지느러미로 움직입니다 ");
    }

    @Override
    public void move(String speed) {
        super.move(speed);
        moveMuscles();
        if(speed == "빠르게"){
            moveBackFin();
        }
    }

    @Override
    public String toString() {
        return "Fish{" +
                "gills=" + gills +
                ", fins=" + fins +
                "} " + super.toString();
    }
}
