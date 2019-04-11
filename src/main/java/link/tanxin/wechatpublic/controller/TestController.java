package link.tanxin.wechatpublic.controller;

import link.tanxin.wechatpublic.dao.UserInfoResitory;
import link.tanxin.wechatpublic.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    UserInfoResitory userInfoResitory;

    @GetMapping("/test")
    public List<UserInfo> test() {
        List<UserInfo> list = userInfoResitory.findAll();
        for (UserInfo userInfoEntity : list) {
            System.out.println("this is list");
            System.out.println(userInfoEntity.toString());
        }
        return list;
    }
}
