package ua.mushroom.hospital.dao;

import ua.mushroom.hospital.entities.DoctorInfo;

import java.util.Optional;

public interface DoctorInfoDAO {
    Optional<DoctorInfo> findByUserId(int userId);
    boolean addDoctorInfo(int id, String category);
}
