package by.itacademy.reflection.generator;

import java.time.LocalDate;

@SuppressWarnings("ALL")
public class Patient {
    @Generate
    private LocalDate date;
    @Generate
    private boolean healthy;

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public LocalDate getDate() {

        return date;
    }

    public boolean isHealthy() {
        return healthy;
    }

    @Override
    public String toString() {
        return "Patient{" + "date=" + date + ", healthy=" + healthy + '}';
    }
}
