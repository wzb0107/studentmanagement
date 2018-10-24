package cn.edu.hhuwtian.service;

import cn.edu.hhuwtian.exception.LoginException;
import cn.edu.hhuwtian.pojo.User;

public interface UserService {

	User userLogin(User user) throws LoginException;

	void alterPassword(User u);

	void addUser(String number, String password, String power);

}
