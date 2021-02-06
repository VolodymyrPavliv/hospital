package ua.mushroom.hospital.dao.impl;

import ua.mushroom.hospital.constants.SQLConstants;
import ua.mushroom.hospital.dao.RecordDAO;
import ua.mushroom.hospital.db.ConnectionPool;
import ua.mushroom.hospital.entities.DoctorInfo;
import ua.mushroom.hospital.entities.User;
import ua.mushroom.hospital.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecordDAOImpl implements RecordDAO {
    @Override
    public List<User> findPatientsByDoctorId(int doctorId) {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try(Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.FIND_PATIENTS_BY_DOCTOR_ID);

            statement.setInt(1, doctorId);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                User user = findUserById(connection, resultSet.getInt("patient_id"))
                        .get();

                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }
        return users;    }

    @Override
    public List<User> findPatientsByNurseId(int id) {
        List<User> users = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try(Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.FIND_PATIENTS_BY_NURSE_ID);

            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                User user = findUserById(connection, resultSet.getInt("patient_id"))
                        .get();

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
    public Optional<User> findDoctorByPatientId(int patientId) {
        User doctor = new User();

        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try (Connection connection = ConnectionPool.getConnection()){

            statement = connection.prepareStatement(SQLConstants.FIND_DOCTOR_BY_PATIENT_ID);
            statement.setInt(1,patientId);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DoctorInfo doctorInfo = findDoctorById(connection, patientId).get();
                doctor = findUserById(connection, doctorInfo.getUserId()).get();
            }
        }catch (SQLException e) {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }
        return Optional.of(doctor);
    }

    @Override
    public Optional<User> findNurseByPatientId(int patientId) {
        User nurse = new User();

        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try (Connection connection = ConnectionPool.getConnection()){

            statement = connection.prepareStatement(SQLConstants.FIND_NURSE_BY_PATIENT_ID);
            statement.setInt(1, patientId);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                nurse = findUserById(connection,resultSet.getInt("nurse_id")).get();
            }
        }catch (SQLException e) {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }
        return Optional.of(nurse);
    }

    private Optional<User> findUserById(Connection connection, int id) {
        User user = new User();
        ResultSet resultSet = null;
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement(SQLConstants.FIND_USER_BY_ID);
            statement.setInt(1, id);

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

    private Optional<DoctorInfo> findDoctorById(Connection connection, int id) {
        DoctorInfo doctor = new DoctorInfo();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement(SQLConstants.FIND_DOCTOR_INFO_BY_ID);

            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                doctor.setId(resultSet.getInt("id"));
                doctor.setCategory(resultSet.getString("category"));
                doctor.setUserId(resultSet.getInt("user_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }
        return Optional.of(doctor);
    }
}
