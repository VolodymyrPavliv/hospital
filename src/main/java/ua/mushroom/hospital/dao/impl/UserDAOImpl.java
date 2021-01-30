package ua.mushroom.hospital.dao.impl;

import ua.mushroom.hospital.constants.SQLConstants;
import ua.mushroom.hospital.dao.UserDAO;
import ua.mushroom.hospital.db.ConnectionPool;
import ua.mushroom.hospital.entities.User;
import ua.mushroom.hospital.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Interacts with the DB
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();

        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQLConstants.FIND_ALL_USERS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                userList.add(mapUser(resultSet));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    @Override
    public Optional<User> findById(int id) {
        User user = new User();
        ResultSet resultSet = null;
        PreparedStatement statement = null;

        try (Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.FIND_USER_BY_ID);
            statement.setInt(1, id);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = mapUser(resultSet);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }

        return Optional.of(user);
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        User user = new User();
        ResultSet resultSet = null;
        PreparedStatement statement = null;

        try (Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.FIND_USER_BY_EMAIL_AND_PASS);

            statement.setString(1, email);
            statement.setString(2, password);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                user = mapUser(resultSet);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }

        return Optional.of(user);
    }

    @Override
    public boolean addUser(User user) {
        PreparedStatement statement;
        try (Connection connection = ConnectionPool.getConnection()){
            statement = connection.prepareStatement(SQLConstants.INSERT_USER, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, user.getName());
            statement.setString(2, user.getSurname());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getPassword());
            statement.setInt(5,user.getRole_id());

            statement.execute();
            return true;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    private User mapUser(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setRole_id(resultSet.getInt("role_id"));

        return user;
    }
}