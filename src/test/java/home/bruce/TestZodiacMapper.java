package home.bruce;

import home.bruce.bean.Zodiac;
import home.bruce.mapper.ZodiacMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestZodiacMapper {
    private ZodiacMapper mapper;
    private SqlSession sqlSession;

    @Before
    public void getSqlSession() throws IOException {
        InputStream in = Resources.getResourceAsStream("mybatis-map-camel.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession(true);
        mapper = sqlSession.getMapper(ZodiacMapper.class);
    }

    @After
    public void closeSqlSession() {
        sqlSession.close();
    }

    @Test
    public void testCamel() {
        List<Zodiac> zodiacs = mapper.selectAll();
        zodiacs.forEach(System.out::println);
    }

    @Test
    public void testCamelWithResultMap() {
        List<Zodiac> zodiacs = mapper.selectAllWithResultMap();
        zodiacs.forEach(System.out::println);
    }

}
