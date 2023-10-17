import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidMovieException, InvalidHallException {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        List<Film> filmList = new ArrayList<>();

        Film film1 = new Film("Fight Club","David Fincher",false);
        Film film2 = new Film("Star Wars V","Irvin Kershner",true);
        Film film3 = new Film("Children of Men","Alfonso Cuaron",false);
        Film film4 = new Film("Mumie","Stephen Sommer",true);
        Film film6 = new Film("Star Wars V","Irvin Kershner",true);
        Film film7 = new Film("Children of Men","Alfonso Cuaron",false);
        Film film8 = new Film("Mumie","Stephen Sommer",true);



        filmList.add(film1);
        filmList.add(film2);
        filmList.add(film3);
        filmList.add(film4);
        filmList.add(film6);
        filmList.add(film7);
        filmList.add(film8);

        List<Hall> hallList = new ArrayList<>();
        Hall hall1 = new Hall(1, 10, 10, true);
        Hall hall2 = new Hall(2, 30, 15, true);
        Hall hall3 = new Hall(3, 10, 25, true);
        Hall hall4 = new Hall(4, 30, 15, false);

        for(int i = 0; i< filmList.size();i++){
            hall1.addFilm(filmList.get(random.nextInt(filmList.size())));
            hall2.addFilm(filmList.get(random.nextInt(filmList.size())));
        }

        hallList.add(hall1);
        hallList.add(hall2);
        hallList.add(hall3);
        hallList.add(hall4);

        try {
            System.out.println("Dostupné filmy: ");
            for (int i = 0; i < filmList.size(); i++) {
                System.out.println((i + 1) + " - " + filmList.get(i).getName());
            }
            System.out.println("Vyber si film: ");
            int choice = sc.nextInt();

            if (choice < 1 | choice > filmList.size()) {
                throw new InvalidMovieException("Neplatný film");
            }

            Film userFilm = filmList.get(choice - 1);

            System.out.println("Dostupne saly pro: " + userFilm.getName());
            List<Hall> hallForMovie = new ArrayList<>();
            for (Hall hall : hallList) {
                if (hall.getFilms().contains(userFilm)) {
                    System.out.println("Sál: " + hall.getHallNum());
                    hallForMovie.add(hall);
                }
            }

            System.out.println("vyber si sal: ");
            int hallChoice = sc.nextInt();

            Hall chosenHall = null;
            for (Hall hall : hallForMovie) {
                if (hall.getHallNum() == hallChoice) {
                    chosenHall = hall;
                    break;
                }
            }

            if (chosenHall == null) {
                throw new InvalidHallException("Neni sal");
            }
            chosenHall.seating();
            System.out.println("vyber křeslo: ");
            sc.nextLine();
            String seatChoice = sc.nextLine();

            System.out.println("film: " + userFilm.getName() + " sal: " + chosenHall.getHallNum() + " sedadlo: " + seatChoice);
        }catch (NumberFormatException e) {
            System.out.println("Chyba: Zadejte platné číslo pro výběr filmu.");
        } catch ( InvalidHallException | InvalidMovieException e) {
            System.out.println("Chyba: " + e.getMessage());
        }
} }

class InvalidMovieException extends Exception{
    public InvalidMovieException(String message){super(message);}
}

class InvalidHallException extends Exception{
    public InvalidHallException(String message){super(message);}}
