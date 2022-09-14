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

	@Override
	public String test() {

		// TODO Auto-generated method stub
		LocalizadorServicios localizadorServicios = new LocalizadorServicios();
		ServiciosUsuarioRemote serviciosUsuarioRemote = null;
		try {
			serviciosUsuarioRemote = localizadorServicios.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Entro";
	}

	//METODO PARA VALIDAR USUARIO, RETORNA LA INFORMACION DEL USR SI EXISTE
	//FUNCIONA
	@Override
	public HashMap<String, String> getUser(String user, String pass) {

		// TODO Auto-generated method stub
		LocalizadorServicios localizadorServicios = new LocalizadorServicios();
		ServiciosUsuarioRemote serviciosUsuarioRemote = null;
		try {
			serviciosUsuarioRemote = localizadorServicios.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HashMap<String, String> usuarioRst = new HashMap<String, String>();

		List<Usuario> usuarioDt = serviciosUsuarioRemote.findUsuario(user, pass);

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

	//FUNCIONES AUXILIARES

	public int getId () {
		ServiciosUsuarioRemote fachadaDat = lczFachada();
		int id = fachadaDat.getId();

		return id+2;
		
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
