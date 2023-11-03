package Modelo;
public class Usuario {

    private String id_usuario;
    private String nombre_completo;
    private String edad;
    private String estrato;
    private Ubicacion ubicacion;
    private Establecimiento Estab;

    public Usuario() {
    }

    public Usuario(String id_usuario, String nombre_completo, String edad, String estrato, Ubicacion ubicacion, Establecimiento Estab) {
        this.id_usuario = id_usuario;
        this.nombre_completo = nombre_completo;
        this.edad = edad;
        this.estrato = estrato;
        this.ubicacion = ubicacion;
        this.Estab = Estab;
    }

    public Establecimiento getEstab() {
        return Estab;
    }

    public void setEstab(Establecimiento Estab) {
        this.Estab = Estab;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
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

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nombre_completo=" + nombre_completo + ", edad=" + edad + ", estrato=" + estrato + ", ubicacion=" + ubicacion + ", Estab=" + Estab + '}';
    }
}
