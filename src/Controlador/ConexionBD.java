package Controlador;

import Modelo.Establecimiento;
import Modelo.Material;
import Modelo.Recurso_educativo;
import Modelo.Recurso_usuario;
import Modelo.Registro_reciclaje;
import Modelo.Ubicacion;
import Modelo.Usuario;
import Vista.Recurso_Educativo;
import Vista.datosIngresados;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            
            String queryUsuario = "INSERT INTO usuarios (id_usuario, nombre_usuario, edad, estrato) VALUES (?, ?, ?, ?)";
            PreparedStatement statementUsuario = connection.prepareStatement(queryUsuario);
            statementUsuario.setInt(1, usuario.getId_usuario());
            statementUsuario.setString(2, usuario.getNombre_completo());
            statementUsuario.setString(3, usuario.getEdad());
            statementUsuario.setString(4, usuario.getEstrato());
            statementUsuario.executeUpdate();
            
            String queryUbicacion = "INSERT INTO ubicacion (codigo_ubi, ciudad, barrio, departamento, descripcion, codigoU) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statementUbicacion = connection.prepareStatement(queryUbicacion);
            statementUbicacion.setInt(1, ubicacion.getCodigo());
            statementUbicacion.setString(2, ubicacion.getCiudad());
            statementUbicacion.setString(3, ubicacion.getBarrio());
            statementUbicacion.setString(4, ubicacion.getDepartamento());
            statementUbicacion.setString(5, ubicacion.getDescripcion());
            statementUbicacion.setInt(6, ubicacion.getCodeUsu());
            statementUbicacion.executeUpdate();

            
            String queryEstablecimiento = "INSERT INTO establecimiento (nit, nombre_estab, tipo, id_usuario) VALUES (?, ?, ? ,?)";
            PreparedStatement statementEstablecimiento = connection.prepareStatement(queryEstablecimiento);
            statementEstablecimiento.setString(1, establecimiento.getNit());
            statementEstablecimiento.setString(2, establecimiento.getNombre_estab());
            statementEstablecimiento.setString(3, String.valueOf(establecimiento.getTipo_estab()));
            statementEstablecimiento.setInt(4, establecimiento.getCodUsu());
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
    
    public DefaultTableModel obtenerDatosUsuarios() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id_usuario");
        model.addColumn("nombre_usuario");
        model.addColumn("edad");
        model.addColumn("estrato");
        

        try {
            String query = "SELECT * FROM usuarios";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("id_usuario");
                String nombre = resultSet.getString("nombre_usuario");
                String edad = resultSet.getString("edad");
                String estrato = resultSet.getString("estrato");
                
             

                model.addRow(new Object[] {id, nombre, edad, estrato});
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
        //Ubicacion
    }
    public DefaultTableModel obtenerDatosUbicacion() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("codigo");
    model.addColumn("ciudad");
    model.addColumn("barrio");
    model.addColumn("departamento");
    model.addColumn("descripcion");

    try {
        String query = "SELECT * FROM ubicacion";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            String codigo = resultSet.getString("codigo_ubi");
            String ciudad = resultSet.getString("ciudad");
            String barrio = resultSet.getString("barrio");
            String departamento = resultSet.getString("departamento");
            String descripcion = resultSet.getString("descripcion");

            model.addRow(new Object[] {codigo, ciudad, barrio, departamento, descripcion});
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return model;
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
    
    public boolean insertarRegistroReciclaje(Registro_reciclaje objRegistro, Material objMaterial) throws FileNotFoundException, IOException{
        FileInputStream fis = null;
        PreparedStatement ps = null;

        try {
            String sqlInsert = "INSERT INTO registro_reciclaje (codigo_regis, imagen, retroalimentacion, usuario_id) VALUES (?, ?, ?, ?)";
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sqlInsert);
            ps.setInt(1, objRegistro.getCodigo_regis());
            ps.setString(3, objRegistro.getRetroalimentacion());
            ps.setInt(4, objRegistro.getCedulaUsu());
            
           if (!objRegistro.getImagen().equals("")) {
                File file = new File(objRegistro.getImagen());
                fis = new FileInputStream(file);
                ps.setBinaryStream(2, fis, (int) file.length());
                ps.executeUpdate();
                ps.close();
                fis.close();
            } else {
                ps.setNull(2, java.sql.Types.BLOB);
                ps.executeUpdate();
                ps.close();
            }
           
            String queryMaterial = "INSERT INTO material (codigo_mate, nombre_mate, tipo_mate, cantidad, recomendaciones, codigo_regis) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statementMaterial = connection.prepareStatement(queryMaterial);
            statementMaterial.setInt(1, objMaterial.getCodigo_mate());
            statementMaterial.setString(2, objMaterial.getNombre_mate());
            statementMaterial.setString(3, objMaterial.getTipo_mate());
            statementMaterial.setDouble(4, objMaterial.getCantidad());
            statementMaterial.setString(5, objMaterial.getRecomendaciones());
            statementMaterial.setInt(6, objMaterial.getCodRegis());
            statementMaterial.executeUpdate();

            ps.executeUpdate();
            connection.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (IOException | SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        return false;
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