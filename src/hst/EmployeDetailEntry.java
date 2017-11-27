package hst;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;

public class EmployeDetailEntry {
	ObjectId fileId = null;
	// connection establishment
	MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	// Dtabase creation
	MongoDatabase database = mongoClient.getDatabase("HST");
	GridFSBucket gridBucket = GridFSBuckets.create(database, "EmployeeDetails");

	public ObjectId upload(String FirstName, String MiddleName, String LastName, String MailAddress, String VisaType,
			String VisaDocument, String IDProofDocument, String Resume, String Comments, String ContactNum1,
			String ContactNum2) {
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);

		Document document;
		document = new Document("type", "doc").append("FirstName", FirstName).append("MiddleName", MiddleName)
				.append("LastName", LastName).append("VisaType", VisaType).append("ContactNum1", ContactNum1)
				.append("ContactNum2", ContactNum2).append("Comments", Comments).append("MailAddress", MailAddress);

		
		
		
		// Visa Document
		try {
			String AttachmentName = FirstName + MiddleName + LastName + "VisaDocument";
			System.out.println("Calling upload VisaDocument..");
			insert(AttachmentName, VisaDocument, document);
			System.out.println("Calling upload VisaDocument sucessfull..");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// IDProofDocument
		try {
			String AttachmentName = FirstName + MiddleName + LastName + "IDProofDocument";
			System.out.println("Calling upload IDProofDocument..");
			insert(AttachmentName, IDProofDocument, document);
			System.out.println("Calling upload IDProofDocument sucessfull..");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Resume
		try {
			String AttachmentName = FirstName + MiddleName + LastName + "Resume";
			System.out.println("Calling upload Resume..");
			insert(AttachmentName, Resume, document);
			System.out.println("Calling upload Resume sucessfull..");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		//connection close 
		finally {

			mongoClient.close();
		}

		return fileId;
	}

	public Object insert(String AttachmentName, String Path, Document document) throws FileNotFoundException {

		InputStream inputStream = new FileInputStream(new File(Path));

		GridFSUploadOptions uploadOptions = new GridFSUploadOptions().chunkSizeBytes(1024).metadata(document);

		fileId = gridBucket.uploadFromStream(AttachmentName, inputStream, uploadOptions);

		System.out.println("Calling upload..sucessfull." + uploadOptions.getMetadata());

		return fileId;

	}
}
