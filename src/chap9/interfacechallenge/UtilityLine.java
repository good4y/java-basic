package chap9.interfacechallenge;

enum UtilityType{
    ELECTRICITY, FIBER_OPTIC, GAS, WATER
}
public class UtilityLine implements Mappable{
    private String name;
    private UtilityType type;

    public UtilityLine(String name, UtilityType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return name + " (" + type + ")";
    }

    @Override
    public String getMarker() {
        return switch (type){
            case ELECTRICITY -> Color.RED + " " + LineMarker.DASHED;
            case FIBER_OPTIC -> Color.ORANGE + " " + LineMarker.DOTTED;
            case GAS -> Color.GREEN + " " + LineMarker.SOLID;
            case WATER -> Color.BLUE + " " + LineMarker.SOLID;
            default -> Color.BLACK + " " + LineMarker.SOLID;
        };
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
               , "name": "%s", "type": "%s\"""".formatted(name, type);
    }
}
