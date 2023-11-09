package Modelo;

public class Material {
    
    private int codigo_mate;
    private String nombre_mate;
    private String tipo_mate;
    private double cantidad;
    private String recomendaciones;
    private int codRegis;
    
    public Material() {
       
    }

    public Material(int codigo_mate, String nombre_mate, String tipo_mate, double cantidad, String recomendaciones, int codRegis) {
        this.codigo_mate = codigo_mate;
        this.nombre_mate = nombre_mate;
        this.tipo_mate = tipo_mate;
        this.cantidad = cantidad;
        this.recomendaciones = recomendaciones;
        this.codRegis = codRegis;
    }

    public int getCodigo_mate() {
        return codigo_mate;
    }

    public void setCodigo_mate(int codigo_mate) {
        this.codigo_mate = codigo_mate;
    }

    public String getNombre_mate() {
        return nombre_mate;
    }

    public void setNombre_mate(String nombre_mate) {
        this.nombre_mate = nombre_mate;
    }

    public String getTipo_mate() {
        return tipo_mate;
    }

    public void setTipo_mate(String tipo_mate) {
        this.tipo_mate = tipo_mate;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public int getCodRegis() {
        return codRegis;
    }

    public void setCodRegis(int codRegis) {
        this.codRegis = codRegis;
    }

    @Override
    public String toString() {
        return "Material{" + "codigo_mate=" + codigo_mate + ", nombre_mate=" + nombre_mate + ", tipo_mate=" + tipo_mate + ", cantidad=" + cantidad + ", recomendaciones=" + recomendaciones + ", codRegis=" + codRegis + '}';
    }

    
    
    
}
