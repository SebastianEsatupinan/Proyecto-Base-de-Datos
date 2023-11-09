package Modelo;

import java.io.File;

public class Registro_reciclaje {
    
    private int codigo_regis;
    private String imagen;
    private String retroalimentacion;
    private int CedulaUsu;

    public Registro_reciclaje() {
    }

    public Registro_reciclaje(int codigo_regis, String imagen, String retroalimentacion, int CedulaUsu) {
        this.codigo_regis = codigo_regis;
        this.imagen = imagen;
        this.retroalimentacion = retroalimentacion;
        this.CedulaUsu = CedulaUsu;
    }

    public int getCodigo_regis() {
        return codigo_regis;
    }

    public void setCodigo_regis(int codigo_regis) {
        this.codigo_regis = codigo_regis;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getRetroalimentacion() {
        return retroalimentacion;
    }

    public void setRetroalimentacion(String retroalimentacion) {
        this.retroalimentacion = retroalimentacion;
    }

    public int getCedulaUsu() {
        return CedulaUsu;
    }

    public void setCedulaUsu(int CedulaUsu) {
        this.CedulaUsu = CedulaUsu;
    }

    @Override
    public String toString() {
        return "Registro_reciclaje{" + "codigo_regis=" + codigo_regis + ", imagen=" + imagen + ", retroalimentacion=" + retroalimentacion + ", CedulaUsu=" + CedulaUsu + '}';
    }
   
}
