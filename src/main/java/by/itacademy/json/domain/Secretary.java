package by.itacademy.json.domain;

import by.itacademy.json.service.read.LocalRead;
import by.itacademy.json.service.write.LocalWrite;

import java.io.IOException;

public class Secretary {
    private Hospital hospital;
    private LocalWrite localWrite = new LocalWrite();
    private LocalRead localRead = new LocalRead();

    public Secretary(Hospital hospital) {
        this.hospital = hospital;
    }

    public void localWrite() {
        localWrite.execute(hospital);
    }

    public void localRead() {
        try {
            hospital.addAll(localRead.execute().getPatients());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
