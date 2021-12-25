package az.developia.compshopNihatHeyderov.file;

public class StorageFileNotFoundException extends StorageException{

	public StorageFileNotFoundException(String message) {
		super(message);
	}
	public StorageFileNotFoundException(String message,Throwable cause) {
		super(message,cause);
	}
}
