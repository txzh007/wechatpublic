package link.tanxin.wechatpublic.model.wechatMessage;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class NewsMessage {

    private String ToUserName;

    private String FromUserName;

    private long CreateTime;

    private String MsgType;

    private int ArticleCount;

    private List<Articles> articles = new ArrayList<>(ArticleCount);

    private String MsgId;


}
