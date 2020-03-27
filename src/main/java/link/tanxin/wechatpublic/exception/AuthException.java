package link.tanxin.wechatpublic.exception;

import javax.servlet.ServletException;


/**
 * @author Tan
 */
public class AuthException extends ServletException {

    public AuthException(String message) {
        super(message);
    }
}
