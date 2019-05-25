package xyz.thishome.elastic;

import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.thishome.elastic.bean.Article;
import xyz.thishome.elastic.bean.Book;
import xyz.thishome.elastic.dao.BookRepository;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03ElasticApplicationTests {

    @Autowired
    private JestClient jestClient;

    @Test
    //存储文档
    public void contextLoads() {
        Article article = new Article(1, "baibai", "好消息", "这是一个好消息");
        //创建一个Builder(构造者)类型(Index的内部类)的对象，传入构造器参数为需要存储的内容
        //调用构造者的index方法设置索引，tyoe方法设置类型，最终build一个Index对象
        Index index = new Index.Builder(article).index("atguigu").type("news").build();
        try {
            //执行索引
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //搜索文档
    public void testSearch() {
        //定义一个查询表达式
        String query = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {   \n" +
                "            \"title\" : \"好消息\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //构建查询对象
        Search search = new Search.Builder(query).addIndex("atguigu").addType("news").build();
        try {
            //搜索
            SearchResult result = jestClient.execute(search);
            String jsonString = result.getJsonString();
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testBookRepository() {
        Book book = new Book(1, "西游记", "唐僧取经的故事");
        //添加索引
        bookRepository.index(book);
    }

    @Test
    public void testQuery() {
        List<Book> xiyouji = bookRepository.findByNameLike("西");
        System.out.println(xiyouji);
    }


}

