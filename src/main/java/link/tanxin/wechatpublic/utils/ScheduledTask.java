package link.tanxin.wechatpublic.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger logger = LoggerFactory.getLogger(ScheduledTask.class);
    private static final String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token";
    static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Value("${wechat.appid}")
    private static String appid;
    @Value("${wechat.appsecret}")
    private static String appsecret;


    @PostConstruct
    @Scheduled(cron = "0 0 0/1 * * ?")  // 秒 分 时 日 月 周几
    /**
     * 每个整点获取一次Token，Token有效期 2小时
     */
    private void timeToGetToken() {

        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put("grant_type", "client_credential");
        map.put("appid", appid);
        map.put("secret", appsecret);
        logger.info(HttpUtils.sendGet(tokenUrl, map, "UTF-8"));
        logger.info(LocalDateTime.now().format(DATETIME_FORMATTER));


    }
}