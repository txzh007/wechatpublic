package link.tanxin.wechatpublic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/***
 * @author Tan
 * 2019年4月4日 14:00:17
 */

@SpringBootApplication
public class WechatpublicApplication {   // extends SpringBootServletInitializer

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(WechatpublicApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(WechatpublicApplication.class, args);
    }

}
