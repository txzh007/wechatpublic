package link.tanxin.wechatpublic.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Tan
 * 2019年4月15日 09:30:09
 * 此类是用于与微信服务器通信
 */
public interface WechatService {
    /**
     * @param signature 微信加密签名，结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param echostr   随机字符串
     * @return
     */
    String wechatToken(String signature, String timestamp, String nonce, String echostr);

    /**
     * 此类方法用于处理微信消息请求
     *
     * @param request
     * @return
     */

    String processRequest(HttpServletRequest request);
}
