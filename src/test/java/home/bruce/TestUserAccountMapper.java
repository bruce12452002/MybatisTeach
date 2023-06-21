package home.bruce;

import home.bruce.bean.UserAccount;
import home.bruce.mapper.UserAccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUserAccountMapper {
    private UserAccountMapper mapper;
    private SqlSession sqlSession;

    @Before
    public void getSqlSession() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(UserAccountMapper.class);
    }

    @After
    public void closeSqlSession() {
        sqlSession.close();
    }

    @Test
    public void testInsertOne() {
        UserAccount userAccount = new UserAccount();
        userAccount.setName("小雄");
        userAccount.setMoney(35000);
        int result = mapper.insertOne(userAccount);
        System.out.println("插入了幾條=" + result);
        System.out.println(userAccount.getId());
    }

    @Test
    public void testSelectLike() {
        List<UserAccount> userAccounts = mapper.selectLike("小");
        userAccounts.forEach(System.out::println);
    }

    @Test
    public void testReturnMap() {
//        Map<String, Object> map = mapper.returnMap();
//        map.forEach((k, v) -> System.out.println(k + "=" + v));
//        map.forEach((k, v) -> System.out.println(k + "=" + v.getClass()));

        Map<String, Map<String, Object>> map = mapper.returnMap();
        map.forEach((k, v) -> System.out.println(k + " id= " + v.get("id")));
    }

    @Test
    public void testMultiParamWithBean() {
        UserAccount userAccount = new UserAccount();
        userAccount.setId(1);
        userAccount.setName("小明");
        UserAccount ua = mapper.selectByBean(userAccount); // 此行斷點後 step into 看源碼：MapperProxy.invoke -> cachedInvoker.invoker -> PlainMethodInvoker.invoke -> execute
        System.out.println(ua.getName());
    }

    @Test
    public void testMultiParamWithMap() {
        HashMap<String, Object> map = new HashMap<>() {{
            put("xxx", 1);
            put("ooo", "小明");
        }};
        UserAccount ua = mapper.selectByMap(map);
        System.out.println(ua.getName());
    }

    @Test
    public void testMultiParam() {
        UserAccount ua = mapper.selectByIdAndName(1, "小明");
        System.out.println(ua.getName());
    }

    @Test
    public void testUserAccount() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        UserAccountMapper mapper;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) { // openSession(true) 可以自動提交
            mapper = sqlSession.getMapper(UserAccountMapper.class);

            mapper.selectAll().forEach(System.out::println);

//        UserAccount userAccount = mapper.selectById(2);
//        System.out.println(userAccount.getName() + "=" + userAccount.getMoney());

//        session.commit(); // 增刪改才需要
        }

    }
}
