package ua.mushroom.hospital.dao;

import ua.mushroom.hospital.entities.Record;
import ua.mushroom.hospital.entities.User;

import java.util.List;
import java.util.Optional;

public interface RecordDAO {
    List<User> findPatientsByDoctorId(int doctorId);
    List<User> findPatientsByNurseId(int nurseId);
    Optional<User> findDoctorByPatientId(int patient);
    Optional<User> findNurseByPatientId(int patient);
    boolean addRecord(Record record);

}
