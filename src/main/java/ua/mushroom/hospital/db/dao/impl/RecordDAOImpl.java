package ua.mushroom.hospital.db.dao.impl;

import ua.mushroom.hospital.constants.SQLConstants;
import ua.mushroom.hospital.db.dao.RecordDAO;
import ua.mushroom.hospital.db.ConnectionPool;
import ua.mushroom.hospital.db.entity.Record;
import ua.mushroom.hospital.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * The implementation of the RecordDAO interface.
 *
 * @author Volodymyr Pavliv
 */
public class RecordDAOImpl implements RecordDAO {
    @Override
    public boolean addRecord(Record record) {
        PreparedStatement statement = null;
        try (Connection connection = ConnectionPool.getConnection()){
            statement = connection.prepareStatement(SQLConstants.INSERT_RECORD, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, record.getPatientId());
            statement.setInt(2, record.getDoctorId());
            statement.setInt(3, record.getNurseId());
            statement.setDate(4,record.getEntryDate());

            statement.execute();
            return true;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DBUtils.close(statement);
        }
        return false;
    }

    @Override
    public boolean addInitialDiagnosis(int id, String initialDiagnosis) {
        PreparedStatement statement = null;

        try (Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.ADD_INITIAL_DIAGNOSIS);

            statement.setString(1, initialDiagnosis);
            statement.setInt(2, id);

            statement.execute();

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.close(statement);
        }

        return false;
    }

    @Override
    public boolean addFinalDiagnosis(int id, String finalDiagnosis) {
        PreparedStatement statement = null;

        try (Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.ADD_FINAL_DIAGNOSIS);

            statement.setString(1, finalDiagnosis);
            statement.setInt(2, id);

            statement.execute();

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.close(statement);
        }

        return false;
    }

    @Override
    public boolean addDischargeDate(int id, Date dischargeDate) {
        PreparedStatement statement = null;

        try (Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.ADD_DISCHARGE_DATE);

            statement.setDate(1, dischargeDate);
            statement.setInt(2, id);

            statement.execute();

            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.close(statement);
        }

        return false;
    }

    @Override
    public List<Record> findByPatientId(int patientId) {
        List<Record> records = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;

        try (Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.FIND_RECORD_BY_PATIENT_ID);
            statement.setInt(1, patientId);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Record r = mapRecord(resultSet);

                records.add(r);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }

        return records;
    }

    @Override
    public List<Record> findByDoctorId(int doctorId) {
        List<Record> records = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;

        try (Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.FIND_RECORD_BY_DOCTOR_ID);
            statement.setInt(1, doctorId);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Record r = mapRecord(resultSet);

                records.add(r);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }

        return records;
    }

    @Override
    public List<Record> findByNurseId(int nurseId) {
        List<Record> records = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;

        try (Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.FIND_RECORD_BY_NURSE_ID);
            statement.setInt(1, nurseId);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Record r = mapRecord(resultSet);

                records.add(r);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }

        return records;
    }

    @Override
    public Optional<Record> findById(int id) {
        Record record = new Record();
        ResultSet resultSet = null;
        PreparedStatement statement = null;

        try (Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.FIND_RECORD_BY_ID);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                record = mapRecord(resultSet);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }

        return Optional.of(record);
    }

    private Record mapRecord(ResultSet resultSet) throws SQLException {
        Record record = new Record();

        record.setId(resultSet.getInt("id"));
        record.setPatientId(resultSet.getInt("patient_id"));
        record.setDoctorId(resultSet.getInt("doctor_id"));
        record.setNurseId(resultSet.getInt("nurse_id"));
        record.setEntryDate(resultSet.getDate("entry_date"));
        record.setDischargeDate(resultSet.getDate("discharge_date"));
        record.setInitialDiagnosis(resultSet.getString("initial_diagnosis"));
        record.setFinalDiagnosis(resultSet.getString("final_diagnosis"));

        return record;
    }
}
