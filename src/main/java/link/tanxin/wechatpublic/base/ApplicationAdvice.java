package link.tanxin.wechatpublic.base;

import link.tanxin.wechatpublic.exception.LessParamsException;
import link.tanxin.wechatpublic.exception.TokenErrorException;
import link.tanxin.wechatpublic.model.Result;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletResponse;
import java.security.SignatureException;
import java.util.List;

/**
 * @author Tan
 */
@Log4j2
@RestControllerAdvice
public class ApplicationAdvice {

    public ApplicationAdvice(){

    }

    /**
     * 功能描述: 处理请求方法不支持异常
     * @date 2019/6/21 下午2:41
     */
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public Result handleNotSupport(Exception e){

        return Result.asNotSupported(e.getMessage());
    }

    /**
     * 功能描述: 处理其他异常
     * @date 2019/6/21 下午2:41
     */
    /*@ExceptionHandler(value = Exception.class)
    public Result handException(Exception e){
        log.error("found system error.", e);
        return Result.asSysErr();
    }*/

    /**
     * 功能描述: 处理令牌异常
     * @date 2019/6/21 下午2:41
     */
    @ExceptionHandler(value = TokenErrorException.class)
    public Result handTokenException(TokenErrorException e){
        log.error("found system error.", e);
        return Result.asSysErr();
    }

    /**
     * 功能描述: 处理未找到访问路径异常
     * @date 2019/6/21 下午2:41
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public Result handNotFoundException(Exception e){
        log.warn("file not found.", e.getMessage());
        return Result.asNotFound();
    }

    /**
     * 功能描述: 处理自定义的为授权异常
     * @date 2019/6/21 下午2:41
     */
    /*@ExceptionHandler(value = AuthException.class)
    public Result handAuthException(AuthException e){
        log.error("check auth error.", e);
        return Result.asUnAuth();
    }*/

    /**
     * 功能描述: 处理Controller方法参数@Validat注解校验异常
     * @date 2019/6/21 下午2:41
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result argumentNotValidException(MethodArgumentNotValidException e){
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        StringBuilder sb = new StringBuilder();
        for(FieldError fe : errors){
            sb.append(fe.getField());
            sb.append(": ");
            sb.append(fe.getDefaultMessage());
            sb.append(";");
        }
        log.warn("parameter valid error: {}", e.getMessage());
        return Result.asParamErr(sb.toString());
    }

    /**
     * 功能描述: 处理HTTP内容无法读取异常
     * @date 2019/6/21 下午2:41
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public Result httpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error(e.getMessage(), e);
        return Result.asNotReadable();
    }

    /**
     * 功能描述: 处理缺少参数异常
     * @date 2019/6/21 下午2:41
     */
    @ExceptionHandler(value = LessParamsException.class)
    public Result handleLessParamsException(LessParamsException e) {
        log.warn(e.getMessage());
        return Result.asParamErr(e.getMessage());
    }

    /**
     * 功能描述: 处理签名错误异常
     * @date 2019/6/21 下午2:41
     */
    @ExceptionHandler(value = SignatureException.class)
    public Result handleSignatureException(SignatureException e) {
        log.warn(e.getMessage());
        return Result.asSignatureErr();
    }

    /**
     * 功能描述: 处理签名错误异常
     * @date 2019/6/21 下午2:41
     */
    /*@ExceptionHandler(value = AccessDeniedException.class)
    public Result handleAccessDeniedException(AccessDeniedException e) {
        log.warn(e.getMessage());
        return Result.asSignatureErr();
    }*/

    /**
     * 功能描述: 处理没有权限访问异常
     * @date 2019/6/21 下午2:41
     */
    /*@ExceptionHandler(value = UnauthorizedException.class)
    public Result handleUnauthorizedException(UnauthorizedException e) {
        log.warn(e.getMessage());
        return new Result(Result.NO_PERMISSION, "not permission");
    }*/

    /**
     * 功能描述: 处理Shiro未登录异常
     * @date 2019/6/21 下午2:41
     */
   /* @ExceptionHandler(value = UnauthenticatedException.class)
    public Result handleUnauthenticatedException(UnauthenticatedException e) {
        log.warn(e.getMessage());
        return Result.asUnAuth();
    }*/

    /**
     * 功能描述: 处理Shiro未登录异常
     * @date 2019/6/21 下午2:41
     */
    /*@ExceptionHandler(value = AuthenticationException.class)
    public Result handleAuthenticationException(AuthenticationException e) {
        log.warn(e.getMessage());
        return Result.asUnAuth();
    }*/

}
