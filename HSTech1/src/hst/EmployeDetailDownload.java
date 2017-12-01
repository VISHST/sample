package hst;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;

import org.bson.types.ObjectId;

public class EmployeDetailDownload {

	// db esthablishment and creation
	MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	MongoDatabase database = mongoClient.getDatabase("HST");
	GridFSBucket gridBucket = GridFSBuckets.create(database, "EmployeeDetails");

	// Download by FileId
	public Object Fileid(ObjectId FileId,String Path) throws IOException {

		FileOutputStream streamToDownloadTo = new FileOutputStream(Path+ File.separator);
		gridBucket.downloadToStream(FileId, streamToDownloadTo);
		
		String name = gridBucket.getBucketName();
		System.out.println("" + streamToDownloadTo.toString() + name.toString());
		streamToDownloadTo.close();
		return "</br>Successfuly Downloaded the file at the location :-"+Path+"</br> with ID:"
				+ FileId;
	}
	// Download by AttcahmentName

	public Object AttachmentName(String AttachmentName,String Path) throws IOException {

		System.out.println("Calling download...");
		FileOutputStream fileOutputStream = new FileOutputStream(Path);
		gridBucket.downloadToStream(AttachmentName, fileOutputStream);
		System.out.println("Calling download.successful..Document");
		fileOutputStream.close();
		return "</br>Successfuly Downloaded the file at the location :-"+Path+"</br> with AttachmentName:"
				+ AttachmentName;
	}

}
