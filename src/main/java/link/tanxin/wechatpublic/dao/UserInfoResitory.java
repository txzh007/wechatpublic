package link.tanxin.wechatpublic.dao;

import link.tanxin.wechatpublic.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/**
 * UserInfo表数据库操作
 *
 * @author Tan
 * 2019年4月21日 20:20:42
 */

@RepositoryDefinition(domainClass = UserInfo.class, idClass = Integer.class)
public interface UserInfoResitory {

    @Query(value = "select * FROM user_info u WHERE id = (SELECT  MAX(id) FROM user_info)", nativeQuery = true)
    List<UserInfo> selectMaxId();
}
