package chap10.challenge;

public abstract class Point implements Mappable{
    private final double[] location;

    public Point(Double latitude, Double longitude){
        this.location = new double[]{latitude, longitude};
    }

    public double[] getLocation() {
        return location;
    }
}
