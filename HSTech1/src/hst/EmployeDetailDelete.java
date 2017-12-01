package hst;

import java.util.logging.Logger;

import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;

public class EmployeDetailDelete {

	private static final ObjectId ObjectId = null;
	// db esthablishment and creation
	Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
	// mongoLogger.setLevel(Level.SEVERE);
	MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	MongoDatabase database = mongoClient.getDatabase("HST");
	GridFSBucket gridBucket = GridFSBuckets.create(database, "EmployeeDetails");

	public void dropDB() {

		gridBucket.drop();
		
		
		gridBucket.delete(ObjectId);

	}
}
