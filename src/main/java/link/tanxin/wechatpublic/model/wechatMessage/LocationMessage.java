package link.tanxin.wechatpublic.model.wechatMessage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 微信地理位置消息 实体类
 *
 * @author Tan
 * 2019年4月16日 14:33:04
 */
@Getter
@Setter
@ToString

public class LocationMessage {

    private String ToUserName;

    private String FromUserName;

    private long CreateTime;

    private String MsgType;

    private String Location_X;

    private String Location_Y;

    private String Scale;

    private String Label;

    private String MsgId;
}
