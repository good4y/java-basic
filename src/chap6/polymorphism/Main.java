package chap6.polymorphism;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Movie theMovie = Movie.getMovie("Adventure", "Star wars");
        theMovie.watchMovie();

        Movie theAdventure = new Comedy("Lala");
        theAdventure.watchMovie();

        Scanner s = new Scanner(System.in);
        while (true){
            System.out.println("Enter Type : ");
            String type = s.nextLine();

            if("Qq".contains(type)){
                break;
            }

            System.out.println("Enter Title : ");
            String title = s.nextLine();
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();
        }
    }
}
