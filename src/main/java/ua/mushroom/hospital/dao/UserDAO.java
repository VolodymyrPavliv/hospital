package ua.mushroom.hospital.dao;

import ua.mushroom.hospital.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> findAll();
    Optional<User> findByEmailAndPassword(String email, String password);
    boolean addUser(User user);
    Optional<User> findById(int id);
    boolean addRoleId(int id, int role_id);
    List<User> findAllByRoleId(int roleId);
}
