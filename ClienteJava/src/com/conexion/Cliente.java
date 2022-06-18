package com.conexion;

import java.util.List;

import javax.naming.NamingException;

import com.data.user.Usuario;
import com.logic.services.ServiciosLogicaUsuarioRemote;

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
		
		// Invocar el servicio usando la referencia remota
		//System.out.println(fachadaLogica.addUser());
		Usuario usr = fachadaLogica.getUser("carl123", "crl2020");
		System.out.print(usr.getNombres()+"\n");
		//usr.getNombres();
		/*
		for (Usuario user: lista) {
			System.out.print(user.getNombres()+"\n");
		}*/
		
	}
}
