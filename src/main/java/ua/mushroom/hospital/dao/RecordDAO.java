package ua.mushroom.hospital.dao;

import ua.mushroom.hospital.entities.Record;

import java.util.List;
import java.util.Optional;

public interface RecordDAO {
    List<Record> findByPatientId(int patientId);
    Optional<Record> findById(int id);
    List<Record> findByDoctorId(int doctorId);
    List<Record> findByNurseId(int nurseId);
    boolean addRecord(Record record);
}
