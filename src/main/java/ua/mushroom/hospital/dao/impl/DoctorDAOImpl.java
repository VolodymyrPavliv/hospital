package ua.mushroom.hospital.dao.impl;

import ua.mushroom.hospital.constants.SQLConstants;
import ua.mushroom.hospital.dao.DoctorDAO;
import ua.mushroom.hospital.db.ConnectionPool;
import ua.mushroom.hospital.entities.DoctorInfo;
import ua.mushroom.hospital.entities.PatientInfo;
import ua.mushroom.hospital.entities.User;
import ua.mushroom.hospital.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoctorDAOImpl implements DoctorDAO {
    @Override
    public boolean addDoctor(int id, String category) {
        PreparedStatement statement;
        try (Connection connection = ConnectionPool.getConnection()){
            statement = connection.prepareStatement(SQLConstants.INSERT_DOCTOR, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, category);
            statement.setInt(2, id);

            statement.execute();
            return true;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Optional<DoctorInfo> findByUserId(int userId) {
        DoctorInfo doctor = new DoctorInfo();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try(Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.FIND_DOCTOR_BY_USER_ID);

            statement.setInt(1, userId);
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

    @Override
    public Optional<DoctorInfo> findById(int id) {
        DoctorInfo doctor = new DoctorInfo();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try(Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.FIND_DOCTOR_BY_ID);

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
