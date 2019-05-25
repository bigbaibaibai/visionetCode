package xyz.thishome.phone_sso.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.common.utils.JsonUtils;
import xyz.thishome.phone.mapper.TbUserMapper;
import xyz.thishome.phone.pojo.TbUser;
import xyz.thishome.phone.pojo.TbUserExample;
import xyz.thishome.phone_sso.service.SsoService;
import xyz.thishome.util.RedisUtil;

import java.util.List;

@Service
public class SsoServiceImpl implements SsoService {

    @Autowired
    private RedisUtil redisUtil;

    @Value("${SSO_EXPIRE_TIME}")
    private Long SSO_EXPIRE_TIME;

    @Autowired
    private TbUserMapper userMapper;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TbUser getUserForLogin(String username, String password) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        if (password != null) {
            criteria.andPasswordEqualTo(password);
        }
        List<TbUser> tbUsers = userMapper.selectByExample(example);
        if (tbUsers != null && tbUsers.size() > 0) {
            return tbUsers.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public TbUser getUserForUsername(String username) {
        return getUserForLogin(username, null);
    }

    @Override
    public void addUserToRedis(String key, TbUser user) {
        redisUtil.set(key, JsonUtils.objectToJson(user), SSO_EXPIRE_TIME);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void registUser(TbUser user) {
        userMapper.insert(user);
    }

    @Override
    public void logoutToRedis(String key) {
        redisUtil.del(key);
    }
}
