package chap6.polymorphism;

public class NextMain {
    public static void main(String[] args) {
        Movie movie = Movie.getMovie("Adventure", "Jaws");
        movie.watchMovie();

        // 기본적으로 getMovie 메서드는 Movie 타입을 반환하게 되고 컴파일 타임에는 타입에 따라 어떻게 바뀔지 알 수 없다.
//        Adventure jaws = (Adventure) Movie.getMovie("C", "Jaws");
//        jaws.watchMovie();

        Object comedy = Movie.getMovie("C", "Jaws");
        Comedy comedyMovie = (Comedy) comedy;
        comedyMovie.watchComedy();

        // 타입 추론
        var airplane = Movie.getMovie("A", "Airplane");
        airplane.watchMovie();

        var plane = new Comedy("Airplane");
        plane.watchComedy();

        // 타입 추론은 컴파일 타임에 타입이 결정되기 때문에 런타임에는 타입이 결정되어 있지 않다.

        System.out.println("==========================================");

        // 런타임에서 객체의 타입을 알아내는 방법
        Object unknownObject = Movie.getMovie("C", "Airplane");
        if(unknownObject.getClass().equals(Comedy.class)){
            Comedy c = (Comedy) unknownObject;
            c.watchComedy();
        }
        // instanceof 연산자를 사용하면 런타임에 타입을 알아낼 수 있다. (true, false 반환)
        else if (unknownObject instanceof Adventure){
             ((Adventure) unknownObject).watchAdventure();
        }
        // 패턴 매칭 (Java 14)
        // JVM이 컴파일 타임에 타입을 알아낼 수 있다면 아래와 같은 코드를 사용할 수 있다. (캐스팅 필요 없음)
        else if (unknownObject instanceof ScienceFiction sify) {
            sify.watchScienceFiction();
        } else {
            ((Movie) unknownObject).watchMovie();
        }
    }
}
