package pobj.multiset;

public class InvalidMultiSetFormat extends Exception{
	private static final long serialVersionUID = 1L; //genéré auto


	public InvalidMultiSetFormat(String msg) {
		super(msg);
	}
	
	public InvalidMultiSetFormat(String msg, Throwable cause) {
		super(msg, cause);
	}
}
