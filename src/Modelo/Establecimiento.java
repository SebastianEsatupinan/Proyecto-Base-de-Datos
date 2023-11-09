package Modelo;

public class Establecimiento {
    
    private String nit;
    private String nombre_estab;
    private String tipo_estab;
    private int CodUsu;

    public Establecimiento() {
    }

    public Establecimiento(String nit, String nombre_estab, String tipo_estab, int CodUsu) {
        this.nit = nit;
        this.nombre_estab = nombre_estab;
        this.tipo_estab = tipo_estab;
        this.CodUsu = CodUsu;
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

    public String getTipo_estab() {
        return tipo_estab;
    }

    public void setTipo_estab(String tipo_estab) {
        this.tipo_estab = tipo_estab;
    }

    public int getCodUsu() {
        return CodUsu;
    }

    public void setCodUsu(int CodUsu) {
        this.CodUsu = CodUsu;
    }

    @Override
    public String toString() {
        return "Establecimiento{" + "nit=" + nit + ", nombre_estab=" + nombre_estab + ", tipo_estab=" + tipo_estab + ", CodUsu=" + CodUsu + '}';
    }
 
    
}
