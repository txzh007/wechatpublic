package link.tanxin.wechatpublic.model.wechatmessage;


import lombok.Data;

/**
 * 微信短视频消息 实体类
 *
 * @author Tan
 * 2019年4月16日 14:32:19
 */
@Data
public class ShortVideoMessage extends BaseMessage{

    private String mediaId;

    private String thumbMediaId;

    private String msgId;
}
