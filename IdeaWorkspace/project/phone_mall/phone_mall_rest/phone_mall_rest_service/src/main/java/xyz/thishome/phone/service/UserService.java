package xyz.thishome.phone.service;

import xyz.thishome.phone.pojo.TbUser;

public interface UserService {

    //通过token获取用户对象
    TbUser getUserByToken(String token);


    //通过id获取用户对象
    TbUser getUserById(Long userId);


    //更新用户信息
    void updateUser(TbUser user, String token);


}
