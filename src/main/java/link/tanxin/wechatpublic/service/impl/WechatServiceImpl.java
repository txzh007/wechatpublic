package link.tanxin.wechatpublic.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import link.tanxin.wechatpublic.dao.UserInfoResitory;
import link.tanxin.wechatpublic.model.UserInfo;
import link.tanxin.wechatpublic.model.wechatmessage.Articles;
import link.tanxin.wechatpublic.model.wechatmessage.NewsMessage;
import link.tanxin.wechatpublic.model.wechatmessage.TextMessage;
import link.tanxin.wechatpublic.service.WechatService;
import link.tanxin.wechatpublic.utils.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WechatService 实现类
 *
 * @author Tan
 * 2019年4月15日 09:32:10
 */
@Log4j2
@Service
public class WechatServiceImpl implements WechatService {
    @Autowired
    UserInfoResitory userInfoResitory;


    private final static String INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info";

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, String> processRequest(HttpServletRequest request) {
        char[] buf = new char[1024];
        int length;
        StringBuilder builder = new StringBuilder();
        Map<String, String> map = null;
        try (InputStreamReader inputStreamReader = new InputStreamReader(request.getInputStream(), "utf-8")) {
            while ((length = inputStreamReader.read(buf)) != -1) {
                builder.append(new String(buf, 0, length));
            }
            ObjectMapper xmlMapper = new XmlMapper();
            //忽略pojo中不存在的字段
            xmlMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
            map = xmlMapper.readValue(builder.toString(), HashMap.class);
            log.info(map.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;

    }

    @Override
    public String parseEvent(Map<String, String> map) {
        StringBuilder respXml = new StringBuilder("");
        try {
            // 发送方帐号
            String fromUserName = map.get("FromUserName");
            // 开发者微信号
            String toUserName = map.get("ToUserName");
            // 取得消息类型
            String msgType = map.get("MsgType");
            //获取事件类型
            String eventType = map.get("Event");


            if (eventType.equals(MsgTypeParam.EVENT_TYPE_SUBSCRIBE)) {
                // 关注
                TextMessage textMessage = new TextMessage();
                textMessage.setFromUserName(toUserName);
                textMessage.setToUserName(fromUserName);
                textMessage.setCreateTime(System.currentTimeMillis());
                textMessage.setMsgType(MsgTypeParam.RESP_MESSAGE_TYPE_TEXT);
                textMessage.setContent("Welcome, my friend!");
                UserInfo userInfo = new UserInfo();
                userInfo.setId(UUIDUtil.getUUID());
                userInfo.setOpenid(fromUserName);
                subscribe(fromUserName);
                respXml.append(MessageUtil.sendTextMessage(textMessage));
            } else if (eventType.equals(MsgTypeParam.EVENT_TYPE_UNSUBSCRIBE)) {
                // 取消关注 删除用户信息？
            } else if (eventType.equals(MsgTypeParam.EVENT_TYPE_SCAN)) {
                // 用户已关注时的扫描带参数二维码

            } else if (eventType.equals(MsgTypeParam.EVENT_TYPE_LOCATION)) {
                // 上报地理位置

            } else if (eventType.equals(MsgTypeParam.EVENT_TYPE_CLICK)) {
                // 自定义菜单

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml.toString();

    }

    @Override
    public String parseMessage(Map<String, String> map) {
        // 处理微信发来的请求 map 消息业务处理分发
        StringBuilder respXml = new StringBuilder("");
        try {
            // 发送方帐号
            String fromUserName = map.get("FromUserName");
            // 开发者微信号
            String toUserName = map.get("ToUserName");
            // 取得消息类型
            String msgType = map.get("MsgType");
            // 发现直接把要返回的信息直接封装成replyMap集合，然后转换成 xml文件，是不是实体类可以不用了
            TextMessage textMessage;
            switch (msgType) {
                case MsgTypeParam.TEXT_MESSAGE:
                    // 封装文本返回消息
                    textMessage = new TextMessage();
                    textMessage.setMsgType(MsgTypeParam.RESP_MESSAGE_TYPE_TEXT);
                    textMessage.setToUserName(fromUserName);
                    textMessage.setFromUserName(toUserName);
                    textMessage.setCreateTime(System.currentTimeMillis());
                    textMessage.setContent("您发送的是文本消息");

                    respXml.append(MessageUtil.sendTextMessage(textMessage));
                    break;
                case MsgTypeParam.IMAGE_MESSAGE:
                    System.out.println("图文消息：" + map.toString());
                    // 这里回复图片 或者图文消息 以图文消息为例
                    NewsMessage message = new NewsMessage();
                    message.setToUserName(fromUserName);
                    message.setFromUserName(toUserName);
                    message.setCreateTime(System.currentTimeMillis());
                    message.setMsgType(MsgTypeParam.RESP_MESSAGE_TYPE_NEWS);

                    Articles article = new Articles();
                    // 图文消息的描述
                    article.setDescription("图文消息 ");
                    // 图文消息图片地址
                    article.setPicUrl(map.get("PicUrl"));
                    // 图文消息标题
                    article.setTitle("图文消息 ");
                    // 图文 url 链接
                    article.setUrl("http://www.baidu.com");
                    List<Articles> list = new ArrayList<>();
                    // 这里发送的是单图文，如果需要发送多图文则在这里 list 中加入多个
                    list.add(article);
                    // Articles！

                    message.setArticleCount(list.size());
                    message.setArticles(list);
                    respXml.append(MessageUtil.sendImageTextMessage(message));
                    break;
                case MsgTypeParam.VOICE_MESSAGE:
                    /* 以下方式根据需要来操作 */
                    textMessage = new TextMessage();
                    textMessage.setMsgType(MsgTypeParam.RESP_MESSAGE_TYPE_TEXT);
                    textMessage.setToUserName(fromUserName);
                    textMessage.setFromUserName(toUserName);
                    textMessage.setCreateTime(System.currentTimeMillis());
                    textMessage.setContent("您发送的是语音消息");
                    respXml.append(MessageUtil.sendTextMessage(textMessage));
                    break;
                case MsgTypeParam.VIDEO_MESSAGE:
                    textMessage = new TextMessage();
                    textMessage.setMsgType(MsgTypeParam.RESP_MESSAGE_TYPE_TEXT);
                    textMessage.setToUserName(fromUserName);
                    textMessage.setFromUserName(toUserName);
                    textMessage.setCreateTime(System.currentTimeMillis());
                    textMessage.setContent("您发送的是视频");

                    respXml.append(MessageUtil.sendTextMessage(textMessage));
                    break;
                case MsgTypeParam.SHORTVIDEO_MESSAGE:

                    textMessage = new TextMessage();
                    textMessage.setMsgType(MsgTypeParam.RESP_MESSAGE_TYPE_TEXT);
                    textMessage.setToUserName(fromUserName);
                    textMessage.setFromUserName(toUserName);
                    textMessage.setCreateTime(System.currentTimeMillis());
                    textMessage.setContent("您发送的是小视频");

                    respXml.append(MessageUtil.sendTextMessage(textMessage));
                    break;
                case MsgTypeParam.POSOTION_MESSAGE:
                    textMessage = new TextMessage();
                    textMessage.setMsgType(MsgTypeParam.RESP_MESSAGE_TYPE_TEXT);
                    textMessage.setToUserName(fromUserName);
                    textMessage.setFromUserName(toUserName);
                    textMessage.setCreateTime(System.currentTimeMillis());
                    textMessage.setContent("您发送的是地理位置");

                    respXml.append(MessageUtil.sendTextMessage(textMessage));
                    break;
                case MsgTypeParam.LINK_MESSAGE:
                    textMessage = new TextMessage();
                    textMessage.setMsgType(MsgTypeParam.RESP_MESSAGE_TYPE_TEXT);
                    textMessage.setToUserName(fromUserName);
                    textMessage.setFromUserName(toUserName);
                    textMessage.setCreateTime(System.currentTimeMillis());
                    textMessage.setContent("您发送的是链接消息");


                    respXml.append(MessageUtil.sendTextMessage(textMessage));
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return respXml.toString();
    }

    /**
     * 关注公众号操作
     *
     * @param openid 用户openid
     */
    private void subscribe(String openid) {
        Map<String, String> param = new HashMap(3);
        param.put("openid", openid);
        param.put("access_token", WechatUtil.getAccessToken());
        param.put("lang", "zh_CN");

        String res = HttpUtils.sendGet(INFO_URL, param, "utf-8");
        log.info("res:" + res);
        try {
            ObjectMapper mapper = new ObjectMapper();

            //设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            UserInfo userInfo = mapper.readValue(res, UserInfo.class);
            userInfo.setId(UUIDUtil.getUUID());
            userInfoResitory.save(userInfo);
        } catch (Exception e) {
            log.error(e.getMessage());
        }


    }
}
