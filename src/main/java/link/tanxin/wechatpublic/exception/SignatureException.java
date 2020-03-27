package link.tanxin.wechatpublic.exception;

import javax.servlet.ServletException;

/**
 * @author: Ru He
 * Date: Created in 2019/6/18.
 * Description:
 */
public class SignatureException extends ServletException {

    public SignatureException(String msg) {
        super(msg);
    }
}
