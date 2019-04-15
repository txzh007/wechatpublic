package link.tanxin.wechatpublic.model;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 * 微信消息 实体类
 *
 * @author Tan
 * 2019年4月15日 10:47:13
 */

@Getter
@Setter
@JacksonXmlRootElement(localName = "xml")
public class TextMessage {

    @JacksonXmlProperty(localName = "ToUserName")
    private String ToUserName;

    @JacksonXmlProperty(localName = "FromUserName")
    private String FromUserName;

    @JacksonXmlProperty(localName = "Content")
    private String Content;

    @JacksonXmlProperty(localName = "CreateTime")
    private long CreateTime;

    @JacksonXmlProperty(localName = "MsgType")
    private String MsgType;

    @JacksonXmlProperty(localName = "MsgId")
    private String MsgId;


    @Override
    public String toString() {
        return "TextMessage{" +
                "ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime=" + CreateTime +
                ", MsgType='" + MsgType + '\'' +
                ", Content='" + Content + '\'' +
                ", MsgId='" + MsgId + '\'' +
                '}';
    }
}
