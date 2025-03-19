package mycalendar.event.periodique;

public class FrequenceJour {
    private int frequenceJours;
    public FrequenceJour(int frequenceJours) {
        this.frequenceJours = frequenceJours;
    }

    public int get() {
        return frequenceJours;
    }

    @Override
    public String toString() {
        return frequenceJours + " jours";
    }
}
