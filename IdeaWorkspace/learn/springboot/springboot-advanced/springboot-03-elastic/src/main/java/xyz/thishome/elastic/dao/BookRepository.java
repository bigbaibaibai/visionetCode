package xyz.thishome.elastic.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import xyz.thishome.elastic.bean.Book;

import java.util.List;

//用来操作Book类型elasticsearch文档的接口，事项ElasticsearchRepository接口指定两哥泛型
//第一个泛型为操作的java类型，第二个泛型为id字段的类型
public interface BookRepository extends ElasticsearchRepository<Book, Integer> {
    public List<Book> findByNameLike(String name);
}
