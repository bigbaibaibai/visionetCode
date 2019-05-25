package xyz.thishome.hotel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.thishome.hotel.mapper.UserMapper;
import xyz.thishome.hotel.pojo.User;
import xyz.thishome.hotel.pojo.UserExample;
import xyz.thishome.hotel.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        //从数据库中查询用户信息
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        return getUser(example);
    }

    private User getUser(UserExample example) {
        List<User> users = userMapper.selectByExample(example);
        if (users.size() > 0 && users.get(0) != null) {
            return users.get(0);
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User getUser(String username) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        return getUser(example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User saveUser(User user) {
        user.setUserStatus(0);
        userMapper.insertSelective(user);
        return user;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Integer userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User edit(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return user;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User getUser(Integer idCard) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdCardEqualTo(idCard);
        return getUser(example);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> getUserList() {
        return userMapper.selectByExample(null);
    }

}
