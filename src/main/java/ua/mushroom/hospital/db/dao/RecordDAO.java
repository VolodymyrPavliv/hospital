package ua.mushroom.hospital.db.dao;

import ua.mushroom.hospital.db.entity.Record;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

/**
 * DAO for the Record entity.
 *
 * @author Volodymyr Pavliv
 */
public interface RecordDAO {
    List<Record> findByPatientId(int patientId);
    Optional<Record> findById(int id);
    List<Record> findByDoctorId(int doctorId);
    List<Record> findByNurseId(int nurseId);
    boolean addRecord(Record record);
    boolean addInitialDiagnosis(int id, String initialDiagnosis);
    boolean addFinalDiagnosis(int id, String finalDiagnosis);
    boolean addDischargeDate(int id, Date dischargeDate);
}
