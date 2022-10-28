package com.conexion;

import java.util.List;

import javax.naming.NamingException;

import com.data.services.ServiciosUsuarioRemote;
import com.logic.services.ServiciosLogicaUsuarioRemote;
import com.model.ent.Usuario;

public class Cliente {

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public static void main () {
		/* BUSCAR LOGICA
		Lcz localizadorServicios = new Lcz();
		ServiciosLogicaUsuarioRemote fachadaLogica = null;
		try {
			fachadaLogica = localizadorServicios.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Invocar el servicio usando la referencia remota
		//System.out.println(fachadaLogica.addUser());
		List<Usuario> lista = fachadaLogica.getUsers();
		
		for (Usuario user: lista) {
			System.out.print(user.getNombres());
		}*/
		
		LczDt localizadorServicios = new LczDt();
		ServiciosUsuarioRemote fachadaLogica = null;
		try {
			fachadaLogica = localizadorServicios.getRemoteFachadaData();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Invocar el servicio usando la referencia remota
		// Buscar usuario READ
		
		List<Usuario> lista = fachadaLogica.findUsuario("Hola","Daniel");
		
		if (lista == null) {
			System.out.println("Usuario no exisiste");
		}else {
			
			for (Usuario user: lista) {
				System.out.print(user.getNombres());
			}
			
		}
		
		System.out.println("Nno hizo ni mierda");		
	}
}
