package com.data.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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

	@Override
	public List<Usuario> findUsuario(String usrName, String pass) {
		// TODO Auto-generated method stub
		String consulta = "SELECT e FROM Usuario e WHERE  e.username = :userName AND e.password = :passWord";
		TypedQuery<Usuario> query = entityManager.createQuery(consulta, Usuario.class);
		query.setParameter("userName", usrName);
		query.setParameter("passWord", pass);
		query.setMaxResults(1);
		List<Usuario> resultList = query.getResultList();
		return resultList;

	}
	
	@Override
	public Usuario findUserr(String username, String password) {

	    Query query = entityManager.createNamedQuery("SELECT p FROM Usuario p WHERE username=usrName and password=pass");
	    query.setParameter("username", username);
	    query.setParameter("password", password);

	    return (Usuario) query.getSingleResult();
	}

	@Override
	public String addUsuario() {
		// TODO Auto-generated method stub
		Usuario newUsuario = new Usuario();
		newUsuario.setIdUsuario(4);
		newUsuario.setNombres("hola");
		newUsuario.setApellidos("loco");
		newUsuario.setUsername("hola");
		newUsuario.setPassword("hola");
		Usuario user = entityManager.find(Usuario.class, newUsuario.getIdUsuario());
		if (user == null) {
		entityManager.persist(newUsuario);
		return "insertado";
		} else
		return "existe";

	}

	@Override
	public List<Usuario> getAllUsuarios() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("SELECT p FROM Usuario p", Usuario.class).getResultList();
	}

}
