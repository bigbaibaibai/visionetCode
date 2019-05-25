package xyz.thishome.service.impl;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import xyz.thishome.common.utils.RedisOperator;
import xyz.thishome.mapper.UsersMapper;
import xyz.thishome.pojo.Users;
import xyz.thishome.pojo.UsersExample;
import xyz.thishome.pojo.vo.UsersVo;
import xyz.thishome.service.UserService;

import java.io.*;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisOperator redis;

    @Value("${USER_REDIS_SESSION}")
    private String USER_REDIS_SESSION;

    @Value("${USER_REDIS_SESSION_EXPIRE}")
    private Long USER_REDIS_SESSION_EXPIRE;

    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private Sid sid;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean queryUsernameIsExist(String username) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Users> users = usersMapper.selectByExample(usersExample);
        return users != null && users.size() > 0 ? true : false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(Users user) {
        user.setId(sid.nextShort());
        usersMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Users queryForLogin(Users user) {
        //查询该对象
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(user.getPassword());
        List<Users> users = usersMapper.selectByExample(usersExample);
        //如果存在，设置token属性，并添加到redis缓存中去，使用redis做session
        return users != null && users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public UsersVo addToRedisSession(Users user) {
        //创建一个带token的用户对象
        UsersVo usersVo = new UsersVo();
        //把普通的用户对象的属性值赋值到带token属性的对象属性
        //把bean中的属性赋值到目标Bean的属性
        //参数1：原对象   参数2：被赋值对象
        //参数2要有参数1的所有属性对应的get set方法
        BeanUtils.copyProperties(user, usersVo);
        //设置token
        String token = UUID.randomUUID().toString();
        usersVo.setToken(token);
        //添加到缓存中
        redis.set(USER_REDIS_SESSION + ":" + usersVo.getId(), token
                , USER_REDIS_SESSION_EXPIRE);
        return usersVo;
    }

    @Override
    public void delSessionForLogout(String userId) {
        redis.del(USER_REDIS_SESSION + ":" + userId);
    }

    @Value("${FILES_BASICS_PATH}")
    private String FILES_BASICS_PATH;

    @Value("${FACE_PATH}")
    private String FACE_PATH;

    @Override
    public String uploadFace(String userId, MultipartFile[] multipartFiles) {
        //获取头像图片名称
        String filename = multipartFiles[0].getOriginalFilename();
        String uploadPathDB = "/" + userId + FACE_PATH + "/";
        //如果名称不问空
        if (!StringUtils.isBlank(filename)) {
            //构造数据库中存放的相对路径
            uploadPathDB += filename;
        } else {
            return null;
        }
        //构造头像存放磁盘的绝对路径
        String uploadPath = FILES_BASICS_PATH + uploadPathDB;

        //构建file对象
        File outFile = new File(uploadPath);
        //如果文件夹不存在，则先创建文件夹
        if (outFile.getParentFile() != null || !outFile.getParentFile().isDirectory()) {
            outFile.getParentFile().mkdirs();
        }

        FileOutputStream fileOutputStream = null;
        InputStream inputStream = null;

        try {
            fileOutputStream = new FileOutputStream(outFile);
            inputStream = multipartFiles[0].getInputStream();
            IOUtils.copy(inputStream, fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        //根据id修改
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(userId);

        Users user = new Users();
        user.setFaceImage(uploadPathDB);
        usersMapper.updateByExampleSelective(user, example);

        return uploadPathDB;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public UsersVo queryUserForId(String userId) {
        Users user = usersMapper.selectByPrimaryKey(userId);
        UsersVo usersVo = new UsersVo();
        BeanUtils.copyProperties(user,usersVo);
        return usersVo;
    }

}
