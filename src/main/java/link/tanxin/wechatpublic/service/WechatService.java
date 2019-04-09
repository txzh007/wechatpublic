package link.tanxin.wechatpublic.service;

public interface WechatService {

    String wechatToken(String signature, String timestamp, String nonce, String echostr);
}
