/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.UsuarioDAO;
import entities.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author giuli
 */
public class UsuarioUI {
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public Usuario getUsuario(String email, String contrasena) throws ClassNotFoundException, SQLException{
		Usuario user = new Usuario();
		user = usuarioDAO.getUsuario(email, contrasena);
		if (user == null)
			return null;
		
		return user;
	}
	
	public ArrayList<Usuario> getUsuarios() throws SQLException, ClassNotFoundException{
		ArrayList<Usuario> lstUsuarios = new ArrayList<Usuario>();
		//getUsuarios
                lstUsuarios = usuarioDAO.getUsuarios();                
		return lstUsuarios;
	}
}
