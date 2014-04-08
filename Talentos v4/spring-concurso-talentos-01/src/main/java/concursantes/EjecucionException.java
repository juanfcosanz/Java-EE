package concursantes;

public class EjecucionException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EjecucionException(){}
	
	public EjecucionException(String mns){
		super(mns);
	}

}
