package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;  // Corregido el nombre de la clase ResultSet
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ClienteDao {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;  //  nombre de la clase ResultSet

    public boolean RegistrarCliente(Cliente cl) {
        String sql = "INSERT INTO clientes (dni, nombre, telefono, direccion, razon) VALUES (?,?,?,?,?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getDni());
            ps.setString(2, cl.getNombre());
            ps.setDouble(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.setString(5, cl.getRazon());
            ps.execute();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;

        } finally {
            try {
                con.close();
            } catch (Exception e2) {
                System.out.print(e2.toString());
            }
        }
    }

    public List<Cliente> ListarCliente() {
        List<Cliente> ListaCl = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt("id"));
                cl.setDni(rs.getInt("dni"));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getDouble("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                cl.setRazon(rs.getString("razon"));

                ListaCl.add(cl);
            }

        } catch (SQLException e) {
            System.out.print(e.toString());

        } finally {
            try {
                con.close();
            } catch (Exception e2) {
                System.out.print(e2.toString());
            }
        }

        return ListaCl;
        
  
    
        
    }
    
    public boolean EliminarCliente(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try {
            con = cn.getConnection();  // Añade esta línea para inicializar la conexión
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true; 
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public boolean ModificarCliente(Cliente cl) {
        String sql = "UPDATE clientes SET dni=?,nombre=?,telefono=?,direccion=?,razon=? WHERE id=?";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cl.getDni());
            ps.setString(2, cl.getNombre());
            ps.setDouble(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.setString(5, cl.getRazon());
            ps.setInt(6, cl.getId());  // El id debe ir en la posición 6

            ps.execute();
            return true;

        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;

        } finally {

            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}
    

 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

