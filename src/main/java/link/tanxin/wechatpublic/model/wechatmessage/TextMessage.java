package link.tanxin.wechatpublic.model.wechatmessage;

import lombok.Data;
/**
 * 微信文本消息 实体类
 *
 * @author Tan
 * 2019年4月15日 10:47:13
 */

@Data
public class TextMessage extends BaseMessage {


    private String content;

    private String msgId;


}
