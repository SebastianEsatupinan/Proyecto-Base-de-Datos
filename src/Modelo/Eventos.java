package Modelo;

import java.util.Date;

public class Eventos {
    
    private String codigo_even;
    private Date fecha;
    private String nombre_even;
    private Ubicacion lugar;

    public Eventos() {
    }

    public Eventos(String codigo_even, Date fecha, String nombre_even, Ubicacion lugar) {
        this.codigo_even = codigo_even;
        this.fecha = fecha;
        this.nombre_even = nombre_even;
        this.lugar = lugar;
    }

    public Ubicacion getLugar() {
        return lugar;
    }

    public void setLugar(Ubicacion lugar) {
        this.lugar = lugar;
    }

    public String getCodigo_even() {
        return codigo_even;
    }

    public void setCodigo_even(String codigo_even) {
        this.codigo_even = codigo_even;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre_even() {
        return nombre_even;
    }

    public void setNombre_even(String nombre_even) {
        this.nombre_even = nombre_even;
    }

    @Override
    public String toString() {
        return "Eventos{" + "codigo_even=" + codigo_even + ", fecha=" + fecha + ", nombre_even=" + nombre_even + ", lugar=" + lugar + '}';
    }
}
