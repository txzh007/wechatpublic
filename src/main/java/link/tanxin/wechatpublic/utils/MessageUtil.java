package link.tanxin.wechatpublic.utils;


import link.tanxin.wechatpublic.model.wechatMessage.*;

/**
 * MessageUtil 用于发送微信消息的工具类
 *
 * @author Tan
 * 2019年4月15日 10:48:55
 */
public class MessageUtil {
    /**
     * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[news]]></MsgType>
     * <ArticleCount>2</ArticleCount> <Articles> <item>
     * <Title><![CDATA[title1]]></Title>
     * <Description><![CDATA[description1]]></Description>
     * <PicUrl><![CDATA[picurl]]></PicUrl> <Url><![CDATA[url]]></Url> </item>
     * <item> <Title><![CDATA[title]]></Title>
     * <Description><![CDATA[description]]></Description>
     * <PicUrl><![CDATA[picurl]]></PicUrl> <Url><![CDATA[url]]></Url> </item>
     * </Articles> </xml>
     *
     * @param message
     * @return
     * @Title sendImageTextMessage
     * @Description 回复图文消息
     */
    public static String sendImageTextMessage(NewsMessage message) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
        sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + MsgTypeParam.IMAGE_TEXT_MESSAGE + "]]></MsgType>");
        sb.append("<ArticleCount>" + message.getArticleCount() + "</ArticleCount>");
        sb.append("<Articles> ");
        for (Articles article : message.getArticles()) {
            sb.append("<item>");
            if (article.getTitle() != null && article.getTitle() != "") {
                sb.append("<Title><![CDATA[").append(article.getTitle()).append("]]></Title>");
            }
            if (article.getDescription() != null && article.getDescription() != "") {
                sb.append("<Description><![CDATA[").append(article.getDescription()).append("]]></Description>");
            }
            if (article.getPicUrl() != null && article.getPicUrl() != "") {
                sb.append("<PicUrl><![CDATA[").append(article.getPicUrl()).append("]]></PicUrl>");
            }
            if (article.getUrl() != null && article.getUrl() != "") {
                sb.append("<Url><![CDATA[").append(article.getUrl()).append("]]></Url>");
            }
            sb.append("</item>");
        }
        sb.append("</Articles>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[music]]></MsgType>
     * <Music> <Title><![CDATA[TITLE]]></Title>
     * <Description><![CDATA[DESCRIPTION]]></Description>
     * <MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
     * <HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
     * <ThumbMediaId><![CDATA[media_id]]></ThumbMediaId> </Music> </xml>
     *
     * @param message
     * @return
     * @Title sendMusicMessage
     * @Description 回复音乐消息
     */
    public static String sendMusicMessage(MusicMessage message) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
        sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + MsgTypeParam.MUSIC_MESSAGE + "]]></MsgType>");
        sb.append("<Music>");
        if (message.getTitle() != null && !"".equals(message.getTitle())) {
            sb.append("<Title><![CDATA[" + message.getTitle() + "]]></Title>");
        }
        if (message.getDescription() != null && !"".equals(message.getDescription())) {
            sb.append("<Description><![CDATA[" + message.getDescription() + "]]></Description>");
        }
        if (message.getMusicUrl() != null && !"".equals(message.getMusicUrl())) {
            sb.append("<MusicUrl><![CDATA[" + message.getMusicUrl() + "]]></MusicUrl>");
        }
        if (message.getHQMusicUrl() != null && !"".equals(message.getHQMusicUrl())) {
            sb.append("<HQMusicUrl><![CDATA[" + message.getHQMusicUrl() + "]]></HQMusicUrl>");
        }

        sb.append("<ThumbMediaId><![CDATA[" + message.getThumbMediaId() + "]]></ThumbMediaId>");
        sb.append("</Music>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[video]]></MsgType>
     * <Video> <MediaId><![CDATA[media_id]]></MediaId>
     * <Title><![CDATA[title]]></Title>
     * <Description><![CDATA[description]]></Description> </Video> </xml>
     *
     * @param message
     * @return
     * @Title sendVideoMessage
     * @Description 回复视频消息
     */
    public static String sendVideoMessage(VideoMessage message) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
        sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + MsgTypeParam.VIDEO_MESSAGE + "]]></MsgType>");
        sb.append("<Video>");
        sb.append("<MediaId><![CDATA[" + message.getMediaId() + "]]></MediaId>");
        if (message.getTitle() != null && !"".equals(message.getTitle())) {
            sb.append("<Title><![CDATA[" + message.getTitle() + "]]></Title>");
        }
        if (message.getDescription() != null && !"".equals(message.getDescription())) {
            sb.append("<Description><![CDATA[" + message.getDescription() + "]]></Description>");
        }
        sb.append("</Video>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[voice]]></MsgType>
     * <Voice> <MediaId><![CDATA[media_id]]></MediaId> </Voice> </xml>
     *
     * @param message
     * @return
     * @Title sendVoiceMessage
     * @Description 回复语音消息
     */
    public static String sendVoiceMessage(VoiceMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
        sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + MsgTypeParam.VOICE_MESSAGE + "]]></MsgType>");
        sb.append("<Voice>");
        sb.append("<MediaId><![CDATA[" + message.getMediaId() + "]]></MediaId>");
        sb.append("</Voice>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * <xml> <ToUserName><![CDATA[toUser]]></ToUserName>
     * <FromUserName><![CDATA[fromUser]]></FromUserName>
     * <CreateTime>12345678</CreateTime> <MsgType><![CDATA[image]]></MsgType>
     * <Image> <MediaId><![CDATA[media_id]]></MediaId> </Image> </xml>
     *
     * @param message
     * @Title sendImageMessage
     * @Description 回复图片消息
     */
    public static String sendImageMessage(ImageMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
        sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + MsgTypeParam.IMAGE_MESSAGE + "]]></MsgType>");
        sb.append("<Image>");
        sb.append("<MediaId><![CDATA[" + message.getMediaId() + "]]></MediaId>");
        sb.append("</Image>");
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * <xml> <ToUserName>< ![CDATA[toUser] ]></ToUserName> <FromUserName><
     * ![CDATA[fromUser] ]></FromUserName> <CreateTime>12345678</CreateTime>
     * <MsgType>< ![CDATA[text] ]></MsgType> <Content>< ![CDATA[你好] ]></Content>
     * </xml> sendTextMessage
     *
     * @param message
     * @return
     */
    public static String sendTextMessage(TextMessage message) {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>");
        sb.append("<CreateTime>" + message.getCreateTime() + "</CreateTime>");
        sb.append("<MsgType><![CDATA[" + MsgTypeParam.TEXT_MESSAGE + "]]></MsgType>");
        sb.append("<Content><![CDATA[" + message.getContent() + "]]></Content>");
        sb.append("</xml>");
        return sb.toString();
    }

}
