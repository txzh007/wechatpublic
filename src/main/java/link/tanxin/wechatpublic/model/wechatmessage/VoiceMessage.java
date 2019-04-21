package link.tanxin.wechatpublic.model.wechatmessage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 微信语音消息 实体类
 *
 * @author Tan
 * 2019年4月16日 14:31:54
 */
@Getter
@Setter
@ToString
public class VoiceMessage extends BaseMessage {

    private String mediaId;

    private String format;

    private String msgId;


}
