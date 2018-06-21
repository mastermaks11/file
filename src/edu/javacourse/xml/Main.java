package edu.javacourse.xml;

import edu.javacourse.xml.Hospital;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by user on 19.06.2018.
 */
public class Main {
    public static void main(String[] args) throws ParseException, IOException, SAXException, ParserConfigurationException {
        Hospital hospital = new Hospital();
        URL source = new URL("https://github.com/mastermaks11/file/blob/master/Hospital.txt");
        PatientsUpload patientsUpload = new PatientsUpload(source, hospital);
        patientsUpload.upload(hospital);
        Secretary secretary = new Secretary("patient.dat");
        Scanner scan = new Scanner(System.in);
        hospital.addPatient(new Patient("Petrov", "Вася", new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).parse(scan.next()), true));
        hospital.addPatient(new Patient("Ivanov", "Petr", new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).parse(scan.next()), false));


        try {
            secretary.write();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
