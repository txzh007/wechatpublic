package link.tanxin.wechatpublic.dao;

import link.tanxin.wechatpublic.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserInfo表数据库操作
 *
 * @author Tan
 * 2019年4月21日 20:20:42
 */
public interface UserInfoResitory extends JpaRepository<UserInfo, Integer> {
}
