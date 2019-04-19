package link.tanxin.wechatpublic.model.wechatMessage;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MusicMessage {
    private String ToUserName;

    private String FromUserName;

    private long CreateTime;

    private String MsgType;

    private String HQMusicUrl;

    private String Title;

    private String MusicUrl;

    private String ThumbMediaId;

    private String Description;


}
