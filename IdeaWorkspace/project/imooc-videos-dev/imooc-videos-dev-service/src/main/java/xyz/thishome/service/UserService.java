package xyz.thishome.service;

import org.springframework.web.multipart.MultipartFile;
import xyz.thishome.pojo.Users;
import xyz.thishome.pojo.vo.UsersVo;

public interface UserService {

    /**
     * 判断用户名是否存在
     *
     * @param username
     * @return
     */
    boolean queryUsernameIsExist(String username);

    /**
     * 保存用户
     *
     * @param user
     */
    void saveUser(Users user);

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    Users queryForLogin(Users user);

    /**
     * 添加到缓存中，并返回一个带token的用户对象
     *
     * @param user
     * @return
     */
    UsersVo addToRedisSession(Users user);

    /**
     * 删除session，注销登录
     *
     * @param userId
     */
    void delSessionForLogout(String userId);

    /**
     * 上传用户头像,返回数据库中存储的相对路径
     *
     * @param userId
     * @param multipartFiles
     */
    String uploadFace(String userId, MultipartFile[] multipartFiles);

    /**
     * 通过用户ID查询用户信息
     *
     * @param userId
     * @return
     */
    UsersVo queryUserForId(String userId);
}
