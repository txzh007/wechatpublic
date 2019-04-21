package link.tanxin.wechatpublic.model.wechatmessage;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 图文消息实体类
 *
 * @author Tan
 * 2019年4月21日 15:50:21
 */
@Data
public class NewsMessage extends BaseMessage {


    private int articleCount;

    private List<Articles> articles = new ArrayList<>(articleCount);

    private String msgId;


}
