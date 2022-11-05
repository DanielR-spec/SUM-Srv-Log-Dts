package com.data.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import com.model.ent.TipoUsuario;
import com.model.ent.UbicacionUsuario;
import com.model.ent.Usuario;


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

	// BUSCAR USUARIO, RETORNA LA LISTA DE USUARIOS ENCONTRADOS
	// READ Funciona
	@Override
	public List<Usuario> findUsuario(String correo, String clave) {
		// TODO Auto-generated method stub
		String consulta = "SELECT e FROM Usuario e WHERE  e.correo = :correo AND e.clave = :clave";
		TypedQuery<Usuario> query = entityManager.createQuery(consulta, Usuario.class);
		query.setParameter("correo", correo);
		query.setParameter("clave", clave);
		query.setMaxResults(1);
		List<Usuario> resultList = query.getResultList();

		if (resultList.size() == 0) {
			return null;
		}
		return resultList;

	}

	// BUSCAR USUARIO POR ID, RETORNA LA LISTA DE USUARIOS ENCONTRADOS
	// READ Funciona
	@Override
	public List<Usuario> findUsuarioById(int id) {
		// TODO Auto-generated method stub
		String consulta = "SELECT e FROM Usuario e WHERE  e.idUsuario = :idUser";
		TypedQuery<Usuario> query = entityManager.createQuery(consulta, Usuario.class);
		query.setParameter("idUser", id);
		query.setMaxResults(1);
		List<Usuario> resultList = query.getResultList();

		if (resultList.size() == 0) {
			return null;
		}
		return resultList;

	}

	// AGREGAR USUARIO, AGREGA UN USARIO NUEVO RETORNA LA LISTA DE USUARIOS
	// ENCONTRADOS, LA LOGICA DEL id SE HACE EN LA LOGICA
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

	// AGREGAR TIPO DE USUARIO, AGREGA UN NUEVO TIPO DE USUARIO RETORNA LA LISTA DE
	// USUARIOS ENCONTRADOS, LA LOGICA DEL id SE HACE EN LA LOGICA
	// CREATE Funciona
	@Override
	public void addUsuarioTipo(TipoUsuario tipo) {
		// TODO Auto-generated method stub
		TipoUsuario userTp = entityManager.find(TipoUsuario.class, tipo.getIdTipoUsuario());
		if (userTp == null) {
			entityManager.persist(tipo);
			entityManager.flush();
		}

	}
	
	@Override
	public void addUsuarioUb(UbicacionUsuario userUb) {
		// TODO Auto-generated method stub
		UbicacionUsuario userUbi = entityManager.find(UbicacionUsuario.class, userUb.getIdUbicacionUsuario());
		if (userUbi == null) {
			entityManager.persist(userUb);
			entityManager.flush();
		}
		
	}

	// TRAER USUARIOS, RETORNA LA LISTA DE TODOS LOS USUARIOS ENCONTRADOS
	// READ Funciona
	@Override
	public List<Usuario> getAllUsuarios() {
		// TODO Auto-generated method stub
		String consulta = "SELECT p FROM Usuario p";
		TypedQuery<Usuario> query = entityManager.createQuery(consulta, Usuario.class);
		List<Usuario> resultList = query.getResultList();
		if (resultList.size() == 0) {
			return null;
		}
		return resultList;
	}

	// ELIMINAR USUARIOS, ELIMINA EL USUARIO, PENSAR EN LA LOGICA DE ID
	// DELETE Funciona
	@Override
	public String delUsuario(int id) {
		// TODO Auto-generated method stub

		Usuario user = entityManager.find(Usuario.class,id);

		if (user == null) {
			return "No existe";
		} else {
			entityManager.remove(user);
			return "Usuario eliminado correctamente";
		}

	}

	// ELIMINAR TIPO DE USUARIO, ELIMINA EL TIPO DE USUARIO
	// DELETE Funciona
	@Override
	public String delTipoUsuario(int id) {
		// TODO Auto-generated method stub

		TipoUsuario user = entityManager.find(TipoUsuario.class, id);
		if (user.equals(null)) {
			return "Usuario no existe";
		} else {
			entityManager.remove(user);
			return "Usuario eliminado correctamente";
		}

	}

	// ACTUALIZAR USUARIOS, ACTUALIZA LA INFORMACION DE LOS USUARIOS
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

	// TRAER ID, RETORNA EL ULTIMO ID DE LA BD
	// READ Funciona
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		String consulta = "SELECT p FROM Usuario p";
		TypedQuery<Usuario> query = entityManager.createQuery(consulta, Usuario.class);
		List<Usuario> resultList = query.getResultList();

		return resultList.size();
	}
	
	// BUSCAR USUARIO, RETORNA LA LISTA DE USUARIOS ENCONTRADOS
	// READ Funciona
	@Override
	public List<TipoUsuario> findTipoUsuarioEmp() {
		// TODO Auto-generated method stub
		String consulta = "SELECT e FROM TipoUsuario e WHERE  e.tipoUsuario = :tipoUsuario";
		TypedQuery<TipoUsuario> query = entityManager.createQuery(consulta, TipoUsuario.class);
		query.setParameter("tipoUsuario", "E");
		query.setMaxResults(1);
		List<TipoUsuario> resultList = query.getResultList();

		if (resultList.size() == 0) {
			return null;
		}
		return resultList;

	}


}
