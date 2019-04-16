package link.tanxin.wechatpublic.model.wechatMessage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 微信视频消息 实体类
 *
 * @author Tan
 * 2019年4月16日 14:32:07
 */
@Setter
@Getter
@ToString
public class VideoMessage {

    private String ToUserName;

    private String FromUserName;

    private long CreateTime;

    private String MsgType;

    private String MediaId;

    private String ThumbMediaId;

    private String MsgId;
}
