package link.tanxin.wechatpublic.model.wechatmessage;

import lombok.Data;

/**
 * 微信视频消息 实体类
 *
 * @author Tan
 * 2019年4月16日 14:32:07
 */
@Data
public class VideoMessage extends BaseMessage{


    private String mediaId;

    private String title;

    private String thumbMediaId;

    private String msgId;

    private String description;
}
