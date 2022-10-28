/**
 * 
 */
package com.controller.rst;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.naming.NamingException;

//import com.data.user.Usuario;
import com.logic.services.ServiciosLogicaUsuarioRemote;
import com.conexion.rst.LocalizadorServicios;
import com.rest.ws.Usuario;

/**
 * @author danie
 *
 */
public class ControladorSrv {

	/**
	 * 
	 */
	public ControladorSrv() {
		// TODO Auto-generated constructor stub
	}
	
//FUNCIONES PRINCIPALES

	public Usuario validateUser(String correo, String clave) {

		ServiciosLogicaUsuarioRemote fachadaLog = lczFachada();

		HashMap<String, String> usuario = fachadaLog.getUser(correo, clave);

		Usuario usrRest = new Usuario();

		if (usuario != null) {
			for (Entry<String, String> entry : usuario.entrySet()) {
	
				switch (entry.getKey()) {
				case "Id":
					usrRest.setId(Integer.parseInt(entry.getValue()));
					break;
	
				case "Nombres":
					usrRest.setNombres(entry.getValue());
					break;
	
				case "Apellidos":
					usrRest.setApellidos(entry.getValue());
					break;
	
				case "Correo":
					usrRest.setCorreo(entry.getValue());
					break;
	
				case "Clave":
					usrRest.setClave(entry.getValue());
					break;
				case "Cell":
					usrRest.setCell(entry.getValue());
					break;
				case "Doc":
					usrRest.setDoc(entry.getValue());
					break;
				case "Direccion":
					usrRest.setDireccion(entry.getValue());
					break;
	
				default:
	
					// Print statement corresponding case
					throw new IllegalArgumentException("Unexpected value: " + entry.getKey());
	
				}
			}
		}

		Integer id = usrRest.getId();
		if (id != null) {

			usrRest.setValid(true);
			return usrRest;

		}
		
		return null;

	}

	public String addUser(String nombres,
			String apellidos,
			String correo,
			String clave,
			String cell,
			String doc,
			String direccion,
			String tipo) {

		ServiciosLogicaUsuarioRemote fachadaLog = lczFachada();
		
		HashMap<String, String> user = new HashMap<String, String>();
		
		user.put("nombres", nombres);
		user.put("apellidos", apellidos);
		user.put("correo", correo);
		user.put("clave", clave);
		user.put("cell", cell);
		user.put("doc", doc);
		user.put("direccion", direccion);
		user.put("tipo", tipo);
		
		String res = fachadaLog.addUser(user);
		
		return res;

	}

	public String updUser(String id, 
			String nombres,
			String apellidos,
			String correo,
			String clave,
			String cell,
			String doc,
			String direccion) {

		ServiciosLogicaUsuarioRemote fachadaLog = lczFachada();
		
		HashMap<String, String> user = new HashMap<String, String>();
		
		user.put("id", id);
		user.put("nombres", nombres);
		user.put("apellidos", apellidos);
		user.put("correo", correo);
		user.put("clave", clave);
		user.put("cell", cell);
		user.put("doc", doc);
		user.put("direccion", direccion);
		
		String res = fachadaLog.updUser(user);
		
		return res;

	}

	public String delUser(String id) {

		ServiciosLogicaUsuarioRemote fachadaLog = lczFachada();

		if (fachadaLog.getUserById(id) != null) {
			String res = fachadaLog.delUsr(fachadaLog.getUserById(id));
			if (res != null) {

				return res;

			}
		}

		return "No funciono";

	}

//FUNCIONES AUXILIARES
	public ServiciosLogicaUsuarioRemote lczFachada() {

		LocalizadorServicios Lcz = new LocalizadorServicios();
		ServiciosLogicaUsuarioRemote fachadaLogica = null;

		try {
			fachadaLogica = Lcz.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fachadaLogica;

	}
}
