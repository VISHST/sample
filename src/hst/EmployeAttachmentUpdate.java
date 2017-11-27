package hst;

import static com.mongodb.client.model.Filters.eq;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;

public class EmployeAttachmentUpdate {
	protected String FileName;
	protected ObjectId ObjectId;
	protected ObjectId NewObjectId;
	protected Document Metadata;
	protected Date UploadDate;
	protected String Out;
	protected String Out1;

	// connection establishment
	MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	// Dtabase creation
	MongoDatabase database = mongoClient.getDatabase("HST");
	GridFSBucket gridBucket = GridFSBuckets.create(database, "EmployeeDetails");

	public Object updateByName(String AttachmentName,String path) throws FileNotFoundException {

		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);

		gridBucket.find(eq("filename", AttachmentName)).forEach(new Block<GridFSFile>() {

			public void apply(final GridFSFile gridFSFile) {
				 getValues(gridFSFile,path);

			}
		});

		return Out;

	}

	public Object updateByFileId(ObjectId FileId,String path) throws FileNotFoundException {

		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);

		gridBucket.find(eq("_id", FileId)).forEach(new Block<GridFSFile>() {

			public void apply(final GridFSFile gridFSFile) {

				getValues(gridFSFile,path);
			}
		});

		return "Successfuly inserted the details ";

	}

	public Object getValues(GridFSFile gridFSFile,String path) {

		String FileName = gridFSFile.getFilename();
		ObjectId ObjectId = gridFSFile.getObjectId();
		Document Metadata = gridFSFile.getMetadata();
		Date UploadDate = gridFSFile.getUploadDate();
		System.out.println("Employee name :" + FileName);
		System.out.println("ObjectId :" + ObjectId);
		System.out.println("Employee Details :" + Metadata);
		System.out.println("UploadDate :" + UploadDate);

		System.out.println("Calling upload of Document...");
		try {
			gridBucket.delete(ObjectId);
			System.out.println("deleting of attachement completed <br/>");
			InputStream inputStream = new FileInputStream(
					new File(path));
			GridFSUploadOptions uploadOptions = new GridFSUploadOptions().chunkSizeBytes(1024).metadata(Metadata);
			NewObjectId = gridBucket.uploadFromStream(FileName, inputStream, uploadOptions);
			gridBucket.find(eq("_id", NewObjectId)).forEach(new Block<GridFSFile>() {

				public void apply(final GridFSFile gridFSFile) {
					String FileName = gridFSFile.getFilename();
					ObjectId ObjectId = gridFSFile.getObjectId();
					Document Metadata = gridFSFile.getMetadata();
					Date UploadDate = gridFSFile.getUploadDate();
					System.out.println("Employee name :" + FileName);
					System.out.println("ObjectId :" + ObjectId);
					System.out.println("Employee Details :" + Metadata);
					System.out.println("UploadDate :" + UploadDate);
					String Out = "<table><tr><th>Employee name :</th><td>" + FileName
							+ "</td></tr> <tr><th>ObjectId :</th><td>" + ObjectId
							+ "</td></tr><tr><th>Employee Details :</th><td>" + Metadata
							+ "</td></tr><tr><th>UploadDate :</th><td>" + UploadDate + "</td></tr></table><hr>";

				}
			});

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return Out;

	}

}
