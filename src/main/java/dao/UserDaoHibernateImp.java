package dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.User;

@Component
@Repository
@Transactional
public class UserDaoHibernateImp implements UserDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public User getUserById(int id) {
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where id = :idParam");
		query.setParameter("idParam", id);
		return query.getSingleResult();
	}

	@Override
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
		
	}

	@Override
	public void remove(int id) {
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("delete User where id = :idParam");
		query.setParameter("idParam", id);		
		query.executeUpdate();
	}

	@Override
	public void update(int id, User user) {
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("update User "
				+ "set name = :namePar, wallet = :walletPar where id = :idParam");
		query.setParameter("namePar", user.getName());
		query.setParameter("walletPar", user.getWallet());
		query.setParameter("idParam", id);		
		query.executeUpdate();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
	    return query.getResultList();
	}

}
