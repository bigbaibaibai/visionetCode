package xyz.thishome;

import com.google.gson.Gson;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import xyz.thishome.bean.T_MALL_CLASS_1;
import xyz.thishome.bean.T_MALL_CLASS_2;
import xyz.thishome.bean.T_MALL_TRADE_MARK;
import xyz.thishome.mapper.T_MALL_CLASS_1_mapper;
import xyz.thishome.mapper.T_MALL_CLASS_2_mapper;
import xyz.thishome.mapper.T_MALL_TRADE_MARK_mapper;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class MybatisTest {

    @Test
    public void testGetClass1() throws Exception {
        //获取sqlSession对象
        SqlSession session = getSqlSession();
        T_MALL_CLASS_1_mapper mapper = session.getMapper(T_MALL_CLASS_1_mapper.class);
        List<T_MALL_CLASS_1> list = mapper.getlist();

        //输出成json文件到本地目录
        objToJsonToFile(list, "E:/file/class_1.js");

        //遍历分类列表1，通过分类1的Id获取相应的分类2列表，和商标表
        T_MALL_CLASS_2_mapper class_2_mapper = session.getMapper(T_MALL_CLASS_2_mapper.class);
        T_MALL_TRADE_MARK_mapper mall_trade_mark_mapper = session.getMapper(T_MALL_TRADE_MARK_mapper.class);

        for (T_MALL_CLASS_1 t_mall_class_1 : list) {
            int class_1Id = t_mall_class_1.getId();
            List<T_MALL_CLASS_2> listForClass1Id = class_2_mapper.getListForClass1Id(class_1Id);
            List<T_MALL_TRADE_MARK> ppListForFlId = mall_trade_mark_mapper.getPPListForFlId(class_1Id);
            //输出成json文件
            objToJsonToFile(listForClass1Id, "E:/file/class_2_" + class_1Id + ".js");
            objToJsonToFile(ppListForFlId, "E:/file/tm_class_1_" + class_1Id + ".js");
        }

        session.close();

    }

    private Gson gson = new Gson();

    private void objToJsonToFile(Object obj, String file) throws Exception {
        //将数据转化为json
        String json = gson.toJson(obj);
        //json字符串转化为静态文件
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(json.getBytes("UTF-8"));
        outputStream.flush();
        outputStream.close();
    }

    @Test
    public void testGetClass2() throws Exception {

    }


    private SqlSession getSqlSession() throws Exception {
        //获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取数据
        return sqlSessionFactory.openSession();
    }


}
