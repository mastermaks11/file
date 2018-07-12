package by.itacademy.reflection.generator;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class App {
    public static final Logger LOGGER = Logger.getLogger(App.class.getName());

    static {
        try (InputStream in = App.class.getResourceAsStream("/log.properties");) {
            LogManager.getLogManager().readConfiguration(in);
        } catch (IOException e) {
            LOGGER.log(Level.INFO, e.getMessage());
        }
    }

    public static void main(String[] args) throws CustomInstantiationException {
        try {
            BeanFactory<Student> studentBeanFactory = new BeanFactory<>(by.itacademy.reflection.generator.Student.class);
            BeanFactory<Patient> patientBeanFactory = new BeanFactory<>(Patient.class);
            Student student = studentBeanFactory.createObject();
            by.itacademy.reflection.generator.Patient patient = patientBeanFactory.createObject();
            FieldGenerator<by.itacademy.reflection.generator.Student> fieldGenerator = new FieldGenerator<>(student);
            FieldGenerator<by.itacademy.reflection.generator.Patient> fieldGenerator1 = new FieldGenerator<>(patient);
            fieldGenerator.execute();
            fieldGenerator1.execute();
            System.out.println(student);
            System.out.println(patient);
        } catch (Exception e)

        {
            LOGGER.log(Level.INFO, e.getMessage());
        }
    }
}