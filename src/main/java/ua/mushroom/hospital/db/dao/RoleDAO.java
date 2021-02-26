package ua.mushroom.hospital.db.dao;

import ua.mushroom.hospital.db.entity.Role;

/**
 * DAO for the Role entity.
 *
 * @author Volodymyr Pavliv
 */

public interface RoleDAO {
    Role findById(int id);
    Role findByName(String name);
}
