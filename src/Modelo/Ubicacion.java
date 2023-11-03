package Modelo;

public class Ubicacion {
    private String codigo;
    private String ciudad;
    private String barrio;
    private String departamento;
    private String descripcion;

    public Ubicacion() {
    }

    public Ubicacion(String codigo, String ciudad, String barrio, String departamento, String descripcion) {
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.barrio = barrio;
        this.departamento = departamento;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "codigo=" + codigo + ", ciudad=" + ciudad + ", barrio=" + barrio + ", departamento=" + departamento + ", descripcion=" + descripcion + '}';
    }

}
