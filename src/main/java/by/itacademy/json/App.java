package by.itacademy.json;

import by.itacademy.json.domain.Hospital;
import by.itacademy.json.domain.Patient;
import by.itacademy.json.domain.Secretary;
import by.itacademy.json.service.read.ReadUrlFile;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws IOException, ParseException {
        Hospital hospital = Hospital.builder()
                .add(Patient.builder()
                        .name("Denis")
                        .surname("Nikiforov")
                        .birth(1999, 12, 12)
                        .health(true)
                        .build())
                .add(Patient.builder()
                        .name("Vasya")
                        .surname("Pupkin")
                        .birth(1989, 04, 03)
                        .health(false)
                        .build())
                .build();

        Secretary secretary = new Secretary(hospital);
        secretary.localRead();
        ReadUrlFile readUrlFile = new ReadUrlFile(hospital);
        readUrlFile.upload();
        //secretary.remoteAdd();
        System.out.println(hospital);

    }
}
