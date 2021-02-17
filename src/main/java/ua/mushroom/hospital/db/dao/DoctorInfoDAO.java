package ua.mushroom.hospital.db.dao;

import ua.mushroom.hospital.db.entity.DoctorInfo;

import java.util.Optional;

public interface DoctorInfoDAO {
    Optional<DoctorInfo> findByUserId(int userId);
    boolean addDoctorInfo(int id, String category);
    Optional<DoctorInfo> findId(int id);
}
