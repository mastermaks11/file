package edu.javacourse.xml;

import edu.javacourse.xml.Hospital;
import edu.javacourse.xml.Patient;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Created by user on 19.06.2018.
 */
public class PatientsUpload {
    private URL source;
    private Hospital hospital;

    public PatientsUpload(URL source, Hospital hospital) {
        this.source = source;
        this.hospital = hospital;
    }

    public void upload(Hospital hospital) throws IOException {
        URL source1 = new URL("https://github.com/mastermaks11/file/blob/master/PatientCatalog.xml");
        URLConnection connection = source1.openConnection();
        InputStream inputStream = connection.getInputStream();
        final String fileName = "PatientCatalog.xml";
        try {
            XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(fileName, new FileInputStream(fileName));

            while (xmlr.hasNext()) {
                xmlr.next();
                if (xmlr.isStartElement()) {
                } else if (xmlr.isEndElement()) {
                } else if (xmlr.hasText() && xmlr.getText().trim().length() > 0) {
                    System.out.println("   " + xmlr.getText());
                }
            }
        } catch (FileNotFoundException | XMLStreamException ex) {
            ex.printStackTrace();
        }


    }
}