package chap10.challenge;

public class River extends Line{
    private final String name;
    private final String type;

    public River(String name, String type, double... location) {
        super(location);
        this.name = name;
        this.type = type;
    }

    @Override
    public void render() {
        System.out.print("Render " + name + " " + type + " as LINE ([");
        for (double[] doubles : getLocation()) {
            System.out.print("[" + doubles[0] + ", " + doubles[1] + "], ");
        }
        System.out.println("])");
    }
}
