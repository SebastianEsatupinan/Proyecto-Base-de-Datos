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
            String queryRecurso = "INSERT INTO recurso_usuario (codigo_Recurso, fecha, comentario, usuario_id) VALUES (?, ?, ?, ?)";

            PreparedStatement statementRecurso = connection.prepareStatement(queryRecurso);
            statementRecurso.setInt(1, objRecurso.getCodigo_rec_usu()); 
            statementRecurso.setTimestamp(2, Timestamp.valueOf(objRecurso.getFecha_hora())); 
            statementRecurso.setString(3, objRecurso.getComentario()); 
            statementRecurso.setInt(4, objRecurso.getIDUsuario());
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

                model.addRow(new Object[]{id, nombre, edad, estrato});

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
        //Ubicacion
    }

    public void mostrarUbicacionPorUsuario(int idUsuario, JTable jTable) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("codigo_ubi");
        model.addColumn("ciudad");
        model.addColumn("barrio");
        model.addColumn("departamento");
        model.addColumn("descripcion");

        try {
            String query = "SELECT * FROM ubicacion";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo_ubi");
                String ciudad = resultSet.getString("ciudad");
                String barrio = resultSet.getString("barrio");
                String departamento = resultSet.getString("departamento");
                String descripcion = resultSet.getString("descripcion");

                model.addRow(new Object[]{codigo, ciudad, barrio, departamento, descripcion});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jTable.setModel(model);
    }

    public void probar() {
        datosIngresados datos = new datosIngresados();
        // Crear una instancia de la clase ConexionBD
        ConexionBD conexion = new ConexionBD();

        // Obtener el modelo de datos de la tabla usuarios
        DefaultTableModel modeloUsuarios = conexion.obtenerDatosUsuarios();

        // Asignar el modelo a tu JTable
        datos.jTable1.setModel(modeloUsuarios);

        // Cerrar la conexión cuando ya no se necesite
        conexion.cerrarConexion();
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

    public boolean insertarRegistroReciclaje(Registro_reciclaje objRegistro, Material objMaterial) throws FileNotFoundException, IOException {
        FileInputStream fis = null;
        PreparedStatement psRegistro = null;
        PreparedStatement psMaterial = null;

        try {
            String sqlInsertRegistro = "INSERT INTO registro_reciclaje (codigo_regis, imagen, retroalimentacion, usuario_id) VALUES (?, ?, ?, ?)";
            psRegistro = connection.prepareStatement(sqlInsertRegistro);
            psRegistro.setInt(1, objRegistro.getCodigo_regis());
            psRegistro.setString(3, objRegistro.getRetroalimentacion());
            psRegistro.setInt(4, objRegistro.getCedulaUsu());

            if (!objRegistro.getImagen().equals("")) {
                File file = new File(objRegistro.getImagen());
                fis = new FileInputStream(file);
                psRegistro.setBinaryStream(2, fis, (int) file.length());
            } else {
                psRegistro.setNull(2, Types.BLOB);
            }

            psRegistro.executeUpdate();

            String sqlInsertMaterial = "INSERT INTO material (codigo_mate, nombre_mate, tipo_mate, cantidad, recomendaciones, codigo_regis) VALUES (?, ?, ?, ?, ?, ?)";
            psMaterial = connection.prepareStatement(sqlInsertMaterial);
            psMaterial.setInt(1, objMaterial.getCodigo_mate());
            psMaterial.setString(2, objMaterial.getNombre_mate());
            psMaterial.setString(3, objMaterial.getTipo_mate());
            psMaterial.setDouble(4, objMaterial.getCantidad());
            psMaterial.setString(5, objMaterial.getRecomendaciones());
            psMaterial.setInt(6, objRegistro.getCodigo_regis()); // Usar el código del registro reciclaje insertado anteriormente
            psMaterial.executeUpdate();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (psRegistro != null) {
                    psRegistro.close();
                }
                if (psMaterial != null) {
                    psMaterial.close();
                }
            } catch (IOException | SQLException ex) {
                ex.printStackTrace();
            }
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
