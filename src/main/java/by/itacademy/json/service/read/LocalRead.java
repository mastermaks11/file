package by.itacademy.json.service.read;

import by.itacademy.json.domain.Hospital;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@SuppressWarnings("ALL")
public class LocalRead {
    public Hospital execute() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(LocalDate.class));
        module.addDeserializer(boolean.class, new BooleanDeserializer(Boolean.class));
        mapper.registerModule(module);
        Hospital hospital6 = mapper.readValue(new File("hospital.json"), Hospital.class);
        return hospital6;
    }
}
