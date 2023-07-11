package chap10.genericsextra.model;

public class LPAStudent extends Student{

    private double percentComplete;

    public LPAStudent() {
        this.percentComplete = 100 * random.nextDouble();
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(), percentComplete);
    }

    public double getPercentComplete() {
        return percentComplete;
    }
}
