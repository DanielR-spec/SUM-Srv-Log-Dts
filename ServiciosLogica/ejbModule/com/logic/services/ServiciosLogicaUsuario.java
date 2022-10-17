package com.logic.services;

import java.lang.System.Logger;
import java.util.ArrayList;
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

	// METODO PARA VALIDAR USUARIO, RETORNA LA INFORMACION DEL USR SI EXISTE
	// FUNCIONA
	@Override
	public HashMap<String, String> getUser(String correo, String clave) {

		// TODO Auto-generated method stub
		ServiciosUsuarioRemote fachadaDat = lczFachada();

		HashMap<String, String> usuarioRst = new HashMap<String, String>();

		List<Usuario> usuarioDt = fachadaDat.findUsuario(correo, clave);

		if (usuarioDt.size() > 0) {
			for (Usuario usuario : usuarioDt) {

				usuarioRst.put("Id", String.valueOf(usuario.getIdUsuario()));
				usuarioRst.put("Nombres", usuario.getNombres());
				usuarioRst.put("Apellidos", usuario.getApellidos());
				usuarioRst.put("Correo", usuario.getCorreo());
				usuarioRst.put("Clave", usuario.getClave());
				usuarioRst.put("Cell", usuario.getCell());
				usuarioRst.put("Doc", usuario.getDoc());
				usuarioRst.put("Direccion", usuario.getDireccion());

			}
			return usuarioRst;
		}

		return null;
	}

	// METODO PARA VALIDAR USUARIO POR ID, RETORNA LA INFORMACION DEL USR SI EXISTE
	// FUNCIONA
	@Override
	public HashMap<String, String> getUserById(String id) {

		// TODO Auto-generated method stub
		ServiciosUsuarioRemote fachadaDat = lczFachada();

		HashMap<String, String> usuarioRst = new HashMap<String, String>();

		List<Usuario> usuarioDt = fachadaDat.findUsuarioById(Integer.parseInt(id));

		if (usuarioDt.size() > 0) {
			for (Usuario usuario : usuarioDt) {

				usuarioRst.put("id", String.valueOf(usuario.getIdUsuario()));
				usuarioRst.put("nombres", usuario.getNombres());
				usuarioRst.put("apellidos", usuario.getApellidos());
				usuarioRst.put("correo", usuario.getCorreo());
				usuarioRst.put("clave", usuario.getClave());
				usuarioRst.put("cell", usuario.getCell());
				usuarioRst.put("doc", usuario.getDoc());
				usuarioRst.put("direccion", usuario.getDireccion());

			}
			return usuarioRst;
		}

		return null;
	}

	// METODO PARA AGREGAR USUARIO, RETORNA MSN DE CONFIRMACION SI SE AGREGO O NO
	// FUNCIONA
	@Override
	public String addUser(HashMap<String, String> user) {

		// TODO Auto-generated method stub
		ServiciosUsuarioRemote fachadaDat = lczFachada();

		Usuario tstUser = new Usuario();

		// iterating through key/value mappings
		System.out.print("Entries: ");

		for (Entry<String, String> entry : user.entrySet()) {
			switch (entry.getKey()) {
			case "nombres": {

				tstUser.setNombres(entry.getValue());
				break;
			}
			case "apellidos": {

				tstUser.setApellidos(entry.getValue());
				break;
			}
			case "correo": {

				tstUser.setCorreo(entry.getValue());
				break;
			}
			case "clave": {

				tstUser.setClave(entry.getValue());
				break;
			}
			case "cell": {

				tstUser.setCell(entry.getValue());
				break;
			}
			case "doc": {

				tstUser.setDoc(entry.getValue());
				break;
			}
			case "direccion": {

				tstUser.setDireccion(entry.getValue());
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

	// METODO PARA ACTUALIZAR USUARIO, RETORNA MSN DE CONFIRMACION SI SE ACTUALIZO O
	// NO
	// FUNCIONA
	@Override
	public String updUser(HashMap<String, String> user) {

		// TODO Auto-generated method stub
		ServiciosUsuarioRemote fachadaDat = lczFachada();

		Usuario tstUser = new Usuario();

		tstUser = formatUser(user);

		// iterating through key/value mappings
		System.out.print("Entries: ");

		try {
			return fachadaDat.updateUsuario(tstUser);

		} catch (Exception e) {
			// TODO: handle exception
			return "No se pudo actualizar al usuario por el error:" + e.getMessage();

		}
	}

	// METODO PARA ELIMINAR USUARIO, RETORNA MSN DE CONFIRMACION SI SE ELIMINO O NO
	// FUNCIONA
	@Override
	public String delUsr(HashMap<String, String> user) {

		// TODO Auto-generated method stub
		ServiciosUsuarioRemote fachadaDat = lczFachada();

		Usuario tstUser = new Usuario();

		// iterating through key/value mappings
		System.out.print("Entries: ");

		for (Entry<String, String> entry : user.entrySet()) {
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
			case "correo": {

				tstUser.setCorreo(entry.getValue());
				break;
			}
			case "clave": {

				tstUser.setClave(entry.getValue());
				break;
			}
			case "cell": {

				tstUser.setCell(entry.getValue());
				break;
			}
			case "doc": {

				tstUser.setDoc(entry.getValue());
				break;
			}
			case "direccion": {

				tstUser.setDireccion(entry.getValue());
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

	// FUNCIONES AUXILIARES
	public int getId() {
		ServiciosUsuarioRemote fachadaDat = lczFachada();
		int id = fachadaDat.getId();

		return id;

	}

	public Usuario formatUser(HashMap<String, String> user) {

		ServiciosUsuarioRemote fachadaDat = lczFachada();

		Usuario cliente = new Usuario();
		List<Usuario> auxUser = new ArrayList<Usuario>();

		cliente.setIdUsuario(getIdUser(user));

		auxUser = fachadaDat.findUsuarioById(cliente.getIdUsuario());

		if (auxUser == null) {
			System.out.println("Usuario no existe");
		} 
		else 
		{
			for (Usuario usuario : auxUser) {
				cliente.setNombres(usuario.getNombres());
				cliente.setApellidos(usuario.getApellidos());
				cliente.setCorreo(usuario.getCorreo());
				cliente.setClave(usuario.getClave());
				cliente.setCell(usuario.getCell());
				cliente.setDoc(usuario.getDoc());
				cliente.setDireccion(usuario.getDireccion());
			}
		}

		for (Entry<String, String> entry : user.entrySet()) {
			switch (entry.getKey()) {
			case "id": {

				break;

			}
			case "nombres": {
				if (entry.getValue() != "") {
					cliente.setNombres(entry.getValue());
					break;
				}
				break;

			}
			case "apellidos": {

				if (entry.getValue() != "") {
					cliente.setApellidos(entry.getValue());
					break;

				}
				break;

			}
			case "correo": {
				if (entry.getValue() != "") {
					cliente.setCorreo(entry.getValue());
					break;

				}
				break;
			}
			case "clave": {
				if (entry.getValue() != "") {
					cliente.setClave(entry.getValue());
					break;

				}
				break;
			}
			case "cell": {
				if (entry.getValue() != "") {
					cliente.setCell(entry.getValue());
					break;
				}
				break;
			}
			case "doc": {
				if (entry.getValue() != "") {
					cliente.setDoc(entry.getValue());
					break;
				}
				break;
			}
			case "direccion": {
				if (entry.getValue() != "") {
					cliente.setDireccion(entry.getValue());
					break;
				}
				break;
			}

			default:
				throw new IllegalArgumentException("Unexpected value: " + entry.getKey());
			}

		}

		return cliente;

	}

	public int getIdUser(HashMap<String, String> user) {

		int id = 0;
		for (Entry<String, String> entry : user.entrySet()) {
			if (entry.getKey().equals("id")) {
				id = Integer.parseInt(entry.getValue());
			}

		}

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
