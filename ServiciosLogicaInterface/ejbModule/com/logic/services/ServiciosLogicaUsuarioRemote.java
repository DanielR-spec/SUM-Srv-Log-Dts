package com.logic.services;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Remote;

import com.data.user.Usuario;


@Remote
public interface ServiciosLogicaUsuarioRemote {
	
	public String test();
	public HashMap<String,String> getUser(String user, String pass);
	public String addUser(HashMap<String, String> user);

}
