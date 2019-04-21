package link.tanxin.wechatpublic.model.wechatmessage;

import lombok.Data;

/**
 * 音乐消息实体类
 *
 * @author Tan
 * 2019年4月21日 15:49:21
 */
@Data
public class  MusicMessage extends BaseMessage {


    private String hqMusicUrl;

    private String title;

    private String musicUrl;

    private String thumbMediaId;

    private String description;


}
