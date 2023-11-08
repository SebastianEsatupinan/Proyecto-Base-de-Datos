package Controlador;

import Modelo.Establecimiento;
import Modelo.Recurso_educativo;
import Modelo.Recurso_usuario;
import Modelo.Ubicacion;
import Modelo.Usuario;
import Vista.Recurso_Educativo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConexionBD {
    public Connection connection;
    
    public ConexionBD() {
        // Establece la conexión a la base de datos
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Prueba", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean insertarUsuario(Usuario usuario, Ubicacion ubicacion, Establecimiento establecimiento) {
        try {
            String queryUsuario = "INSERT INTO usuarios (id, nombre, edad, estrato) VALUES (?, ?, ?, ?)";
            String queryUbicacion = "INSERT INTO ubicacion (codigo, ciudad, barrio, departamento, descripcion) VALUES (?, ?, ?, ?, ?)";
            String queryEstablecimiento = "INSERT INTO establecimiento (nit, nombre, tipo) VALUES (?, ?, ?)";

            PreparedStatement statementUsuario = connection.prepareStatement(queryUsuario);
            statementUsuario.setString(1, usuario.getId_usuario());
            statementUsuario.setString(2, usuario.getNombre_completo());
            statementUsuario.setString(3, usuario.getEdad());
            statementUsuario.setString(4, usuario.getEstrato());
            statementUsuario.executeUpdate();
            
            PreparedStatement statementUbicacion = connection.prepareStatement(queryUbicacion);
            statementUbicacion.setString(1, ubicacion.getCodigo());
            statementUbicacion.setString(2, ubicacion.getCiudad());
            statementUbicacion.setString(3, ubicacion.getBarrio());
            statementUbicacion.setString(4, ubicacion.getDepartamento());
            statementUbicacion.setString(5, ubicacion.getDescripcion());
            statementUbicacion.executeUpdate();
            
            PreparedStatement statementEstablecimiento = connection.prepareStatement(queryEstablecimiento);
            statementEstablecimiento.setString(1, establecimiento.getNit());
            statementEstablecimiento.setString(2, establecimiento.getNombre_estab());
            statementEstablecimiento.setString(3, String.valueOf(establecimiento.getTipo_estab()));
            statementEstablecimiento.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean insertarRecurso(Recurso_usuario objRecurso) {
        try {
            String queryRecurso = "INSERT INTO recurso_usuario (codigo, fecha, comentario) VALUES (?, ?, ?)";

            PreparedStatement statementRecurso = connection.prepareStatement(queryRecurso);
            statementRecurso.setString(1, objRecurso.getCodigo_rec_usu()); // Usar el método getCodigo_rec_usu() de objRecurso
            statementRecurso.setTimestamp(2, Timestamp.valueOf(objRecurso.getFecha_hora())); // Usar el método getFecha_hora() de objRecurso
            statementRecurso.setString(3, objRecurso.getComentario()); // Usar el método getComentario() de objRecurso
            statementRecurso.executeUpdate();


            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean insertarRecursoEd(Recurso_educativo objRecursoEd) {
       try {
        String queryRecursoEd = "INSERT INTO recurso_educativo (codigo_rec_ed, fecha_cargp, tipo_rec_ed) VALUES (?, ?, ?)";
        
        PreparedStatement statementRecursoEd = connection.prepareStatement(queryRecursoEd);
        statementRecursoEd.setString(1, objRecursoEd.getCodigo_rec_ed()); // Usar el método getCodigo_rec_ed() de objRecursoEd
        statementRecursoEd.setTimestamp(2, Timestamp.valueOf(objRecursoEd.getFecha_cargp())); // Usar el método getFecha_cargp() de objRecursoEd
        statementRecursoEd.setString(3, objRecursoEd.getTipo_rec_ed()); // Usar el método getTipo_rec_ed() de objRecursoEd
        statementRecursoEd.executeUpdate();
        
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void cerrarConexion() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}