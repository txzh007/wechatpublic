package link.tanxin.wechatpublic.model.wechatMessage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 微信图片消息 实体类
 *
 * @author Tan
 * 2019年4月16日 14:33:49
 */
@Getter
@Setter
@ToString
public class ImageMessage {

    private String ToUserName;

    private String FromUserName;

    private long CreateTime;

    private String MsgType;

    private String PicUrl;

    private String MediaId;

    private String MsgId;


}
