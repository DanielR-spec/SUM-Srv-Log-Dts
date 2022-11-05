package com.conexion.rst;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.ejb.Asynchronous;
import javax.json.JsonObject;
import javax.json.JsonValue;

import org.hibernate.validator.internal.util.logging.Log;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.cloud.StorageClient;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firestore.v1.Document;
import com.model.ent.Carrito;
import com.model.ent.Prenda;

import io.opencensus.metrics.export.Summary.Snapshot;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.util.IOUtils;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobGetOption;
import com.google.cloud.storage.StorageOptions;

public class FireBase {

	private static final String UTF_8 = null;
	private static Firestore bd = null;
	private boolean key = false;
	private FirebaseApp fireApp;
	private FirebaseDatabase firebaseDatabase;
	private final static String outputFilePath = "C:\\Users\\danie\\Downloads\\imagenes\\uriKeys.txt";
	private final static String outputFilePathCart = "C:\\Users\\danie\\Downloads\\imagenes\\uriKeysCart.txt";
	private final static String outputFilePathPrend = "C:\\Users\\danie\\Downloads\\imagenes\\uriKeysPrend.txt";

	public FireBase() {
		// TODO Auto-generated constructor stub
	}

	public FirebaseApp getConexion() throws IOException {

		System.out.println("===Invocacion al metodo getConexion () en la objeto FireBase===");

		// Configuracion de parametros iniciales
		File initialFile = new File("C:\\Users\\danie\\Downloads\\fireBaseKey.json");
		FileInputStream inputStream = new FileInputStream(initialFile);
		GoogleCredentials credential = GoogleCredentials.fromStream(inputStream);

		System.out.println("Metodo conexion" + credential);

		// Creando conexion con fire base
		FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(credential)
				.setDatabaseUrl("https://forus-e023a-default-rtdb.firebaseio.com").build();

		// Initialize the default app
		if (fireApp.getApps().isEmpty()) {
			fireApp = FirebaseApp.initializeApp(options);

		}
		

		//System.out.println("Metodo conexion" + fireApp.getName()); // "[DEFAULT]"

		// Retrieve services by passing the defaultApp variable...

		//FirebaseDatabase defaultDatabase = FirebaseDatabase.getInstance(fireApp);

		// LEER DATOS DE BD FIREBASE
		if (bd != null) {
			return fireApp;
		}

		return fireApp;
	}

	// Retorna la informacion del carrito
	public String getUriKeysCart(String idUsuario, String idDonacion) throws IOException {
		System.out.println("===Invocacion al metodo getUriKeysCart() en la objeto FireBase===");

		String keySaved = "Files not added";

		System.out.println("Creando conexion con base de datos...");
		firebaseDatabase = FirebaseDatabase.getInstance(new FireBase().getConexion()); 

		// Referencias a la base de datos
		DatabaseReference ref = firebaseDatabase.getReference("/carrito").child(idUsuario);

		System.out.println("Metodo getKeys " + ref.getKey());

		// String userId = ref.push().getKey();

		// Inizializar la bd
		bd = FirestoreClient.getFirestore();

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
			return keySaved;
		}
		return keySaved;

	}

	// Retorna la informacion de las prendas de acuerdo a la donacion
	public String getUriKeysPrendas(String idUsuario, String idDonaFire) throws IOException {
		System.out.println("===Invocacion al metodo getUriKeysPrendas() en la objeto FireBase===");

		System.out.println("Creando conexion con base de datos...");
		firebaseDatabase = FirebaseDatabase.getInstance(new FireBase().getConexion()); 

		String keySaved = "Files not added";

		// Referencias a la base de datos
		DatabaseReference ref = firebaseDatabase.getReference("/donaciones").child(idUsuario).child(idDonaFire)
				.child("prendas");

		System.out.println("Metodo getKeys " + ref.getKey());

		// String userId = ref.push().getKey();

		// Inizializar la bd
		bd = FirestoreClient.getFirestore();
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
		return keySaved;
	}

	// Retorna las prendas que existen en firebase
	public String getUriKeys() throws IOException {
		System.out.println("===Invocacion al metodo getUriKeys() en la objeto FireBase===");

		String keySaved = "Files not added";

		System.out.println("Creando conexion con base de datos...");
		firebaseDatabase = FirebaseDatabase.getInstance(new FireBase().getConexion()); 

		// Referencias a la base de datos
		DatabaseReference ref = firebaseDatabase.getReference("/carritoAux");

		// Inizializar la bd
		bd = FirestoreClient.getFirestore();

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
			keySaved = "Files Added";
		}

		return keySaved;

	}

}
