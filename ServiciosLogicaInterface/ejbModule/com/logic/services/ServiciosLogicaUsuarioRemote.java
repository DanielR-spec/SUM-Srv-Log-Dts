package com.logic.services;

import java.util.HashMap;
import java.util.List;

import javax.ejb.Remote;

import com.data.user.Usuario;


@Remote
public interface ServiciosLogicaUsuarioRemote {
	
	public String delUsr(HashMap<String, String> user);
	public HashMap<String,String> getUser(String user, String pass);
	public HashMap<String,String> getUserById(String id);
	public String addUser(HashMap<String, String> user);
	public String updUser(HashMap<String, String> user);

}
