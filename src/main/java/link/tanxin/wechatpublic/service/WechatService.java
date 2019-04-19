package link.tanxin.wechatpublic.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Tan
 * 2019年4月15日 09:30:09
 * 此类是用于与微信服务器通信
 */
public interface WechatService {


    /**
     * 此类方法用于处理微信消息请求
     *
     * @param request
     * @return
     */

    Map<String, String> processRequest(HttpServletRequest request);

    /**
     * 此方法用于处理微信事件
     *
     * @param map
     * @return
     */
    String parseEvent(Map<String, String> map);

    /**
     * 此方法用于处理微信消息
     *
     * @param map
     * @return
     */
    String parseMessage(Map<String, String> map);
}
