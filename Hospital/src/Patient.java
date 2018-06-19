import java.io.Serializable;
import java.util.Date;

/**
 * Created by user on 19.06.2018.
 */
public class Patient implements Serializable {
    String FirstName;
    String SecondName;
    String date;
    boolean sick;

    public Patient(String firstName, String secondName, String date, boolean sick) {
        FirstName = firstName;
        SecondName = secondName;
        this.date = date;
        this.sick = sick;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public String getDate() {
        return date;
    }

    public boolean isSick() {
        return sick;
    }
}
