package com.logic.services;

import java.util.List;

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
	public List<Usuario> getUsers() {

		// TODO Auto-generated method stub
		LocalizadorServicios localizadorServicios = new LocalizadorServicios();
		ServiciosUsuarioRemote serviciosUsuarioRemote = null;
		try {
			serviciosUsuarioRemote = localizadorServicios.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return serviciosUsuarioRemote.getAllUsuarios();
	}
	
	@Override
	public Usuario getUser(String userName, String password) {
		
		LocalizadorServicios localizadorServicios = new LocalizadorServicios();
		ServiciosUsuarioRemote serviciosUsuarioRemote = null;
		try {
			serviciosUsuarioRemote = localizadorServicios.getRemoteFachadaLogica();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Usuario>usuarios=serviciosUsuarioRemote.findUsuario(userName, password);

		for (Usuario cliente: usuarios) {
			if(userName.equals(cliente.getUsername())&&password.equals(cliente.getPassword())){
				return cliente;
			}
		}
		return null;		
		
	}

	@Override
	public String addUser() {
		// TODO Auto-generated method stub
		return "Holadfsfs";
	}

}
