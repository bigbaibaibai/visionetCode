package xyz.thishome.phone_sso.service;

import xyz.thishome.phone.pojo.TbUser;

public interface SsoService {

    //通过用户名和密码，获取用户对象
    TbUser getUserForLogin(String username, String password);

    //通过用户名获取用户对象
    TbUser getUserForUsername(String username);

    //传入key，用户对象为值，存入redis中
    void addUserToRedis(String key, TbUser user);

    //添加用户到数据库中
    void registUser(TbUser user);

    //从redis中删除token
    void logoutToRedis(String token);

}
