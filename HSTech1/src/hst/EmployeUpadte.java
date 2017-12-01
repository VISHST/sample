package hst;

import java.util.logging.Logger;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.bson.Document;
import org.bson.types.ObjectId;

public class EmployeUpadte {
	Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
	// mongoLogger.setLevel(Level.SEVERE);
	MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	MongoDatabase database = mongoClient.getDatabase("HST");
	GridFSBucket gridBucket = GridFSBuckets.create(database, "EmployeeDetails");
	
	 //Rename File 
    public void rename(ObjectId objectId,String newFileName) {
  System.out.println("Calling rename...");
  MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
  try {
   MongoDatabase database = mongoClient.getDatabase("technicalkeeda");
   GridFSBucket gridBucket = GridFSBuckets.create(database);
   gridBucket.rename(objectId, newFileName);
  

   
  } catch (Exception e) {
   e.printStackTrace();
  }
	
	
}
}
