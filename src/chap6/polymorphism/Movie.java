package chap6.polymorphism;

public class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void watchMovie(){
        String instanceType = this.getClass().getSimpleName();
        System.out.println(title + " is a " + instanceType + " film");
    }

    // 디자인 패턴 - 심플 팩토리 패턴
    // 타입 명을 직접 줘서 분기문을 통해 객체를 생성하고 있는데 아직 개방 폐쇄 원칙을 만족하지 못했다. (새로운 장르가 들어온다면 분기문을 수정해야 한다.)
    public  static Movie getMovie(String type, String title){
        return switch (type.toUpperCase().charAt(0)){
            case 'A' -> new Adventure(title);
            case 'C' -> new Comedy(title);
            case 'S' -> new ScienceFiction(title);
            default -> new Movie(title);
        };
    }
}

class Adventure extends Movie{
    public Adventure(String title){
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s\n".repeat(3),
                "Pleasant Scene",
                "Scary Music",
                "Something Bad Happens");
    }

    public void watchAdventure(){
        System.out.println("Watching an adventure movie");
    }
}

class Comedy extends Movie{
    public Comedy(String title){
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s\n".repeat(3),
                "Something funny happens",
                "Scary Music",
                "happy ending");
    }

    public void watchComedy(){
        System.out.println("Watching an comedy movie");
    }
}

class ScienceFiction extends Movie{
    public ScienceFiction(String title){
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        System.out.printf(".. %s\n".repeat(3),
                "Bad Aliens do Bad Stuff",
                "Space Guys Chase Aliens",
                "Happy Ending");
    }

    public void watchScienceFiction(){
        System.out.println("Watching an Sci-fi movie");
    }
}