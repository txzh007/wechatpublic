package link.tanxin.wechatpublic.model.wechatmessage;

import lombok.Data;

/**
 * 微信语音消息 实体类
 *
 * @author Tan
 * 2019年4月16日 14:31:54
 */
@Data
public class VoiceMessage extends BaseMessage {

    private String mediaId;

    private String format;

    private String msgId;


}
