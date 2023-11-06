package Modelo;
import java.util.Date;

public class Recurso_educativo {
    
    private String codigo_rec_ed;
    private Date fecha_cargp;
    private String tipo_rec_ed;

    public Recurso_educativo() {
    }

    public Recurso_educativo(String codigo_rec_ed, Date fecha_cargp, String tipo_rec_ed) {
        this.codigo_rec_ed = codigo_rec_ed;
        this.fecha_cargp = fecha_cargp;
        this.tipo_rec_ed = tipo_rec_ed;
    }

    public String getCodigo_rec_ed() {
        return codigo_rec_ed;
    }

    public void setCodigo_rec_ed(String codigo_rec_ed) {
        this.codigo_rec_ed = codigo_rec_ed;
    }

    public Date getFecha_cargp() {
        return fecha_cargp;
    }

    public void setFecha_cargp(Date fecha_cargp) {
        this.fecha_cargp = fecha_cargp;
    }

    public String getTipo_rec_ed() {
        return tipo_rec_ed;
    }

    public void setTipo_rec_ed(String tipo_rec_ed) {
        this.tipo_rec_ed = tipo_rec_ed;
    }
    
    @Override
    public String toString() {
        return "Recurso_educativo{" + "codigo_rec_ed=" + codigo_rec_ed + ", fecha_cargp=" + fecha_cargp + ", tipo_rec_ed=" + tipo_rec_ed + '}';
    }  
}
