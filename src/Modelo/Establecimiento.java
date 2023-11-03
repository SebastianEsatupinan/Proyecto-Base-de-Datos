package Modelo;

public class Establecimiento {
    
    private String nit;
    private String nombre_estab;
    private char tipo_estab;

    public Establecimiento() {
    }
 
    public Establecimiento(String nit, String nombre_estab, char tipo_estab) {
        this.nit = nit;
        this.nombre_estab = nombre_estab;
        this.tipo_estab = tipo_estab;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre_estab() {
        return nombre_estab;
    }

    public void setNombre_estab(String nombre_estab) {
        this.nombre_estab = nombre_estab;
    }

    public char getTipo_estab() {
        return tipo_estab;
    }

    public void setTipo_estab(char tipo_estab) {
        this.tipo_estab = tipo_estab;
    }
    
    @Override
    public String toString() {
        return "Establecimiento{" + "nit=" + nit + ", nombre_estab=" + nombre_estab + ", tipo_estab=" + tipo_estab + '}';
    }

    
}
