package link.tanxin.wechatpublic.controller;

import link.tanxin.wechatpublic.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        return wechatService.wechatToken(signature, timestamp, nonce, echostr);

    }



    @PostMapping("/comm")
    public String focused(@RequestParam("signature") String signature,
                          @RequestParam("timestamp") String timestamp,
                          @RequestParam("nonce") String nonce,
                          @RequestParam("openid") String openid) {
        System.out.println("openid:" + openid);

        return "123";

    }


    @RequestMapping("/test2")
    @ResponseBody
    public String test2() {
        return "test2";
    }

}