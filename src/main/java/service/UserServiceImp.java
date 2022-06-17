package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import dao.UserDao;
import model.User;

@Component
public class UserServiceImp implements UserService{

	@Autowired
	@Qualifier("userDaoListImp")
	UserDao userDao;
	
	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

	@Override
	public void save(User user) {
		userDao.save(user);
		
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public void update(int id, User user) {
		userDao.update(id, user);		
	}
	
}
