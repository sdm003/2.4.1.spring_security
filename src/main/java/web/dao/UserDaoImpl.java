package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    @Qualifier("getSessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public boolean checkUser(User user) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User where name=:name")
                .setParameter("name", user.getName());
        return query.getResultList().isEmpty();
    }

    @Override
    public void updateUser(User user) {
        Query query = sessionFactory.getCurrentSession().createQuery("update User set age=:age, street=:street where id=:id");
        query.setParameter("age", user.getAge());
        query.setParameter("street", user.getStreet());
        query.setParameter("id", user.getId());
        query.executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User findUserByName(String name) {
        Query query =  sessionFactory.getCurrentSession().createQuery("from User where name=:name");
        query.setParameter("name", name);
        return (User) query.getSingleResult();
    }

    @Override
    public void deleteUser(Long id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(User.class, id));
    }

}
