package link.tanxin.wechatpublic.model.wechatMessage;


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

public class LinkMessage {

    private String ToUserName;

    private String FromUserName;

    private long CreateTime;

    private String MsgType;

    private String Title;

    private String Description;

    private String Url;

    private String MsgId;
}
