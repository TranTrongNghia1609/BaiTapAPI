package vn.iotstar.crud_api.Exception;

public class StorageFileNotFoundException extends StorageException{
    private static final long serialVersionUID = 1L;
    public StorageFileNotFoundException(String message) {
        super(message);
    }

}
