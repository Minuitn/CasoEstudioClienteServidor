package CasoEstudioFlotilla;

import java.time.LocalDate;

public class Mantenimiento {

    private int id;
    private int vehiculoid;
    private String tipo;
    private LocalDate fecha;
    private int kilometraje;

    public Mantenimiento() {
    }

    public Mantenimiento(int vehiculoid, String tipo, LocalDate fecha, int kilometraje) {
        this.vehiculoid = vehiculoid;
        this.tipo = tipo;
        this.fecha = fecha;
        this.kilometraje = kilometraje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVehiculoid() {
        return vehiculoid;
    }

    public void setVehiculoid(int vehiculoid) {
        this.vehiculoid = vehiculoid;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }

    @Override
    public String toString() {
        return "Mantenimiento: " + tipo + " (" + fecha + ") - km: " + kilometraje;
    }
}
