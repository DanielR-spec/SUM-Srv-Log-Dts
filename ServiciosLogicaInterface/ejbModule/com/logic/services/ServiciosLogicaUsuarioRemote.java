package com.logic.services;

import java.util.List;

import javax.ejb.Remote;

import com.data.user.Usuario;


@Remote
public interface ServiciosLogicaUsuarioRemote {
	
	public List<Usuario> getUsers();

	public String addUser();

}
