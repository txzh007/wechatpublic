package link.tanxin.wechatpublic.model.wechatmessage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 微信文本消息 实体类
 *
 * @author Tan
 * 2019年4月15日 10:47:13
 */

@Getter
@Setter
@ToString
public class TextMessage extends BaseMessage {


    private String content;

    private String msgId;


}
