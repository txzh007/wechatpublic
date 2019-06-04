package link.tanxin.wechatpublic.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@ConfigurationProperties(prefix = "spring.mail.imap")
@ToString
public class ImapProperties {


    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    /**
     * IMAP server host. For instance, `imap.exmail.qq.com`.
     */
    private String host;

    /**
     * IMAP server port.
     */
    private Integer port;

    /**
     * Login user of the IMAP server.
     */
//    @Value("${spring.mail.username}")
    private String username;

    /**
     * Login password of the IMAP server.
     */
//    @Value("${spring.mail.password}")
    private String password;

    /**
     * Protocol used by the IMAP server.
     */
    private String protocol = "imap";

    /**
     * Default MimeMessage encoding.
     */
    private Charset defaultEncoding = DEFAULT_CHARSET;

    /**
     * Additional socketFactory properties.
     */
    private Map<String, String> socketFactory = new HashMap<>();

    /**
     * Additional starttls properties.
     */
    private Map<String, String> starttls = new HashMap<>();

    /**
     * Session JNDI name. When set, takes precedence over other Session settings.
     */
    private String jndiName;


}
