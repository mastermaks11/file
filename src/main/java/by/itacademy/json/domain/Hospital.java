package by.itacademy.json.domain;

import java.util.HashSet;
import java.util.Set;

public class Hospital {
    private Set<Patient> patients = new HashSet<>();

    public void add(Patient patient) {
        patients.remove(patient);
        patients.add(patient);
    }

    public void addAll(Set<Patient> patients) {
        this.patients.removeAll(patients);
        this.patients.addAll(patients);
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public static HospitalBuilder builder() {
        return new HospitalBuilder();
    }

    public static class HospitalBuilder {
        private Hospital hospital = new Hospital();

        public HospitalBuilder add(Patient patient) {
            hospital.add(patient);
            return this;
        }

        public Hospital build() {
            return hospital;
        }
    }

    @Override
    public String toString() {
        return "Hospital {" + "patients=" + patients + '}';
    }
}
