package com.conexion;

import java.util.List;

import javax.naming.NamingException;

import com.logic.services.ServiciosLogicaUsuarioRemote;
import com.model.ent.Prenda;
import com.model.ent.Usuario;
import com.data.services.ServiciosPrendaRemote;
import com.data.services.ServiciosUsuarioRemote;

public class PrendaCRUD {
	
	
	/**
	 * 
	 */
	public PrendaCRUD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static ServiciosPrendaRemote lczPrnd() {
		
		// Buscar la fachada de datos
		LczPrenda localizadorServicios = new LczPrenda();

		ServiciosPrendaRemote fachadaData = null;
		try {
			fachadaData = localizadorServicios.getRemoteFachadaLogica();
			return fachadaData;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fachadaData;
		
	}

	public static String addPrenda(ServiciosPrendaRemote dt) {
		
		System.out.println("Agregar Prenda id:1 , idUsr: 2, Url:https://www.google.com/search?q=triger+mysql&oq=triger+mysql&aqs=chrome..69i57j0i10i512l9.3347j1j7&sourceid=chrome&ie=UTF-8");
		Prenda prenda = new Prenda();
		prenda.setIdPrenda(1);
		prenda.setIdUsuario(2);
		prenda.setImageUrl("https://www.google.com/search?q=triger+mysql&oq=triger+mysql&aqs=chrome..69i57j0i10i512l9.3347j1j7&sourceid=chrome&ie=UTF-8");
		String res = dt.addPrenda(prenda);
		
		System.out.println(res);
		
		return res;
		
	}

	public static void getPrenda(ServiciosPrendaRemote dt) {
		
		System.out.println("Inicia prueba de buscar prenda por id: 1");
		List<Prenda> lista = dt.findPrendaById(1);

		if (lista == null) {
			System.out.println("Prenda no existe");
		} else {
			for (Prenda prnd : lista) {
				System.out.println("Informacion: ");

				System.out.print("IdPrenda: " + prnd.getIdPrenda() + "\n");
				System.out.print("IdUsuario: " + prnd.getIdUsuario() + "\n");
				System.out.print("URL: " + prnd.getImageUrl() + "\n");
			}

		}
				
	}
	
	public static void deletPrenda(ServiciosPrendaRemote dt) {
		
 		//Eliminar usuario DELETE User Funciona
		
		System.out.println("Eliminar prenda idPrenda: 1");
 		Prenda prenda = new Prenda();
 		prenda.setIdPrenda(1);
		String res = dt.delPrenda(prenda);
		
		System.out.println(res);
	
	
		System.out.println("End Function 4"+ "\n");
				
	}
	
	public static void updatePrenda(ServiciosPrendaRemote dt) {
		
		
		// Actualizar usuario UPDATE User

		System.out.println("Actualizar prenda id: 1");
		Prenda prenda = new Prenda();
		prenda.setIdPrenda(1);
		prenda.setIdUsuario(2);
		prenda.setImageUrl("http://local.com");
		String res = dt.updatePrenda(prenda);
		
		System.out.println(res);
		
	
		System.out.println("End Function 3"+ "\n");
				
	}

	public static void main(String[] args) throws NamingException {
		
	
		//Get EJB conexion
		ServiciosPrendaRemote prendaRemote = lczPrnd();
		
		//Test create/add prenda
		//addPrenda(prendaRemote);
		
		//Test read/get prenda
		//getPrenda(prendaRemote);
		
		//Test delete prenda
		//deletPrenda(prendaRemote);
		
		//Test delete prenda
		//updatePrenda(prendaRemote);
		
	


	}

}
