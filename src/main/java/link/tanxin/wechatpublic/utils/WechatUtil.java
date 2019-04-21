package link.tanxin.wechatpublic.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 微信公众号相关操作工具类
 *
 * @author Tan
 * 2019年4月11日 15:39:25
 */
public class WechatUtil {

    public final static String TOKEN = "wechatdemotest";

    public static String sort(String timestamp, String nonce) {
        String[] strArray = {TOKEN, timestamp, nonce};
        Arrays.sort(strArray);
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str);
        }

        return sb.toString();
    }

    public static String sha1(String str) {
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
}
