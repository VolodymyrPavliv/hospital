package ua.mushroom.hospital.dao.impl;

import ua.mushroom.hospital.constants.SQLConstants;
import ua.mushroom.hospital.dao.PatientDAO;
import ua.mushroom.hospital.db.ConnectionPool;
import ua.mushroom.hospital.entities.NurseInfo;
import ua.mushroom.hospital.entities.PatientInfo;
import ua.mushroom.hospital.entities.User;
import ua.mushroom.hospital.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientDAOImpl implements PatientDAO {
    @Override
    public Optional<PatientInfo> findByUserId(int userId) {
        PatientInfo patient = new PatientInfo();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try(Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.FIND_PATIENT_BY_USER_ID);

            statement.setInt(1, userId);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                patient.setId(resultSet.getInt("id"));
                patient.setUserId(resultSet.getInt("user_id"));
                patient.setDoctorId(resultSet.getInt("doctor_info_id"));
                patient.setNurseId(resultSet.getInt("nurse_info_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }
        return Optional.of(patient);
    }

    @Override
    public List<User> findAllUserByDoctorId(int doctorId) {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try(Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.FIND_PATIENT_BY_DOCTOR_ID);

            statement.setInt(1, doctorId);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
             PatientInfo patient = mapPatient(resultSet);
             User user = findUserById(connection,patient.getUserId()).get();

             users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }
        return users;
    }

    @Override
    public List<User> findAllUserByNurseId(int id) {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try(Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.FIND_PATIENT_BY_NURSE_ID);

            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                PatientInfo patient = mapPatient(resultSet);
                User user = findUserById(connection,patient.getUserId()).get();

                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }
        return users;
    }

    private Optional<User> findUserById(Connection connection, int patientId) {
        User user = new User();
        ResultSet resultSet = null;
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(SQLConstants.FIND_USER_BY_ID);
            statement.setInt(1, patientId);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = DBUtils.mapUser(resultSet);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }

        return Optional.of(user);
    }

    private PatientInfo mapPatient(ResultSet resultSet) throws SQLException {
        PatientInfo patient = new PatientInfo();

        patient.setId(resultSet.getInt("id"));
        patient.setUserId(resultSet.getInt("user_id"));
        patient.setDoctorId(resultSet.getInt("doctor_info_id"));
        patient.setNurseId(resultSet.getInt("nurse_info_id"));

        return patient;
    }
}
