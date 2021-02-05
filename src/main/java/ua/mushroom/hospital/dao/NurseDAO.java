package ua.mushroom.hospital.dao;

import ua.mushroom.hospital.entities.NurseInfo;

import java.util.Optional;

public interface NurseDAO {
    Optional<NurseInfo> findByUserId(int userId);
    boolean addNurse(int id);
}
