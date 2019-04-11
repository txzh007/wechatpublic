package link.tanxin.wechatpublic.dao;

import link.tanxin.wechatpublic.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoResitory extends JpaRepository<UserInfo, Integer> {
}
