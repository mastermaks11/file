import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.ParseException;



/**
 * Created by user on 19.06.2018.
 */
public class Main {
    public static void main(String[] args) throws ParseException, IOException {
        DataInputStream filePatient = new DataInputStream(new  FileInputStream("patient.bin"));
        System.out.println(filePatient.readUTF() + " " + filePatient.readUTF() + " " + filePatient.readUTF() + " " + filePatient.readBoolean());
        System.out.println(filePatient.readUTF() + " " + filePatient.readUTF() + " " + filePatient.readUTF() + " " + filePatient.readBoolean());
        URL myFile = new URL("https://github.com/mastermaks11/file/blob/master/Hospital.txt");
        HttpURLConnection myUrlCon = (HttpURLConnection) myFile.openConnection();
        ReadableByteChannel rbc = Channels.newChannel(myFile.openStream());
        FileOutputStream fos = new FileOutputStream("newPatient.txt");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        AddPatient addPatient = new AddPatient();
        addPatient.addPatient();

    }

}
