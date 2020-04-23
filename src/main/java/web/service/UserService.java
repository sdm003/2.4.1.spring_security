package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User findUserByName(String name);
    void updateUser(User car);
    boolean checkUser(User user);
    void deleteUser(Long id);
}