package link.tanxin.wechatpublic.exception;

public class IllegalRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IllegalRequestException(){
		super();
	}

	public IllegalRequestException(String msg){
		super("The request is illegal. message is [" + msg + "]");
	}
	
}
