package mycalendar.event.reunion;

public class Lieu {
    private String lieu;

    public Lieu(String lieu) {
        this.lieu = lieu;
    }

    public String getLieu() {
        return lieu;
    }

    @Override
    public String toString() {
        return lieu;
    }
}
