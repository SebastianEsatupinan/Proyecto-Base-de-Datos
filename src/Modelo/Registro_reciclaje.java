package Modelo;

import java.io.File;

public class Registro_reciclaje {
    
    private String codigo_regis;
    private char lugar_regis;
    private File imagen;
    private File grafico;
    private String retroalimentacion;
    private Material material;

    public Registro_reciclaje() {
    }

    public Registro_reciclaje(String codigo_regis, char lugar_regis, File imagen, File grafico, String retroalimentacion, Material material) {
        this.codigo_regis = codigo_regis;
        this.lugar_regis = lugar_regis;
        this.imagen = imagen;
        this.grafico = grafico;
        this.retroalimentacion = retroalimentacion;
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getCodigo_regis() {
        return codigo_regis;
    }

    public void setCodigo_regis(String codigo_regis) {
        this.codigo_regis = codigo_regis;
    }

    public char getLugar_regis() {
        return lugar_regis;
    }

    public void setLugar_regis(char lugar_regis) {
        this.lugar_regis = lugar_regis;
    }

    public File getImagen() {
        return imagen;
    }

    public void setImagen(File imagen) {
        this.imagen = imagen;
    }

    public File getGrafico() {
        return grafico;
    }

    public void setGrafico(File grafico) {
        this.grafico = grafico;
    }

    public String getRetroalimentacion() {
        return retroalimentacion;
    }

    public void setRetroalimentacion(String retroalimentacion) {
        this.retroalimentacion = retroalimentacion;
    }

    @Override
    public String toString() {
        return "Registro_reciclaje{" + "codigo_regis=" + codigo_regis + ", lugar_regis=" + lugar_regis + ", imagen=" + imagen + ", grafico=" + grafico + ", retroalimentacion=" + retroalimentacion + ", material=" + material + '}';
    }
    
   
}
