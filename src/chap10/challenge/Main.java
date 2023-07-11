package chap10.challenge;

public class Main {
    public static void main(String[] args) {
        River river = new River("Amazon", "River", -3.118908, -60.021731, -2.984733, -60.025909, -2.984733, -60.025909, -2.984733, -60.025909);

        river.render();

        Park park = new Park("Ibirapuera", "Park", -23.587807, -46.657832);
        park.render();

        Layer<River> riverLayer = new Layer<>();
        riverLayer.addElement(river);
        riverLayer.renderLayer();
    }
}
