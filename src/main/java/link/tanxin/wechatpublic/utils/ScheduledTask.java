package link.tanxin.wechatpublic.utils;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;


import java.time.format.DateTimeFormatter;

import java.util.HashMap;
import java.util.Map;


/**
 * 定时任务工具类
 *
 * @author Tan
 * 2019年4月11日 15:41:17
 */
@Log4j2
@Component
@Configuration
@EnableScheduling
public class ScheduledTask {
    private static final String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Value("${wechat.appid}")
    private String appId;
    @Value("${wechat.appsecret}")
    private String appSecret;


    @PostConstruct
    @Scheduled(cron = "0 0 0/1 * * ?")  // 秒 分 时 日 月 周几
    /**
     * 每个整点获取一次Token，Token有效期 2小时
     */
    private void timeToGetToken() {
        System.out.println("appid:" + appId);
        System.out.println("appsecret:" + appSecret);
        Map<String, Object> map = new HashMap<>(3);
        map.put("grant_type", "client_credential");
        map.put("appid", appId);
        map.put("secret", appSecret);
        log.info(HttpUtils.sendGet(TOKEN_URL, map, "UTF-8"));
        log.info(LocalDateTime.now().format(DATETIME_FORMATTER));


    }
}