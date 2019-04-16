package link.tanxin.wechatpublic.model.wechatMessage;

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
public class VoiceMessage {

    private String ToUserName;

    private String FromUserName;

    private long CreateTime;

    private String MsgType;

    private String MediaId;

    private String Format;

    private String MsgId;



}
