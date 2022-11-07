package com.conexion.rst;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.auth.oauth2.GoogleCredentials;


public class FireBase {

	private FirebaseApp fireApp = null;
	private FirebaseDatabase firebaseDatabase;
	private final static String outputFilePath = "C:\\Users\\danie\\Downloads\\imagenes\\uriKeys.txt";
	private final static String outputFilePathCart = "C:\\Users\\danie\\Downloads\\imagenes\\uriKeysCart.txt";
	private final static String outputFilePathPrend = "C:\\Users\\danie\\Downloads\\imagenes\\uriKeysPrend.txt";

	public FireBase() {
		// TODO Auto-generated constructor stub
	}

	public void getConexion() throws IOException {

		System.out.println("===Invocacion al metodo getConexion () en la objeto FireBase===");

		// Configuracion de parametros iniciales
		File initialFile = new File("C:\\Users\\danie\\Downloads\\fireBaseKey.json");
		FileInputStream inputStream = new FileInputStream(initialFile);
		GoogleCredentials credential = GoogleCredentials.fromStream(inputStream);

		System.out.println("Metodo conexion" + credential);

		// Creando conexion con fire base
		FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(credential)
				.setDatabaseUrl("https://forus-e023a-default-rtdb.firebaseio.com").build();

		
		// Initialize the default app if it not exsist
		List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
	    if(firebaseApps!=null && !firebaseApps.isEmpty()){
	        for(FirebaseApp app : firebaseApps){
	            if(app.getName().equals(FirebaseApp.DEFAULT_APP_NAME))
	            	fireApp = app;
	        }
	    }
	    else
	    	fireApp = FirebaseApp.initializeApp(options);  

	}

	// Retorna la informacion del carrito
	public String getUriKeysCart(String idUsuario, String idDonacion) throws IOException {
		System.out.println("===Invocacion al metodo getUriKeysCart() en la objeto FireBase===");

		String keySaved = "Files not added";

		System.out.println("Creando conexion con base de datos...");
		//firebaseDatabase = this.getConexion();
		getConexion();

		firebaseDatabase = FirebaseDatabase.getInstance(fireApp);
		firebaseDatabase.goOnline();

		// Referencias a la base de datos
		DatabaseReference ref = firebaseDatabase.getReference("/carrito").child(idUsuario);

		System.out.println("Metodo getKeys " + ref.getKey());

		HashMap<String, String> uriKeys = new HashMap<String, String>();

		// LEER DATOS DE BD FIREBASE
		if (ref != null) {
			System.out.println("Conexion establecida procesando solicitud");
			// Trayendo informacion de la base de datos
			ref.addChildEventListener(new ChildEventListener() {

				@Override
				public void onChildRemoved(DataSnapshot snapshot) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
					// TODO Auto-generated method stub
					CartFB fb = snapshot.getValue(CartFB.class);

					uriKeys.put("idFire", fb.getIdFire());
					uriKeys.put("idUsuario", String.valueOf(fb.getIdUsuario()));

					System.out.println("idFire child" + fb.getIdFire());
					System.out.println("idUser child" + fb.getIdUsuario());

					File file = new File(outputFilePathCart);

					BufferedWriter bf = null;

					try {

						// create new BufferedWriter for the output file
						bf = new BufferedWriter(new FileWriter(file));

						// iterate map entries
						for (Map.Entry<String, String> entry : uriKeys.entrySet()) {

							// put key and value separated by a colon
							bf.write(entry.getKey() + "@" + entry.getValue());

							// new line
							bf.newLine();
						}

						bf.flush();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {

						try {

							// always close the writer
							bf.close();
						} catch (Exception e) {
						}
					}

				}

				@Override
				public void onCancelled(DatabaseError error) {
					// TODO Auto-generated method stub

				}
			});
			System.out.println("Solicitud finalizada archivos guardados");
			keySaved = "Files Added";
			firebaseDatabase.goOffline();
		}
		return keySaved;

	}

	// Retorna la informacion de las prendas de acuerdo a la donacion
	public String getUriKeysPrendas(String idUsuario, String idDonaFire) throws IOException {
		System.out.println("===Invocacion al metodo getUriKeysPrendas() en la objeto FireBase===");

		System.out.println("Creando conexion con base de datos...");
		//firebaseDatabase = this.getConexion();
		getConexion();

		firebaseDatabase = FirebaseDatabase.getInstance(fireApp);
		firebaseDatabase.goOnline();

		String keySaved = "Files not added";

		// Referencias a la base de datos
		DatabaseReference ref = firebaseDatabase.getReference("/donaciones").child(idUsuario).child(idDonaFire)
				.child("prendas");

		System.out.println("Metodo getKeys " + ref.getKey());

		HashMap<String, String> uriKeys = new HashMap<String, String>();

		// LEER DATOS DE BD FIREBASE
		if (ref != null) {
			System.out.println("Conexion establecida procesando solicitud");
			// Trayendo informacion de la base de datos
			ref.addChildEventListener(new ChildEventListener() {

				@Override
				public void onChildRemoved(DataSnapshot snapshot) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
					// TODO Auto-generated method stub
					CartFB prenda = snapshot.getValue(CartFB.class);

					//Importante el mapa solo puede tener una linea para que no se sobre escriba
					uriKeys.put(prenda.getIdFire(), prenda.getImgUrl());

					File file = new File(outputFilePathPrend);

					BufferedWriter bf = null;

					try {

						// create new BufferedWriter for the output file
						bf = new BufferedWriter(new FileWriter(file));

						// iterate map entries
						for (Map.Entry<String, String> entry : uriKeys.entrySet()) {

							// put key and value separated by a colon
							bf.write(entry.getKey() + "@" + entry.getValue());

							// new line
							bf.newLine();

						}

						bf.flush();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {

						try {

							// always close the writer
							bf.close();
						} catch (Exception e) {
						}
					}
				}

				@Override
				public void onCancelled(DatabaseError error) {
					// TODO Auto-generated method stub

				}
			});
			System.out.println("Solicitud finalizada, archivos guardados en txt...");
			keySaved = "Files Added";

		}
		firebaseDatabase.goOffline();
		return keySaved;
	}

	// Retorna las prendas que existen en firebase
	public String getUriKeys() throws IOException {
		System.out.println("===Invocacion al metodo getUriKeys() en la objeto FireBase===");

		String keySaved = "Files not added";

		System.out.println("Creando conexion con base de datos...");
		
		getConexion();

		FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance(fireApp);
		firebaseDatabase.goOnline();

		// Referencias a la base de datos
		DatabaseReference ref = firebaseDatabase.getReference("/carritoAux");

		HashMap<String, String> uriKeys = new HashMap<String, String>();

		// LEER DATOS DE BD FIREBASE
		if (ref != null) {
			System.out.println("Conexion establecida procesando solicitud");
			// Trayendo informacion de la base de datos
			ref.addChildEventListener(new ChildEventListener() {

				@Override
				public void onChildRemoved(DataSnapshot snapshot) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onChildMoved(DataSnapshot snapshot, String previousChildName) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onChildChanged(DataSnapshot snapshot, String previousChildName) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
					// TODO Auto-generated method stub
					CartFB fb = snapshot.getValue(CartFB.class);

					uriKeys.put(fb.getIdFire() , fb.getImgUrl());
					// System.out.println("Nombre: " + fb.getNombre() + " UriKey: " +
					// fb.getUriKey());

					File file = new File(outputFilePath);

					BufferedWriter bf = null;

					try {

						// create new BufferedWriter for the output file
						bf = new BufferedWriter(new FileWriter(file));

						// iterate map entries
						for (Map.Entry<String, String> entry : uriKeys.entrySet()) {

							// put key and value separated by a colon
							bf.write(entry.getKey() + "@" + entry.getValue());

							// new line
							bf.newLine();
						}

						bf.flush();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {

						try {

							// always close the writer
							bf.close();
						} catch (Exception e) {
						}
					}

				}

				@Override
				public void onCancelled(DatabaseError error) {
					// TODO Auto-generated method stub

				}
			});
			System.out.println("Solicitud finalizada archivos guardados");
			firebaseDatabase.goOffline();
			keySaved = "Files Added";
		}

		return keySaved;

	}

}
