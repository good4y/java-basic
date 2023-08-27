public class Main {

    enum Status{
        MAIN(1, "메인"), EXTRA(2, "추가");

        private int order;
        private String script;

        Status(int order, String script) {
            this.order = order;
            this.script = script;
        }
    }
    public static void main(String[] args) {

    }
}