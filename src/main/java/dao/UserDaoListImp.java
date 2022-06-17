package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import model.User;

@Component
public class UserDaoListImp implements UserDao{

	private static int count;
	private static List<User> users;
	
	public UserDaoListImp() {
		if (users == null) {
			users = new ArrayList<>();
		}
	}
	
	@Override
	public User getUserById(int id) {
		return users.get(id-1);
	}

	@Override
	public void save(User user) {
		user.setId(++count);
		users.add(user);
	}

	@Override
	public List<User> getAllUsers() {
		return users;
	}

	@Override
	public void update(int id, User user) {
		User toUpdate = getUserById(id);
		toUpdate.setName(user.getName());
		toUpdate.setWallet(user.getWallet());
	}
	
	
}
