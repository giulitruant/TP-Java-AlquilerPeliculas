/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import entities.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author giuli
 */
public class UsuarioDAO extends Conexion{
    Connection conn = null;
    
    public void addUsuario(Usuario user) throws SQLException{	
	conn = this.getConnection();
	       PreparedStatement st = conn.prepareStatement("insert into usuario values(?, ?, ?)");
               
               st.setInt(1, Integer.valueOf(user.getIdUsuario()));
               st.setString(2, user.getEmail());
               st.setString(3, user.getContrasena());
               
               st.executeUpdate();
               
               st.close();
               conn.close();
    }
	
	public int deleteUsuario(int idUsuario) throws ClassNotFoundException, SQLException{	
		
		conn = this.getConnection();
		PreparedStatement stmt = conn.prepareStatement("delete from usuario where idUsuario = ? ");
		stmt.setInt(1, Integer.valueOf(idUsuario));		
		int rta = stmt.executeUpdate();		
		return rta;
		
	}
	
	public int editUsuario(Usuario user) throws ClassNotFoundException, SQLException{
		
		conn = this.getConnection();
		PreparedStatement stmt = conn.prepareStatement("update usuario set email = ?, contrasena = ?" +
				" where idUsuario = ?");
		stmt.setString(1, user.getEmail());
		stmt.setString(2, user.getContrasena());
		stmt.setInt(3, Integer.valueOf(user.getIdUsuario()));				
		int rta = stmt.executeUpdate();
		
		stmt.close();
		conn.close();

		return rta;	
		}
	
	public Usuario getUsuario(String email,String contrasena) throws ClassNotFoundException, SQLException{		
		Usuario user = new Usuario();		
		conn = this.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from usuario where email = ? and contrasena=?");
		stmt.setString(1, email);
		stmt.setString(2, contrasena);		
		          ResultSet rs = stmt.executeQuery();		
		while(rs.next()){
			user.setIdUsuario(rs.getInt("idUsuario"));
			user.setEmail(rs.getString("email"));
			user.setContrasena(rs.getString("contrasena"));
		}
		
		rs.close();
		conn.close();
		return user;
		
	}
	
	public ArrayList<Usuario> getUsuarios() throws SQLException, ClassNotFoundException{
		          ArrayList<Usuario> lstUsuarios = new ArrayList<Usuario>();
		
		conn = this.getConnection();
		PreparedStatement stmt = conn.prepareStatement("select * from usuario");		
		ResultSet rs = stmt.executeQuery();		
		while(rs.next()){
			Usuario user = new Usuario();
			
			user.setIdUsuario(rs.getInt("idUsuario"));
			user.setEmail(rs.getString("email"));
			user.setContrasena(rs.getString("contrasena"));
			
			lstUsuarios.add(user);
		}
		
		rs.close();
		conn.close();
		
		return lstUsuarios;
	}
    
}
