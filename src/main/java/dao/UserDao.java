package dao;

import java.util.List;

import model.User;

public interface UserDao {
	public User getUserById(int id);
	public void save(User user);
	public void update(int id, User user);
	public List<User> getAllUsers();
}
