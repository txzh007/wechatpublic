package link.tanxin.wechatpublic.utils;

import java.util.UUID;

/**
 * UUID工具类
 *
 * @author Tan
 * 2019年4月11日 17:13:02
 */
public class UUIDUtil {
    /**
     * 获取UUID
     * @return 32位UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
