package ua.mushroom.hospital.utils;

import ua.mushroom.hospital.entities.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
    public static void close(AutoCloseable ac) {
        if (ac != null) {
            try {
                ac.close();
            } catch (Exception ex) {
                //Here will be a log
            }
        }
    }

    public static User mapUser(ResultSet resultSet) throws SQLException {
        User user = new User();

        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setSurname(resultSet.getString("surname"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setRole_id(resultSet.getInt("role_id"));
        user.setBirthday(resultSet.getDate("birthday"));

        return user;
    }
}
