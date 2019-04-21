package link.tanxin.wechatpublic.model.wechatmessage;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 微信链接消息 实体类
 *
 * @author Tan
 * 2019年4月16日 14:33:30
 */
@Getter
@Setter
@ToString

public class LinkMessage extends BaseMessage {


    private String title;

    private String description;

    private String url;

    private String msgId;
}
