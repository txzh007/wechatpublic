package link.tanxin.wechatpublic.utils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.Map;

public class XmlUtil {

    public static String xmlFormat(Map<String, String> map) {
        XmlMapper xmlMapper = new XmlMapper();
        String xmlStr = "";
        try {
            xmlStr = xmlMapper.writeValueAsString(map);
            xmlStr = xmlStr.replaceFirst("<HashMap>", "<xml>").replace("</HashMap>", "<xml>");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlStr;
    }

    public static String xmlFormat(Object object) {
        XmlMapper xmlMapper = new XmlMapper();
        String xmlStr = "";
        try {
            xmlStr = xmlMapper.writeValueAsString(object);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlStr;
    }
}
