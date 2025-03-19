package mycalendar.utilisateur;

import java.util.Objects;

public class MotDePasse {
    private String password;

    public MotDePasse(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MotDePasse that = (MotDePasse) o;
        return Objects.equals(password, that.password);
    }

}
