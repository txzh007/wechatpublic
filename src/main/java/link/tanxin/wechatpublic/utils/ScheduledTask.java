package link.tanxin.wechatpublic.utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * 定时任务工具类
 *
 * @author Tan
 * 2019年4月11日 15:41:17
 */
@Component
@Configuration
@EnableScheduling
public class ScheduledTask {

    final String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token";
    static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Value("${wechat.appid}")
    private String appid;
    @Value("${wechat.appsecret}")
    private String appsecret;

    /**
     * 每90分钟获取一次Token，Token有效期 2小时
     */
    @PostConstruct
    @Scheduled(cron = "0 0/30 * * * ?")  // 秒 分 时 日 月 周几
    private void timeToGetToken() {

        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put("grant_type", "client_credential");
        map.put("appid", appid);
        map.put("secret", appsecret);
        System.out.println("appid:" + appid);
        System.out.println("***********************************");
        System.out.println(HttpUtils.sendGet(tokenUrl, map, "UTF-8"));
        System.out.println(LocalDateTime.now().format(DATETIME_FORMATTER));


    }
}