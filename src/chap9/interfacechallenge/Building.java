package chap9.interfacechallenge;

enum UsageType {
    BUSINESS, ENTERTAINMENT, RESIDENTIAL
}

public class Building implements Mappable {
    private String name;
    private UsageType usage;

    public Building(String name, UsageType usage) {
        this.name = name;
        this.usage = usage;
    }

    @Override
    public String getLabel() {
        return name + " (" + usage + ")";
    }

    @Override
    public String getMarker() {
        return switch (usage) {
            case ENTERTAINMENT -> Color.GREEN + " " + PointMarker.TRIANGLE;
            case BUSINESS -> Color.ORANGE + " " + PointMarker.STAR;
            case RESIDENTIAL -> Color.RED + " " + PointMarker.SQUARE;
            default -> Color.BLACK + " " + PointMarker.CIRCLE;
        };
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
               , "name": "%s", "usage": "%s\"""".formatted(name, usage);
    }
}
