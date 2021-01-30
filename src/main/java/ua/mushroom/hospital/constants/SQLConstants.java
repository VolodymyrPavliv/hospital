package ua.mushroom.hospital.constants;

public class SQLConstants {
    public final static String FIND_ALL_USERS = "SELECT * FROM users";
    public final static String FIND_USER_BY_ID = "SELECT * FROM users WHERE id =?";
    public final static String FIND_USER_BY_EMAIL_AND_PASS = "SELECT * FROM users WHERE email = ? AND password = ?";
    public final static String INSERT_USER = "INSERT INTO users(name, surname, email, password, role_id)" +
            "VALUES (?, ?, ?,?, ?)";


    public static final String FIND_ROLE_BY_ID = "SELECT * FROM roles WHERE id = ?";
    public static final String FIND_ROLE_BY_NAME = "SELECT * FROM roles WHERE name = ?";
}
