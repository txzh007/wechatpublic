package link.tanxin.wechatpublic.dao;

import link.tanxin.wechatpublic.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/**
 * UserInfo表数据库操作
 *
 * @author Tand
 * 2019年4月21日 20:20:42
 */


public interface UserInfoResitory extends JpaRepository<UserInfo,Integer> {

    @Query(value = "select * FROM user_info u WHERE id = (SELECT  MAX(id) FROM user_info)", nativeQuery = true)
    List<UserInfo> selectMaxId();
}
