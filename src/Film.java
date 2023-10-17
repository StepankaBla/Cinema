public class Film {
    private String name;
    private String director;
    private boolean is3D;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public boolean isIs3D() {
        return is3D;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }

    public Film(String name, String director, boolean is3D) {
        this.name = name;
        this.director = director;
        this.is3D = is3D;
    }
}
