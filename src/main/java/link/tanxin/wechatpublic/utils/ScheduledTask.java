package link.tanxin.wechatpublic.utils;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Configuration      //主要用于标记配置类，兼备Component的效果。
@EnableScheduling   //开启定时任务
public class ScheduledTask {
    final String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token";

    @PostConstruct
    //添加定时任务
    @Scheduled(cron = "0 0/90 * * * ?")  // 秒 分 时 日 月 周几
    private void timeToGetToken() {
        Map<String, Object> map = new HashMap<String, Object>(3);
        map.put("grant_type", "client_credential");
        map.put("appid", "wxbdc9e3e2a67f8d8e");
        map.put("secret", "63dff4b49392404865a3f54750636fa2");

        System.out.println("***********************************");
        System.out.println(HttpUtils.sendGet(tokenUrl, map, "UTF-8"));
        System.out.println(LocalTime.now());

    }
}