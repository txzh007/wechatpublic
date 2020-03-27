package link.tanxin.wechatpublic.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信公众号相关操作工具类
 *
 * @author Tan
 * 2019年4月11日 15:39:25
 */

@Component
@Log4j2
public class WechatUtil {

    private static final String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    @Value("${wechat.appid}")
    private String appId;
    @Value("${wechat.appsecret}")
    private String appSecret;

    private static String appid = "";
    private static String appsecret = "";


    @PostConstruct
    public void initAppid() {
        appid = this.appId;
        appsecret = this.appSecret;
    }

    private final static String TOKEN = "wechatdemotest";

    private static String sort(String timestamp, String nonce) {
        String[] strArray = {TOKEN, timestamp, nonce};
        Arrays.sort(strArray);
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str);
        }

        return sb.toString();
    }

    private static String sha1(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            byte[] messageDigest = digest.digest();
            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            // 字节数组转换为 十六进制 数
            for (byte u : messageDigest) {
                String shaHex = Integer.toHexString(u & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        // 将token、timestamp、nonce三个参数进行字典序排序
        String sortString = sort(timestamp, nonce);
        //将三个参数字符串拼接成一个字符串进行sha1加密
        String myString = sha1(sortString);
        return signature.equals(myString);
    }

    public static String getAccessToken() {
        Map<String, String> map = new HashMap<>(3);
        map.put("grant_type", "client_credential");
        map.put("appid", appid);
        map.put("secret", appsecret);


        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(HttpUtils.sendGet(TOKEN_URL, map, "utf-8"));
            String accessToken = node.get("access_token").toString().replaceAll("\"", "");
            log.info("token:" + accessToken);
            return accessToken;

        } catch (Exception e) {

            log.error("Token 获取失败\n" + e.getMessage());

        } finally {

        }

        return "";


    }
}
