package link.tanxin.wechatpublic.model.wechatmessage;

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
public class ShortVideoMessage extends BaseMessage{

    private String mediaId;

    private String thumbMediaId;

    private String msgId;
}
