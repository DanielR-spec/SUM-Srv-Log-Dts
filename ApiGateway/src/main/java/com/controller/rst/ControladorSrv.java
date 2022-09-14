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

	public Usuario validateUser(String usr, String pss) {

		ServiciosLogicaUsuarioRemote fachadaLog = lczFachada();

		HashMap<String, String> usuario = fachadaLog.getUser(usr, pss);

		Usuario usrRest = new Usuario();

		for (Entry<String, String> entry : usuario.entrySet()) {

			switch (entry.getKey()) {
			case "Id":
				usrRest.setId(Integer.valueOf(entry.getValue()));
				break;

			case "Nombre":
				usrRest.setName(entry.getValue());
				break;

			case "Apellido":
				usrRest.setSecondName(entry.getValue());
				break;

			case "UserName":
				usrRest.setUserName(entry.getValue());
				break;

			case "Password":
				usrRest.setPassword(entry.getValue());
				break;

			default:

				// Print statement corresponding case
				throw new IllegalArgumentException("Unexpected value: " + entry.getKey());

			}

		}

		Integer id = usrRest.getId();
		if (id != null) {

			usrRest.setIsValid(true);

		}
		return usrRest;

	}

	public String addUser(String name, String lName, String usr, String pss) {

		ServiciosLogicaUsuarioRemote fachadaLog = lczFachada();
		
		HashMap<String, String> user = new HashMap<String, String>();
		
		user.put("nombres", name);
		user.put("apellidos", lName);
		user.put("usuario", usr);
		user.put("contrasena", pss);
		
		String res = fachadaLog.addUser(user);
		
		return res;

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
