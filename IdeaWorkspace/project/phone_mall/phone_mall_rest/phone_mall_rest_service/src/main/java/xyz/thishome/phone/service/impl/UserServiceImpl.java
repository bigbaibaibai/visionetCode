package xyz.thishome.phone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.common.utils.JsonUtils;
import xyz.thishome.phone.mapper.TbUserMapper;
import xyz.thishome.phone.pojo.TbUser;
import xyz.thishome.phone.service.UserService;
import xyz.thishome.util.RedisUtil;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private TbUserMapper userMapper;
    @Value("${SSO_TOKEN}")
    private String SSO_TOKEN;
    @Value("${SSO_EXPIRE_TIME}")
    private Long SSO_EXPIRE_TIME;

    @Override
    public TbUser getUserByToken(String token) {
        String json = redisUtil.get(SSO_TOKEN + ":" + token);
        if (json == null) {
            return null;
        }
        redisUtil.expire(SSO_TOKEN + ":" + token,SSO_EXPIRE_TIME);
        TbUser tbUser = JsonUtils.jsonToPojo(json, TbUser.class);
        return tbUser;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TbUser getUserById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(TbUser user, String token) {
        TbUser userByToken = getUserByToken(token);
        if (user.getId() == null) {
            user.setId(userByToken.getId());
        }
        user.setUpdated(new Date());
        userMapper.updateByPrimaryKeySelective(user);

        TbUser tbUser = userMapper.selectByPrimaryKey(user.getId());
        tbUser.setPassword(null);
        redisUtil.set(SSO_TOKEN + ":" + token, JsonUtils.objectToJson(tbUser));
    }
}
