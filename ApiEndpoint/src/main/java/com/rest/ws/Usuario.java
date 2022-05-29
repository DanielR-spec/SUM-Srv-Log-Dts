/**
 * 
 */
package com.rest.ws;

/**
 * @author danie
 *
 */
public class Usuario {
	
	
	public Usuario(int id, String name, String password) {
		super();
		Id = id;
		this.name = name;
		this.password = password;
	}
	private int Id;
	private String name;
	private String password;
	
	/**
	 * 
	 */
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}





	

}
