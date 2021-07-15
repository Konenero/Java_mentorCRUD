package SpringCRUD.dao;

import SpringCRUD.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User", User.class);
        List<User> allUsers = query.getResultList();
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("delete from User where id=:userId");
        query.setParameter("userId", id);
        query.executeUpdate();

    }

    @Override
    public void updateUser(int id, User user) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("update User set " +
                "name = :nameParam, " +
                "surname = :surnameParam" +
                " where id = :idCod");
        query.setParameter("nameParam", user.getName());
        query.setParameter("surnameParam", user.getSurname());
        query.setParameter("idCod", id);
        query.executeUpdate();
    }
}
