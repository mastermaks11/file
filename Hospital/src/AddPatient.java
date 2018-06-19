import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by user on 19.06.2018.
 */
public class AddPatient {
    Patient patient;

    public AddPatient() {
    }
    void addPatient() throws ParseException {
        Scanner scan = new Scanner(System.in);
        String firstName = scan.next();
        String secondName = scan.next();
        System.out.println("Введите дату");
        String date = scan.next();
        boolean sick = scan.nextBoolean();
        Patient patient = new Patient(firstName, secondName, date, sick);
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("patient.bin",true)))
        {

            dos.writeUTF(patient.getFirstName());
            dos.writeUTF(patient.getSecondName());
            dos.writeUTF(patient.getDate());
            dos.writeBoolean(patient.isSick());
            System.out.println("Данные сохранены в файле");
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
