package ua.mushroom.hospital.dao;

import ua.mushroom.hospital.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    public List<User> findAll();
    public Optional<User> findByEmailAndPassword(String email, String password);
    public boolean addUser(User user);
    public Optional<User> findById(int id);
    public boolean addRoleId(int id, int role_id);
    public List<User> findAllByRoleId(int roleId);
}
