package link.tanxin.wechatpublic.exception;

public class LessParamsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public LessParamsException(){
		super();
	}

	public LessParamsException(String key){
		super("less parameter by " + key);
	}
	
}
