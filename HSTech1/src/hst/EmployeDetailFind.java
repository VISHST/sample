package hst;

import static com.mongodb.client.model.Filters.eq;

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
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;

public class EmployeDetailFind {

	// db esthablishment and creation
	Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
	// mongoLogger.setLevel(Level.SEVERE);
	MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	MongoDatabase database = mongoClient.getDatabase("HST");
	GridFSBucket gridBucket = GridFSBuckets.create(database, "EmployeeDetails");
	protected String FileName;
	protected ObjectId ObjectId;
	protected Document Metadata;
	protected Date UploadDate;
	protected String Out;

	// search procedure by visa type
	public Object VisaTypeFind(String VisaType) {
		mongoLogger.setLevel(Level.SEVERE);
		System.out.println("details of VisaType collection");
		gridBucket.find(eq("metadata.VisaType", VisaType)).forEach(new Block<GridFSFile>() {

			public void apply(final GridFSFile gridFSFile) {
				FileName = gridFSFile.getFilename();
				ObjectId = gridFSFile.getObjectId();
				Metadata = gridFSFile.getMetadata();
				UploadDate = gridFSFile.getUploadDate();
				System.out.println("Employee name :" + FileName);
				System.out.println("ObjectId :" + ObjectId);
				System.out.println("Employee Details :" + Metadata);
				System.out.println("UploadDate :" + UploadDate);

				Out += "<table><tr><th>Employee name :</th><td>" + FileName + "</td></tr> <tr><th>ObjectId :</th><td>"
						+ ObjectId + "</td></tr><tr><th>Employee Details :</th><td>" + Metadata
						+ "</td></tr><tr><th>UploadDate :</th><td>" + UploadDate + "</td</tr></table><hr>";

			}
		});

		return "Search Results :" + Out;
	}

	// search procedure by MailAddress
	public Object MailAddress(String MailAddress) {
		mongoLogger.setLevel(Level.SEVERE);
		System.out.println("details of MailAddress collections  ");
		gridBucket.find(eq("metadata.MailAddress", MailAddress)).forEach(new Block<GridFSFile>() {
			public void apply(final GridFSFile gridFSFile) {
				String FileName = gridFSFile.getFilename();
				ObjectId ObjectId = gridFSFile.getObjectId();
				Document Metadata = gridFSFile.getMetadata();
				Date UploadDate = gridFSFile.getUploadDate();
				System.out.println("Employee name :" + FileName);
				System.out.println("ObjectId :" + ObjectId);
				System.out.println("Employee Details :" + Metadata);
				System.out.println("UploadDate :" + UploadDate);
				Out += "<table><tr><th>Employee name :</th><td>" + FileName + "</td></tr><tr><th>ObjectId :</th><td>"
						+ ObjectId + "</td></tr><tr><th>Employee Details :</th><td>" + Metadata
						+ "</td></tr><tr><th>UploadDate :</th><td>" + UploadDate + "</td</tr></table><hr>";

			}
		});
		return "Search Results :" + Out;
	}

	// search procedure by contact num1
	public Object ContactNum1(String ContactNum1) {
		mongoLogger.setLevel(Level.SEVERE);
		System.out.println("details of ContactNum collections  ");
		gridBucket.find(eq("metadata.ContactNum1", ContactNum1)).forEach(new Block<GridFSFile>() {
			public void apply(final GridFSFile gridFSFile) {
				String FileName = gridFSFile.getFilename();
				ObjectId ObjectId = gridFSFile.getObjectId();
				Document Metadata = gridFSFile.getMetadata();
				Date UploadDate = gridFSFile.getUploadDate();
				System.out.println("Employee name :" + FileName);
				System.out.println("ObjectId :" + ObjectId);
				System.out.println("Employee Details :" + Metadata);
				System.out.println("UploadDate :" + UploadDate);
				Out += "<table><tr><th>Employee name :</th><td>" + FileName + "</td></tr> <tr><th>ObjectId :</th><td>"
						+ ObjectId + "</td></tr><tr><th>Employee Details :</th><td>" + Metadata
						+ "</td></tr><tr><th>UploadDate :</th><td>" + UploadDate + "</td</tr></table><hr>";

			}
		});
		return "Search Results :" + Out;
	}

	// Search procedure by contatct num 2
	public Object ContactNum2(String ContactNum2) {
		mongoLogger.setLevel(Level.SEVERE);
		System.out.println("details of ContactNum collections  ");
		gridBucket.find(eq("metadata.ContactNum2", ContactNum2)).forEach(new Block<GridFSFile>() {
			public void apply(final GridFSFile gridFSFile) {
				String FileName = gridFSFile.getFilename();
				ObjectId ObjectId = gridFSFile.getObjectId();
				Document Metadata = gridFSFile.getMetadata();
				Date UploadDate = gridFSFile.getUploadDate();
				System.out.println("Employee name :" + FileName);
				System.out.println("ObjectId :" + ObjectId);
				System.out.println("Employee Details :" + Metadata);
				System.out.println("UploadDate :" + UploadDate);
				Out += "<table><tr><th>Employee name :</th><td>" + FileName + "</td></tr> <tr><th>ObjectId :</th><td>"
						+ ObjectId + "</td></tr><tr><th>Employee Details :</th><td>" + Metadata
						+ "</td></tr><tr><th>UploadDate :</th><td>" + UploadDate + "</td</tr></table><hr>";

			}
		});
		return "Search Results :" + Out;
	}

	// search procedure by Filename
	public Object AttachmentName(String AttachmentName) {
		mongoLogger.setLevel(Level.SEVERE);
		System.out.println("details of AttachmentName collections  ");
		gridBucket.find(eq("filename", AttachmentName)).forEach(new Block<GridFSFile>() {
			public void apply(final GridFSFile gridFSFile) {
				String FileName = gridFSFile.getFilename();
				ObjectId ObjectId = gridFSFile.getObjectId();
				Document Metadata = gridFSFile.getMetadata();
				Date UploadDate = gridFSFile.getUploadDate();
				System.out.println("Employee name :" + FileName);
				System.out.println("ObjectId :" + ObjectId);
				System.out.println("Employee Details :" + Metadata);
				System.out.println("UploadDate :" + UploadDate);
				Out += "<table><tr><th>Employee name :</th><td>" + FileName + "</td></tr> <tr><th>ObjectId :</th><td>"
						+ ObjectId + "</td></tr><tr><th>Employee Details :</th><td>" + Metadata
						+ "</td></tr><tr><th>UploadDate :</th><td>" + UploadDate + "</td</tr></table><hr>";
				
			}
		});
		GridFSFindIterable testItemsCursor = gridBucket.find(eq("filename", AttachmentName));
	
		gridBucket.find(eq("filename","xxxxx"));
		//1.search document 2.get metdata and object id ,filename  3.set the new atthacment 
		return "Search Results :" + Out;
	}

	// search procedure by ObjectId
	public Object FileId(ObjectId FileId) {
		mongoLogger.setLevel(Level.SEVERE);
		System.out.println("details of ObjectId collections  ");
		gridBucket.find(eq("_id", FileId)).forEach(new Block<GridFSFile>() {
			public void apply(final GridFSFile gridFSFile) {
				String FileName = gridFSFile.getFilename();
				ObjectId ObjectId = gridFSFile.getObjectId();
				Document Metadata = gridFSFile.getMetadata();
				Date UploadDate = gridFSFile.getUploadDate();
				System.out.println("Employee name :" + FileName);
				System.out.println("ObjectId :" + ObjectId);
				System.out.println("Employee Details :" + Metadata);
				System.out.println("UploadDate :" + UploadDate);
				Out += "<table><tr><th>Employee name :</th><td>" + FileName + "</td></tr> <tr><th>ObjectId :</th><td>"
						+ ObjectId + "</td></tr><tr><th>Employee Details :</th><td>" + Metadata
						+ "</td></tr><tr><th>UploadDate :</th><td>" + UploadDate + "</td</tr></table><hr>";

			}
		});
		return "Search Results :" + Out;
	}

	public Object Findall() {
		System.out.println("details of all collections  ");
		mongoLogger.setLevel(Level.SEVERE);
		// database.getCollection("sai.vardhan.Boda.files").find();
		gridBucket.find().forEach(new Block<GridFSFile>() {
			public void apply(final GridFSFile gridFSFile) {
				String FileName = gridFSFile.getFilename();
				ObjectId ObjectId = gridFSFile.getObjectId();
				Document Metadata = gridFSFile.getMetadata();
				Date UploadDate = gridFSFile.getUploadDate();
				System.out.println("Employee name :" + FileName);
				System.out.println("ObjectId :" + ObjectId);
				System.out.println("Employee Details :" + Metadata);
				System.out.println("UploadDate :" + UploadDate);
				Out += "<table><tr><th>Employee name :</th><td>" + FileName + "</td></tr> <tr><th>ObjectId :</th><td>"
						+ ObjectId + "</td></tr><tr><th>Employee Details :</th><td>" + Metadata
						+ "</td></tr><tr><th>UploadDate :</th><td>" + UploadDate + "</td</tr></table><hr>";

			}
		});
		return "Search Results :" + Out;
	}

	public void close() {
		mongoClient.close();
	}
}
