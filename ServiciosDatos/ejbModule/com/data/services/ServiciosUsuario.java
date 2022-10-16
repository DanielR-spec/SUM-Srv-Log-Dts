package com.data.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.data.user.Usuario;

/**
 * Session Bean implementation class ServiciosUsuario
 */
@Stateless
@LocalBean
public class ServiciosUsuario implements ServiciosUsuarioRemote, ServiciosUsuarioLocal {
	
	@PersistenceContext(unitName = "Entidades", type = PersistenceContextType.TRANSACTION)
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public ServiciosUsuario() {
        // TODO Auto-generated constructor stub
    }

    //BUSCAR USUARIO, RETORNA LA LISTA DE USUARIOS ENCONTRADOS
	// READ Funciona
	@Override
	public List<Usuario> findUsuario(String usrName, String pass) {
		// TODO Auto-generated method stub
		String consulta = "SELECT e FROM Usuario e WHERE  e.username = :userName AND e.password = :passWord";
		TypedQuery<Usuario> query = entityManager.createQuery(consulta, Usuario.class);
		query.setParameter("userName", usrName);
		query.setParameter("passWord", pass);
		query.setMaxResults(1);
		List<Usuario> resultList = query.getResultList();
		
		if (resultList.size()==0) {
			return null;
		}
		return resultList;

	}
	
    //BUSCAR USUARIO POR ID, RETORNA LA LISTA DE USUARIOS ENCONTRADOS
	// READ Funciona
	@Override
	public List<Usuario> findUsuarioById(String id) {
		// TODO Auto-generated method stub
		String consulta = "SELECT e FROM Usuario e WHERE  e.id = :ID";
		TypedQuery<Usuario> query = entityManager.createQuery(consulta, Usuario.class);
		query.setParameter("ID", Integer.parseInt(id));
		query.setMaxResults(1);
		List<Usuario> resultList = query.getResultList();
		
		if (resultList.size()==0) {
			return null;
		}
		return resultList;

	}
	
    //AGREGAR USUARIO, AGREGA UN USARIO NUEVO RETORNA LA LISTA DE USUARIOS ENCONTRADOS, LA LOGICA DEL id SE HACE EN LA LOGICA
	// CREATE Funciona
	@Override
	public String addUsuario(Usuario usr) {
		// TODO Auto-generated method stub
		Usuario user = entityManager.find(Usuario.class, usr.getIdUsuario());
		if (user == null) {
		entityManager.persist(usr);
		return "usuario insertado";
		} else
		return "usuario existe";

	}

    //TRAER USUARIOS, RETORNA LA LISTA DE TODOS LOS USUARIOS ENCONTRADOS
	//READ Funciona
	@Override
	public List<Usuario> getAllUsuarios() {
		// TODO Auto-generated method stub
		String consulta ="SELECT p FROM Usuario p";
		TypedQuery<Usuario> query = entityManager.createQuery(consulta, Usuario.class);
		List<Usuario> resultList = query.getResultList();
		if (resultList.size()==0) {
			return null;
		}
		return resultList;
	}
	
    //ELIMINAR USUARIOS, ELIMINA EL USUARIO, PENSAR EN LA LOGICA DE ID
	// DELETE Funciona
	@Override
	public String delUsuario(Usuario usr) {
		// TODO Auto-generated method stub

		Usuario user = entityManager.find(Usuario.class, usr.getIdUsuario());
		if (user.equals(null)) {
			return "No existe";
		} else {
			entityManager.remove(user);
			return "existe y se elimino";
		}

	}
	
    //ACTUALIZAR USUARIOS, ACTUALIZA LA INFORMACION DE LOS USUARIOS
	// UPDATE Funciona
	@Override
	public String updateUsuario(Usuario usr) {
		// TODO Auto-generated method stub

		Usuario user = entityManager.find(Usuario.class, usr.getIdUsuario());
		if (user.equals(null)) {
			return "No existe";
		} else {
			entityManager.merge(usr);
			entityManager.flush();
			return "existe y se actualizo";
		}

	}


    //TRAER ID, RETORNA EL ULTIMO ID DE LA BD
	//READ Funciona
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		String consulta ="SELECT p FROM Usuario p";
		TypedQuery<Usuario> query = entityManager.createQuery(consulta, Usuario.class);
		List<Usuario> resultList = query.getResultList();

		return resultList.size();
	}
}
