package by.itacademy.json.domain;

import java.time.LocalDate;
import java.util.Objects;

@SuppressWarnings("ALL")
public class Patient {
    private String name;
    private String surname;

    private LocalDate birth;
    private boolean health;

    public Patient() {
    }

    public Patient(String name, String surname, LocalDate birth, boolean health) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return health == patient.health && Objects.equals(name, patient.name) && Objects.equals(surname, patient.surname) && Objects.equals(birth, patient.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birth, health);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public boolean isHealth() {
        return health;
    }

    public static PatientBuilder builder() {
        return new PatientBuilder();
    }

    public static class PatientBuilder {
        private Patient patient = new Patient();

        public PatientBuilder name(String name) {
            patient.name = name;
            return this;
        }

        public PatientBuilder surname(String surname) {
            patient.surname = surname;
            return this;
        }

        public PatientBuilder birth(LocalDate birth) {
            patient.birth = birth;
            return this;
        }

        public PatientBuilder birth(int year, int month, int days) {
            patient.birth = LocalDate.of(year, month, days);
            return this;
        }

        public PatientBuilder health(Boolean health) {
            patient.health = health;
            return this;
        }

        public Patient build() {
            return patient;
        }
    }

    @Override
    public String toString() {
        return "Patient{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", birth=" + birth + ", health=" + health + '}';
    }
}
