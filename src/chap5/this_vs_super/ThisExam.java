package chap5.this_vs_super;

public class ThisExam {
    // this : 자기 자신의 객체를 가리키는 참조 변수
    // super : 부모 객체를 가리키는 참조 변수
    // this() : 자기 자신의 생성자를 호출, 반드시 생성자의 첫 줄에서만 사용 가능, chaining에 주로 사용
    // super() : 부모의 생성자를 호출, 반드시 생성자의 첫 줄에서만 사용 가능, 만약 부모의 생성자를 호출하지 않으면 컴파일러가 자동으로 super()를 추가

    static class BadRectangle{
        private int x;
        private int y;
        private int width;
        private int height;

        public BadRectangle(int x, int y, int width, int height){
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public BadRectangle(int width, int height){
            this.x = 0;
            this.y = 0;
            this.width = width;
            this.height = height;
        }

        public BadRectangle(){
            this.x = 0;
            this.y = 0;
            this.width = 0;
            this.height = 0;
        }
    }

    static class GoodRectangle{
        private int x;
        private int y;
        private int width;
        private int height;

        public GoodRectangle(int x, int y, int width, int height){
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public GoodRectangle(int width, int height){
            this(0, 0, width, height);
        }

        public GoodRectangle(){
            this(0, 0);
        }
    }
}
