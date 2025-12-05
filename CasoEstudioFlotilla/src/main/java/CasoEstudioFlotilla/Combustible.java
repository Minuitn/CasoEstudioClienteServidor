package CasoEstudioFlotilla;

import java.time.LocalDate;

public class Combustible {

    private int id;
    private int vehiculoid;
    private LocalDate fecha;
    private double litros;
    private double costo;

    public Combustible() {
    }

    public Combustible(int vehiculoid, LocalDate fecha, double litros, double costo) {
        this.vehiculoid = vehiculoid;
        this.fecha = fecha;
        this.litros = litros;
        this.costo = costo;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Combustible: " + litros + "L (" + fecha + ") - ₡" + costo;
    }
}
