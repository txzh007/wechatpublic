package link.tanxin.wechatpublic.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

@SpringBootTest
public class UserInfoResitoryTest {

    @Autowired
    UserInfoResitory userInfoResitory;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void TestSelectMaxId() {
        System.out.println(userInfoResitory.selectMaxId().toString());
    }


}