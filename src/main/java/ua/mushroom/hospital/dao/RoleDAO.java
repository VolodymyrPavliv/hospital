package ua.mushroom.hospital.dao;

import ua.mushroom.hospital.entities.Role;

public interface RoleDAO {
    public Role findById(int id);
    public Role findByName(String name);
}
