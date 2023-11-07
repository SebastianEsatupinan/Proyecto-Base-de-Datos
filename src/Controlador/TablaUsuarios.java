/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TablaUsuarios {
    private final JTable jTable;
    private final DefaultTableModel model;

    public TablaUsuarios(JTable jTable) {
        this.jTable = jTable;
        this.model = (DefaultTableModel) jTable.getModel();
    }

    public void cargarDatosDesdeBaseDeDatos() {
        String url = "jdbc:mysql://localhost/Prueba";
        String usuario = "root";
        String contraseña = "root";

        try {
            Connection conn = DriverManager.getConnection(url, usuario, contraseña);
            String sql = "SELECT * FROM usuarios";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            model.setRowCount(0); // Borra los datos actuales de la tabla

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                int estrato = rs.getInt("estrato");
                model.addRow(new Object[]{id, nombre, edad, estrato});
            }
            
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}