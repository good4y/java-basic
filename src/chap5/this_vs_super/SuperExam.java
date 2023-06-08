package chap5.this_vs_super;

public class SuperExam {
    static class Shape{
        private int x;
        private int y;

        public Shape(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class Rectangle extends Shape{
        private int width;
        private int height;

        public Rectangle(int x, int y){
            this(x, y, 0, 0);
        }

        public Rectangle(int x, int y, int width, int height){
            super(x, y);
            this.width = width;
            this.height = height;
        }
    }
}
