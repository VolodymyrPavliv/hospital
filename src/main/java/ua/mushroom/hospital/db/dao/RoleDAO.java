package ua.mushroom.hospital.db.dao;

import ua.mushroom.hospital.db.entity.Role;

public interface RoleDAO {
    Role findById(int id);
    Role findByName(String name);
}
