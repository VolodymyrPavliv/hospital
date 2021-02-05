package ua.mushroom.hospital.dao;

import ua.mushroom.hospital.entities.PatientInfo;
import ua.mushroom.hospital.entities.User;

import java.util.List;
import java.util.Optional;

public interface PatientDAO {
    Optional<PatientInfo> findByUserId(int userId);
    List<User> findAllUserByDoctorId(int doctorId);
    List<User> findAllUserByNurseId(int id);
}
