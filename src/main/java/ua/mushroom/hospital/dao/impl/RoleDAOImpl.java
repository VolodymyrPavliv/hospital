package ua.mushroom.hospital.dao.impl;

import ua.mushroom.hospital.constants.SQLConstants;
import ua.mushroom.hospital.dao.RoleDAO;
import ua.mushroom.hospital.db.ConnectionPool;
import ua.mushroom.hospital.entities.Role;
import ua.mushroom.hospital.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAOImpl implements RoleDAO {
    @Override
    public Role findById(int id) {
        Role role = new Role();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try (Connection connection = ConnectionPool.getConnection()){
            statement = connection.prepareStatement(SQLConstants.FIND_ROLE_BY_ID);
            statement.setInt(1,id);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                role.setId(resultSet.getInt("id"));
                role.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }

        return role;
    }

    @Override
    public Role findByName(String name) {
        Role role = new Role();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try (Connection connection = ConnectionPool.getConnection()){
            statement = connection.prepareStatement(SQLConstants.FIND_ROLE_BY_NAME);
            statement.setString(1,name);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                role.setId(resultSet.getInt("id"));
                role.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }

        return role;
    }
}
