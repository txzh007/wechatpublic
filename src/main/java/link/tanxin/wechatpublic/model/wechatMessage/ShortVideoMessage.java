package link.tanxin.wechatpublic.model.wechatMessage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 微信短视频消息 实体类
 *
 * @author Tan
 * 2019年4月16日 14:32:19
 */
@Getter
@Setter
@ToString
public class ShortVideoMessage {
    private String ToUserName;

    private String FromUserName;

    private long CreateTime;

    private String MsgType;

    private String MediaId;

    private String ThumbMediaId;

    private String MsgId;
}
