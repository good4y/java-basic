package chap10.challenge;

public class Park extends Point{

    private final String name;
    private final String type;

    public Park(String name, String type, Double latitude, Double longitude) {
        super(latitude, longitude);
        this.name = name;
        this.type = type;
    }

    @Override
    public void render() {
        System.out.println("Render " + name + " " + type + " as POINT ([" + getLocation()[0] + ", " + getLocation()[1] + "])");
    }
}
