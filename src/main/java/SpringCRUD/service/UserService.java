package SpringCRUD.service;

import SpringCRUD.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public void saveUser(User user);
    public User getUser(int id);
    public void deleteUser(int id);
    public void updateUser(int id, User user);
}
