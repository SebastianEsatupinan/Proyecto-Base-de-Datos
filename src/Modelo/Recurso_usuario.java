package Modelo;

import java.time.LocalDateTime;
import java.util.Date;

public class Recurso_usuario {

    private String codigo_rec_usu;
    private Date fecha_hora;
    private String comentario;

    public Recurso_usuario() {
    }

    public Recurso_usuario(String codigo_rec_usu, LocalDateTime fecha_hora, String comentario) {
        this.codigo_rec_usu = codigo_rec_usu;
        this.comentario = comentario;
    }


    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getCodigo_rec_usu() {
        return codigo_rec_usu;
    }

    public void setCodigo_rec_usu(String codigo_rec_usu) {
        this.codigo_rec_usu = codigo_rec_usu;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    @Override
    public String toString() {
        return "Recurso_usuario{" + "codigo_rec_usu=" + codigo_rec_usu + ", fecha_hora=" + fecha_hora + ", comentario=" + comentario + '}';
    }


    
}
