package link.tanxin.wechatpublic.controller;

import link.tanxin.wechatpublic.dao.UserInfoResitory;
import link.tanxin.wechatpublic.utils.TokenUtil;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@Log4j2
@RestController
public class TestController {

    @Autowired
    UserInfoResitory userInfoResitory;

    @GetMapping("/test")
    public void test() {
        String str = TokenUtil.getInstance().getAccessToken();
        log.info("str:" + str);
    }
}
