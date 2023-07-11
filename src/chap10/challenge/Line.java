package chap10.challenge;

public abstract class Line implements Mappable{

    private final double[][] location;

    public Line(double... location) {
        this.location = new double[location.length/2][2];
        for (int i = 0; i < location.length/2; i++) {
            this.location[i][0] = location[i];
            this.location[i][1] = location[i + 1];
        }
    }

    public double[][] getLocation() {
        return location;
    }
}
