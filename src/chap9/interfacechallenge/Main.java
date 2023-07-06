package chap9.interfacechallenge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Mappable> mappables = new ArrayList<>();

        mappables.add(new Building("Building 1", UsageType.BUSINESS));
        mappables.add(new Building("Building 2", UsageType.ENTERTAINMENT));
        mappables.add(new Building("Building 3", UsageType.RESIDENTIAL));

        mappables.add(new UtilityLine("Utility Line 1", UtilityType.ELECTRICITY));
        mappables.add(new UtilityLine("Utility Line 2", UtilityType.GAS));
        mappables.add(new UtilityLine("Utility Line 3", UtilityType.WATER));

        for (Mappable mappable : mappables) {
            Mappable.maplt(mappable);
        }
    }
}
