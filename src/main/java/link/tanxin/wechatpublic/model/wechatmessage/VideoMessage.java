package link.tanxin.wechatpublic.model.wechatmessage;

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
public class VideoMessage extends BaseMessage{


    private String mediaId;

    private String title;

    private String thumbMediaId;

    private String msgId;

    private String description;
}
