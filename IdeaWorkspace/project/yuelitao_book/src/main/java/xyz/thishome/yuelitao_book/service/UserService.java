package xyz.thishome.yuelitao_book.service;

import xyz.thishome.yuelitao_book.pojo.UserAccount;
import xyz.thishome.yuelitao_book.pojo.UserAddress;

public interface UserService {

    //添加一个地址
    void addAddress(Integer userId, String address);

    //通过用户名获取对象
    UserAccount getUserForUsername(String username);

    //通过用户名密码查询对象
    UserAccount getUserForLogin(String username, String password);

    //通过id获取对象
    UserAccount getUesrForId(Integer id);

    //添加一个用户
    UserAccount addUser(UserAccount userAccount);

    //把用户存到redis中，key由token生成
    void addToeknToRedis(String token, UserAccount userAccount);

    //使用token从redis中获取一个用户对象
    UserAccount getUserFromRedisByToken(String token);

    //删除一个用户
    void delUser(Integer userId);

    //用户信息更新
    void updateUser(UserAccount userAccount);

    //重新设置token过期时间
    void resetTokenExpire(String token);

    //删除token
    void delTokenFromRedis(String token);

    //获取用户地址
    UserAddress getUserAddress(Integer userId);
}
