package xyz.thishome.hotel.service;

import xyz.thishome.hotel.pojo.User;

import java.util.List;

/**
 * 用户相关的service
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 通过用户名获取用户
     *
     * @param user
     * @return
     */
    User getUser(String username);

    /**
     * 保存对象到数据库中
     *
     * @param user
     * @return
     */
    User saveUser(User user);

    /**
     * 用户删除
     *
     * @return
     */
    void delete(Integer userId);

    /**
     * 用户信息修改
     *
     * @param user
     * @return
     */
    User edit(User user);

    /**
     * 通过身份证获取用户
     *
     * @param idCard
     * @return
     */
    User getUser(Integer idCard);

    /**
     * 获取所有用户
     *
     * @return
     */
    List<User> getUserList();
}
