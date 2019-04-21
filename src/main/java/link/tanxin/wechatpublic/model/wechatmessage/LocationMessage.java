package link.tanxin.wechatpublic.model.wechatmessage;

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
public class LocationMessage extends BaseMessage{


    private String locationX;

    private String locationY;

    private String scale;

    private String label;

    private String msgId;
}
