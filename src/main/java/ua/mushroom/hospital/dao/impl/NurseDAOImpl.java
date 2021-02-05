package ua.mushroom.hospital.dao.impl;

import ua.mushroom.hospital.constants.SQLConstants;
import ua.mushroom.hospital.dao.NurseDAO;
import ua.mushroom.hospital.db.ConnectionPool;
import ua.mushroom.hospital.entities.DoctorInfo;
import ua.mushroom.hospital.entities.NurseInfo;
import ua.mushroom.hospital.entities.User;
import ua.mushroom.hospital.utils.DBUtils;

import java.sql.*;
import java.util.Optional;

public class NurseDAOImpl implements NurseDAO {
    @Override
    public Optional<NurseInfo> findByUserId(int userId) {
        NurseInfo nurse = new NurseInfo();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try(Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.FIND_NURSE_BY_USER_ID);

            statement.setInt(1, userId);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                nurse.setId(resultSet.getInt("id"));
                nurse.setUserId(resultSet.getInt("user_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }
        return Optional.of(nurse);
    }

    @Override
    public boolean addNurse(int id) {
        PreparedStatement statement;
        try (Connection connection = ConnectionPool.getConnection()){
            statement = connection.prepareStatement(SQLConstants.INSERT_NURSE, Statement.RETURN_GENERATED_KEYS);

            statement.setInt(1, id);

            statement.execute();
            return true;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;

    }
}
