package link.tanxin.wechatpublic.model.wechatmessage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 基础消息类型
 * ToUserName
 * FromUserName
 * CreateTime
 * MsgType
 *
 * @author Tan
 * 2019年4月21日 15:44:24
 */
@Getter
@Setter
@ToString
public class BaseMessage {

    private String toUserName;

    private String fromUserName;

    private long createTime;

    private String msgType;
}
