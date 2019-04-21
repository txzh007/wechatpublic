package link.tanxin.wechatpublic.model.wechatmessage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 微信文章实体类
 *
 * @author Tan
 * 2019年4月21日 15:39:52
 */
@Getter
@Setter
@ToString
public class Articles {

    private String articles;
    private String title;
    private String description;
    private String picUrl;
    private String url;
}
