package com.conexion;

import java.util.List;

import javax.naming.NamingException;

import com.data.user.Usuario;
import com.logic.services.ServiciosLogicaUsuarioRemote;
import com.data.services.ServiciosUsuarioRemote;


public class Cliente {


	public static void main(String[] args) throws NamingException {
		
		Lcz localizadorServicios = new Lcz();
		
		  ServiciosLogicaUsuarioRemote fachadaLogica = null;
		try {
			fachadaLogica = localizadorServicios.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * ServiciosUsuarioRemote fachadaDat = null;
		 
		try {
			fachadaDat = localizadorServicios.getRemoteFachadaLogicadat();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		// Invocar el servicio usando la referencia remota
		//System.out.println(fachadaLogica.addUser());
		//Usuario usrL = fachadaLogica.getUser("carl123", "crl2020");
		//Usuario usrL= fachadaDat.findUserr("carl123", "crl2020");
		//List<Usuario>usuarios = fachadaDat.findUsuario("per123", "prl20220");
		Usuario urs = fachadaLogica.getUser("per123", "prl2020");
		System.out.print(urs.getNombres()+"\n");
		//usr.getNombres();
		/*
		for (Usuario user: usuarios) {
			System.out.print(user.getNombres()+"\n");
		}*/
		
	}
}
