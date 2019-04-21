package link.tanxin.wechatpublic.controller;

import link.tanxin.wechatpublic.service.WechatService;
import link.tanxin.wechatpublic.utils.MsgTypeParam;
import link.tanxin.wechatpublic.utils.WechatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 微信Token接口
 *
 * @author Tan
 * 2019年4月8日 11:28:09
 */
@RestController
public class WechatController {
    @Autowired
    WechatService wechatService;

    /**
     * @param signature 微信加密签名，结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
     * @param timestamp 时间戳
     * @param nonce     随机数
     * @param echostr   随机字符串
     * @return
     */
    @GetMapping("/comm")
    public String getToken(@RequestParam("signature") String signature,
                           @RequestParam("timestamp") String timestamp,
                           @RequestParam("nonce") String nonce,
                           @RequestParam("echostr") String echostr) {
        if (WechatUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        } else {
            return "";
        }
    }

    /**
     * 此方法用于消息转发
     *
     * @param request
     * @return
     */

    @PostMapping("/comm")
    public void processMsg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO 消息的接收、处理、响应
        //消息来源可靠性验证

        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败
        if (!WechatUtil.checkSignature(signature, timestamp, nonce)) {
            // 消息不可靠，直接返
            response.getWriter().write("");
            System.out.println("check失败");
            return;
        }
        //用户每次向公众号发送消息、或者产生自定义菜单点击事件时，响应URL将得到推送
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/xml");
            // 调用parseXml方法解析请求消息
            Map<String, String> map = wechatService.processRequest(request);
            String msgType = map.get("MsgType");
            //处理输入消息，返回结果的xml
            String xml = null;
            if (MsgTypeParam.REQ_MESSAGE_TYPE_EVENT.equals(msgType)) {
                xml = wechatService.parseEvent(map);
            } else {
                xml = wechatService.parseMessage(map);
            }
            //返回封装的xml
            System.out.println(xml);
            response.getWriter().write(xml);
        } catch (Exception ex) {
            response.getWriter().write("");
        }

    }


    @RequestMapping("/test2")
    @ResponseBody
    public String test2() {
        return "test2";
    }

}