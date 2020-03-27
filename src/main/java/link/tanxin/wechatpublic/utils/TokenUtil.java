package link.tanxin.wechatpublic.utils;

public class TokenUtil {


    private String accessToken;

    // 过期时间
    private Long expiryTime;

    private static TokenUtil token = new TokenUtil();

    private TokenUtil() {
    }

    // 单例创建实体类
    public static TokenUtil getInstance() {
        //如果过期时间为空,那么立即从微信获取accessToken
        if (null == token.expiryTime) {
            init();
        } else {
            //过期时间不为空 判断当前时间 >= 过期时间
            //即accseeToken已经过期 重新从微信获取
            if (System.currentTimeMillis() >= token.expiryTime) {
                init();
            }
        }
        return token;
    }

    /**
     * 初始化
     */
    private static void init() {
        //请求微信服务器获取accseeToken

        token.accessToken = WechatUtil.getAccessToken();
        //过期时间的毫秒数 100分钟后过期 微信文档的过期时间为120分钟 我们提前20分钟叫它过期
        token.expiryTime = System.currentTimeMillis() + 1000 * 60 * 100L;
    }

    public String getAccessToken() {
        return accessToken;
    }


}
