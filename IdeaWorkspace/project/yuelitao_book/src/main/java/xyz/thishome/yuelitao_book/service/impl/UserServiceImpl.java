package xyz.thishome.yuelitao_book.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.yuelitao_book.mapper.UserAccountMapper;
import xyz.thishome.yuelitao_book.mapper.UserAddressMapper;
import xyz.thishome.yuelitao_book.pojo.UserAccount;
import xyz.thishome.yuelitao_book.pojo.UserAccountExample;
import xyz.thishome.yuelitao_book.pojo.UserAddress;
import xyz.thishome.yuelitao_book.pojo.UserAddressExample;
import xyz.thishome.yuelitao_book.service.UserService;
import xyz.thishome.yuelitao_book.util.JsonUtils;
import xyz.thishome.yuelitao_book.util.MD5Utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Value("${USER_TOKEN_REDIS_KEY}")
    private String USER_TOKEN_REDIS_KEY;

    @Value("${TOKEN_REDIS_EXPIRE_TIME}")
    private Integer TOKEN_REDIS_EXPIRE_TIME;

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addAddress(Integer userId, String address) {
        UserAccount userAccount = userAccountMapper.selectByPrimaryKey(userId);
        UserAddress userAddress = new UserAddress();
        userAddress.setYhId(userId);
        userAddress.setDzMch(address);
        userAddress.setDzzt(0);
        userAddress.setLxfsh(userAccount.getYhShjh());
        userAddress.setShjr(userAccount.getYhXm());
        userAddressMapper.insertSelective(userAddress);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public UserAccount getUserForUsername(String username) {
        return getUserForLogin(username, null);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public UserAccount getUserForLogin(String username, String password) {
        //构建条件
        UserAccountExample example = new UserAccountExample();
        UserAccountExample.Criteria criteria = example.createCriteria();
        criteria.andYhMchEqualTo(username);
        if (password != null) {
            try {
                password = MD5Utils.getMD5Str(password);
            } catch (Exception e) {
                e.printStackTrace();
            }
            criteria.andYhMmEqualTo(password);
        }
        //按条件查询用户
        List<UserAccount> userAccounts = userAccountMapper.selectByExample(example);
        if (userAccounts != null && userAccounts.size() > 0) {
            //把密码置空
            UserAccount userAccount = userAccounts.get(0);
            userAccount.setYhMm(null);
            return userAccount;
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public UserAccount getUesrForId(Integer id) {
        UserAccount userAccount = userAccountMapper.selectByPrimaryKey(id);
        //密码置空
        userAccount.setYhMm(null);
        return userAccount;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UserAccount addUser(UserAccount userAccount) {
        try {
            //对密码进行MD5加密
            userAccount.setYhMm(MD5Utils.getMD5Str(userAccount.getYhMm()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果昵称为空，把用户名设置为昵称
        if (StringUtils.isBlank(userAccount.getYhMch())) {
            userAccount.setYhNch(userAccount.getYhMch());
        }
        userAccountMapper.insertSelective(userAccount);
        userAccount.setYhMm(null);
        return userAccount;
    }

    @Autowired
    private RedisTemplate jsonRedisTemplate;

    @Override
    public void addToeknToRedis(String token, UserAccount userAccount) {
        //把用户信息设置到redis中
        ValueOperations<String, String> valueOperations = jsonRedisTemplate.opsForValue();
        valueOperations.set(USER_TOKEN_REDIS_KEY + ":" + token, JsonUtils.objectToJson(userAccount));
        //设置token过期时间
        resetTokenExpire(token);
    }

    @Override
    public UserAccount getUserFromRedisByToken(String token) {
        ValueOperations<String, String> valueOperations = jsonRedisTemplate.opsForValue();
        String json = valueOperations.get(USER_TOKEN_REDIS_KEY + ":" + token);
        if (!StringUtils.isBlank(json)) {
            UserAccount userAccount = JsonUtils.jsonToPojo(json, UserAccount.class);
            resetTokenExpire(token);
            return userAccount;
        }
        return null;
    }

    //重新设置token过期时间
    public void resetTokenExpire(String token) {
        //设置token过期时间
        jsonRedisTemplate.expire(USER_TOKEN_REDIS_KEY + ":" + token, TOKEN_REDIS_EXPIRE_TIME, TimeUnit.MINUTES);
    }

    @Override
    public void delTokenFromRedis(String token) {
        jsonRedisTemplate.expire(USER_TOKEN_REDIS_KEY + ":" + token, 0, TimeUnit.SECONDS);
    }


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public UserAddress getUserAddress(Integer userId) {
        //查询用户地址
        UserAddressExample example = new UserAddressExample();
        UserAddressExample.Criteria criteria = example.createCriteria();
        criteria.andYhIdEqualTo(userId);
        List<UserAddress> addresses = userAddressMapper.selectByExample(example);
        if (addresses != null && addresses.size() > 0) {
            return addresses.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delUser(Integer userId) {
        userAccountMapper.deleteByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(UserAccount userAccount) {
        //如果需要修改密码， 对其进行Md5加密
        if (!StringUtils.isBlank(userAccount.getYhMm())) {
            try {
                userAccount.setYhMm(MD5Utils.getMD5Str(userAccount.getYhMm()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        userAccountMapper.updateByPrimaryKeySelective(userAccount);
    }
}
