package link.tanxin.wechatpublic.utils;

import link.tanxin.wechatpublic.model.TextMessage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MessageUtil 用于处理微信消息的工具类
 *
 * @author Tan
 * 2019年4月15日 10:48:55
 */
public class MessageUtil {

    /**
     * xml转换成Map
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        request.setCharacterEncoding("UTF-8");

        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();

        InputStream ins = request.getInputStream();
        Document doc = reader.read(ins);

        Element root = doc.getRootElement();

        List<Element> list = root.elements();

        for (Element e : list) {
            map.put(e.getName(), e.getText());
        }
        ins.close();
        return map;
    }

//    /**
//     * text转换成xml
//     */
//    public static String textMessageToXml(TextMessage textMessage) {
//        XStream xstream = new XStream();
//        xstream.alias("xml", textMessage.getClass());
//        return xstream.toXML(textMessage);
//    }

}
