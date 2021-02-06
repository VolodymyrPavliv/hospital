package ua.mushroom.hospital.dao;

import ua.mushroom.hospital.entities.Role;

public interface RoleDAO {
    Role findById(int id);
    Role findByName(String name);
}
