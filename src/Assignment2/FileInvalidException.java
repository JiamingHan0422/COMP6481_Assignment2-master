package Assignment2;

//Customized exception class
public class FileInvalidException extends RuntimeException{
	public FileInvalidException(){
			
		super("Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.) ");
	}

	public FileInvalidException(String message){
		super(message);
			
	}
	

	public FileInvalidException(String message, Throwable cause){
			
		super(message,cause);
	}
		

	public FileInvalidException(Throwable cause) {
		 
	 super(cause);
	}

	public String getMessage() {
		return super.getMessage();
	}
		

}
