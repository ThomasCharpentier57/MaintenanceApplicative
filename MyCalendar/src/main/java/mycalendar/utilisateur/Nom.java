package mycalendar.utilisateur;

public class Nom {
    private String name;

    public Nom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
