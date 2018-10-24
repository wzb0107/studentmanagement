package cn.edu.hhuwtian.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.hhuwtian.dao.UserMapper;
import cn.edu.hhuwtian.exception.LoginException;
import cn.edu.hhuwtian.pojo.User;
import cn.edu.hhuwtian.pojo.UserExample;
import cn.edu.hhuwtian.service.UserService;

@Service
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
	public User userLogin(User user) throws LoginException {
		UserExample example = new UserExample();
		example.createCriteria().andPowerEqualTo(user.getPower())
				.andUsernameEqualTo(user.getUsername())
				.andPasswordEqualTo(user.getPassword());
		List<User> users = userMapper.selectByExample(example);
		if (null == users || users.size() == 0) {
			throw new LoginException("用户名或密码错误,请重新输入");
		} else {
			return users.get(0);
		}
	}

	@Override
	public void alterPassword(User u) {
		userMapper.updateByPrimaryKey(u);
	}

	@Override
	public void addUser(String number, String password,String power) {
		User user = new User();
		user.setUsername(number);
		user.setPassword(password);
		user.setPower(power);
		userMapper.insert(user);
	}
}
