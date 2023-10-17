import java.util.ArrayList;
import java.util.List;

public class Hall {
    private int hallNum;
    private int row;
    private int seats;
    private List<Film> films;
    private boolean supp3D;

    public int getHallNum() {
        return hallNum;
    }

    public void setHallNum(int hallNum) {
        this.hallNum = hallNum;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public boolean isSupp3D() {
        return supp3D;
    }

    public void setSupp3D(boolean supp3D) {
        this.supp3D = supp3D;
    }
    public void addFilm(Film film){
        films.add(film);
    }

    public Hall(int hallNum, int row, int seats, boolean supp3D) {
        this.hallNum = hallNum;
        this.row = row;
        this.seats = seats;
        this.supp3D = supp3D;
        this.films = new ArrayList<>();
    }

    public void seating(){
        System.out.println("Rozložení křesel salu: " + hallNum);
        for(int i = 1; i<=row;i++){
            for(int a =1; a<=seats;a++){
                char seatLett = (char) ('A' + a - 1);
                System.out.print(seatLett + String.format("%02d", row) + " ");            }
        }
        System.out.println();


    }

}
