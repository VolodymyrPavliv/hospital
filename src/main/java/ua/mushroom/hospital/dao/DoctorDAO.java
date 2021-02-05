package ua.mushroom.hospital.dao;

import ua.mushroom.hospital.entities.DoctorInfo;

import java.util.Optional;

public interface DoctorDAO {
    Optional<DoctorInfo> findByUserId(int userId);
    boolean addDoctor(int id, String category);
    Optional<DoctorInfo> findById(int id);
}
