package link.tanxin.wechatpublic.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import link.tanxin.wechatpublic.model.TextMessage;
import link.tanxin.wechatpublic.service.WechatService;
import link.tanxin.wechatpublic.utils.WechatUtil;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStreamReader;

/**
 * WechatService 实现类
 *
 * @author Tan
 * 2019年4月15日 09:32:10
 */
@Service
public class WechatServiceImpl implements WechatService {
    @Override
    public String wechatToken(String signature, String timestamp, String nonce, String echostr) {
        // 将token、timestamp、nonce三个参数进行字典序排序
        String sortString = WechatUtil.sort(timestamp, nonce);
        //将三个参数字符串拼接成一个字符串进行sha1加密
        String myString = WechatUtil.sha1(sortString);

        // 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        if (myString.isEmpty() && !"".equals(myString) && myString.equals(signature)) {
            System.out.println("签名校验通过");
            // 如果检验成功原样返回echostr，微信服务器接收到此输出，才会确认检验完成。
            return echostr;
        } else {
            System.out.println("签名校验失败");
            return "";
        }
    }

    @Override
    public String processRequest(HttpServletRequest request) {
        char[] buf = new char[1024];
        int length;
        StringBuilder builder = new StringBuilder();

        try (InputStreamReader inputStreamReader = new InputStreamReader(request.getInputStream(), "utf-8");) {
            while ((length = inputStreamReader.read(buf)) != -1) {
                builder.append(new String(buf, 0, length));
            }

            System.out.println(builder);
            XmlMapper xmlMapper = new XmlMapper();
            //忽略pojo中不存在的字段
            xmlMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
            TextMessage textMessage = xmlMapper.readValue(builder.toString(), TextMessage.class);

            System.out.println(textMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";

    }
}
