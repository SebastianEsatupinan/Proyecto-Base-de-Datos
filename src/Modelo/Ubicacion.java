package Modelo;

public class Ubicacion {
    private int codigo;
    private String ciudad;
    private String barrio;
    private String departamento;
    private String descripcion;
    private int codeUsu;

    public Ubicacion() {
    }

    public Ubicacion(int codigo, String ciudad, String barrio, String departamento, String descripcion, int codeUsu) {
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.barrio = barrio;
        this.departamento = departamento;
        this.descripcion = descripcion;
        this.codeUsu = codeUsu;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodeUsu() {
        return codeUsu;
    }

    public void setCodeUsu(int codeUsu) {
        this.codeUsu = codeUsu;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "codigo=" + codigo + ", ciudad=" + ciudad + ", barrio=" + barrio + ", departamento=" + departamento + ", descripcion=" + descripcion + ", codeUsu=" + codeUsu + '}';
    }

   
}
