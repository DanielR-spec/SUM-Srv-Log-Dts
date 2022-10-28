package com.conexion;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import javax.ejb.Asynchronous;
import javax.json.JsonObject;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.util.IOUtils;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;


public class FireBase {

	private static Firestore bd = null;
	private boolean key = false;
	// final FirebaseDatabase database = FirebaseDatabase.getInstance();

	public FireBase() {
		// TODO Auto-generated constructor stub
	}

	public boolean getConexion() throws IOException {
		
		File initialFile = new File("./key.json");
		
		FileInputStream fis = new FileInputStream(initialFile);		
			    
	    System.out.println(fis);
	    
		GoogleCredentials credential = GoogleCredentials.fromStream(fis);

	    System.out.println(credential);

	    

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(credential)
				.setDatabaseUrl("https://forus-e023a-default-rtdb.firebaseio.com")
				.build();
		
		FirebaseApp.initializeApp(options);
		bd = FirestoreClient.getFirestore();
		return true;

	}

//	public boolean readFireBase() {
//		
//
//		DatabaseReference ref = database.getReference("server/saving-data/fireblog");
//
//		DatabaseReference usersRef = ref.child("imagenes");
//
//		HashMap<String, String> users = new HashMap<>();
//		users.put("alanisawesome", "ddsfd");
//		
//		// Attach a listener to read the data at our posts reference
//		usersRef.addValueEventListener(new ValueEventListener() {
//			
//			@Override
//			public void onDataChange(DataSnapshot dataSnapshot) {
//				// TODO Auto-generated method stub
//			    System.out.println(dataSnapshot.getValue());
//				
//			}
//			
//			@Override
//			public void onCancelled(DatabaseError databaseError) {
//				// TODO Auto-generated method stub
//			    System.out.println("The read failed: " + databaseError.getCode());				
//			}
//		});
//		
//		return true;
//
//	}
}
