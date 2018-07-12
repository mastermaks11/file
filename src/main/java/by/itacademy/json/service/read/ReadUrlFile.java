package by.itacademy.json.service.read;

import by.itacademy.json.domain.Hospital;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.time.LocalDate;

/**
 * Created by user on 03.07.2018.
 */
@SuppressWarnings("ALL")
public class ReadUrlFile {
    private URL source;
    private Hospital hospital;

    public ReadUrlFile(Hospital hospital) {
        // this.source = source;
        this.hospital = hospital;
    }

    public void upload() throws IOException, ParseException {
          // URLConnection connection = source.openConnection();
           //InputStream inputStream = connection.getInputStream();
        Gson gson = new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateDecerealizer1())
                .registerTypeAdapter(boolean.class, new BooleanDeserializer1())
                .create();
        try (FileReader fileReader = new FileReader("hospital.json");) {
            System.out.println("чтение из " + gson.fromJson(fileReader, Hospital.class).getPatients().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
