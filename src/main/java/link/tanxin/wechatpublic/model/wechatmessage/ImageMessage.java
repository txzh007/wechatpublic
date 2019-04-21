package link.tanxin.wechatpublic.model.wechatmessage;

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
public class ImageMessage extends BaseMessage {


    private String picUrl;

    private String mediaId;

    private String msgId;


}
