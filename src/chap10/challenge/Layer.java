package chap10.challenge;

import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable> {

    private final List<T> elements = new ArrayList<>();

    public void addElement(T element) {
        elements.add(element);
    }

    public void renderLayer() {
        for (T element : elements) {
            element.render();
        }
    }
}
