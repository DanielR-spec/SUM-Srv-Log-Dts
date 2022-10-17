package com.data.services;

import java.util.List;

import javax.ejb.Remote;

import com.data.user.Usuario;

@Remote
public interface ServiciosUsuarioRemote {
	
	public List<Usuario> findUsuario(String userName, String password);
	public String addUsuario(Usuario usr);
	public List<Usuario> getAllUsuarios();
	public String delUsuario(Usuario usr);
	public String updateUsuario(Usuario usr);
	public int getId();
	public List<Usuario> findUsuarioById(int id);

}
