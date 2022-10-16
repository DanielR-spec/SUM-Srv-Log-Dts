package com.logic.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.NamingException;

import com.conexion.srv.LocalizadorServicios;
import com.data.services.ServiciosUsuarioRemote;
import com.data.user.Usuario;

/**
 * Session Bean implementation class ServiciosLogicaUsuario
 */
@Stateless
@LocalBean
public class ServiciosLogicaUsuario implements ServiciosLogicaUsuarioRemote, ServiciosLogicaUsuarioLocal {

	/**
	 * Default constructor.
	 */
	public ServiciosLogicaUsuario() {
		// TODO Auto-generated constructor stub
	}


	//METODO PARA VALIDAR USUARIO, RETORNA LA INFORMACION DEL USR SI EXISTE
	//FUNCIONA
	@Override
	public HashMap<String, String> getUser(String user, String pass) {

		// TODO Auto-generated method stub
		ServiciosUsuarioRemote fachadaDat = lczFachada();

		HashMap<String, String> usuarioRst = new HashMap<String, String>();

		List<Usuario> usuarioDt = fachadaDat.findUsuario(user, pass);

		if (usuarioDt.size() > 0) {
			for (Usuario usuario : usuarioDt) {
				
				usuarioRst.put("Id", String.valueOf(usuario.getIdUsuario()));
				usuarioRst.put("Nombre", usuario.getNombres());
				usuarioRst.put("Apellido", usuario.getApellidos());
				usuarioRst.put("UserName", usuario.getUsername());
				usuarioRst.put("Password", usuario.getPassword());

			}
			return usuarioRst;
		}

		return null;
	}
	
	//METODO PARA VALIDAR USUARIO POR ID, RETORNA LA INFORMACION DEL USR SI EXISTE
	//FUNCIONA
	@Override
	public HashMap<String, String> getUserById(String id) {

		// TODO Auto-generated method stub
		ServiciosUsuarioRemote fachadaDat = lczFachada();

		HashMap<String, String> usuarioRst = new HashMap<String, String>();

		List<Usuario> usuarioDt = fachadaDat.findUsuarioById(id);

		if (usuarioDt.size() > 0) {
			for (Usuario usuario : usuarioDt) {
				
				usuarioRst.put("Id", String.valueOf(usuario.getIdUsuario()));
				usuarioRst.put("Nombre", usuario.getNombres());
				usuarioRst.put("Apellido", usuario.getApellidos());
				usuarioRst.put("UserName", usuario.getUsername());
				usuarioRst.put("Password", usuario.getPassword());

			}
			return usuarioRst;
		}

		return null;
	}
	
	//METODO PARA AGREGAR USUARIO, RETORNA MSN DE CONFIRMACION SI SE AGREGO O NO
	//FUNCIONA
	@Override
	public String addUser( HashMap<String,String> user) {

		// TODO Auto-generated method stub
		ServiciosUsuarioRemote fachadaDat = lczFachada();


		Usuario tstUser = new Usuario();
		
	    // iterating through key/value mappings
	    System.out.print("Entries: ");
	    
	    for(Entry<String, String> entry: user.entrySet()) {
	    	switch (entry.getKey()) {
				case "nombres": {
					
					tstUser.setNombres(entry.getValue());
					break;
				}
				case "apellidos": {
					
					tstUser.setApellidos(entry.getValue());
					break;
				}
				case "usuario": {
					
					tstUser.setUsername(entry.getValue());
					break;
				}
				case "contrasena": {
					
					tstUser.setPassword(entry.getValue());
					break;
				}
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + entry.getKey());
				}
	    
	    }
	    
	    tstUser.setIdUsuario(getId());

		try {
	    	return fachadaDat.addUsuario(tstUser);
			
		} catch (Exception e) {
			// TODO: handle exception
	      	return "No se pudo agregar al usuario por el error:" + e;

		}
	}

	//METODO PARA ACTUALIZAR USUARIO, RETORNA MSN DE CONFIRMACION SI SE ACTUALIZO O NO
	//FUNCIONA
	@Override
	public String updUser( HashMap<String,String> user) {

		// TODO Auto-generated method stub
		ServiciosUsuarioRemote fachadaDat = lczFachada();


		Usuario tstUser = new Usuario();
		
	    // iterating through key/value mappings
	    System.out.print("Entries: ");
	    
	    for(Entry<String, String> entry: user.entrySet()) {
	    	switch (entry.getKey()) {
	    		case "id": {
	    			int id = Integer.parseInt(entry.getValue());
	    			tstUser.setIdUsuario(id);
					break;
	    		}
				case "nombres": {
					
					tstUser.setNombres(entry.getValue());
					break;
				}
				case "apellidos": {
					
					tstUser.setApellidos(entry.getValue());
					break;
				}
				case "usuario": {
					
					tstUser.setUsername(entry.getValue());
					break;
				}
				case "contrasena": {
					
					tstUser.setPassword(entry.getValue());
					break;
				}
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + entry.getKey());
				}
	    
	    }
	    
		try {
	    	return fachadaDat.updateUsuario(tstUser);
			
		} catch (Exception e) {
			// TODO: handle exception
	      	return "No se pudo actualizar al usuario por el error:" + e.getMessage();

		}
	}
	
	//METODO PARA ELIMINAR USUARIO, RETORNA MSN DE CONFIRMACION SI SE ELIMINO O NO
	//FUNCIONA
	@Override
	public String delUsr(HashMap<String,String> user) {

		// TODO Auto-generated method stub
		ServiciosUsuarioRemote fachadaDat = lczFachada();


		Usuario tstUser = new Usuario();
		
	    // iterating through key/value mappings
	    System.out.print("Entries: ");
	    
	    for(Entry<String, String> entry: user.entrySet()) {
	    	switch (entry.getKey()) {
	    		case "Id": {
	    			int id = Integer.parseInt(entry.getValue());
	    			tstUser.setIdUsuario(id);
					break;
	    		}
				case "Nombre": {
					
					tstUser.setNombres(entry.getValue());
					break;
				}
				case "Apellido": {
					
					tstUser.setApellidos(entry.getValue());
					break;
				}
				case "UserName": {
					
					tstUser.setUsername(entry.getValue());
					break;
				}
				case "Password": {
					
					tstUser.setPassword(entry.getValue());
					break;
				}
				
				default:
					throw new IllegalArgumentException("Unexpected value: " + entry.getKey());
				}
	    
	    }
	    
		try {
	    	return fachadaDat.delUsuario(tstUser);
			
		} catch (Exception e) {
			// TODO: handle exception
	      	return "No se pudo eliminar al usuario por el error:" + e.getMessage();

		}
	}
	
	
	//FUNCIONES AUXILIARES
	public int getId() {
		ServiciosUsuarioRemote fachadaDat = lczFachada();
		int id = fachadaDat.getId();
		
		return id;

	}
	
	public ServiciosUsuarioRemote lczFachada() {

		LocalizadorServicios Lcz = new LocalizadorServicios();
		ServiciosUsuarioRemote fachadaDato = null;

		try {
			fachadaDato = Lcz.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fachadaDato;

	}

	

}
