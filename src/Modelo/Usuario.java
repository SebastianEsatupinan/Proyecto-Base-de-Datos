package Modelo;
public class Usuario {

    private int id_usuario;
    private String nombre_completo;
    private String edad;
    private String estrato;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre_completo, String edad, String estrato) {
        this.id_usuario = id_usuario;
        this.nombre_completo = nombre_completo;
        this.edad = edad;
        this.estrato = estrato;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nombre_completo=" + nombre_completo + ", edad=" + edad + ", estrato=" + estrato + '}';
    }
}
