package ua.mushroom.hospital.constants;

public class SQLConstants {
    //For UserDAO
    public final static String FIND_ALL_USERS = "SELECT * FROM user";
    public final static String FIND_USER_BY_ID = "SELECT * FROM user WHERE id =?";
    public final static String FIND_USER_BY_EMAIL_AND_PASS = "SELECT * FROM user WHERE email = ? AND password = ?;";
    public final static String INSERT_USER = "INSERT INTO user(name, surname, email, password, birthday)" +
            "VALUES (?, ?, ?,?, ?);";
    public static final String ADD_ROLE_ID = "UPDATE user SET role_id = (?) WHERE id = ?;";
    public static final String FIND_ALL_USERS_BY_ROLE_ID = "SELECT * FROM user WHERE role_id = ?;";

    //For RoleDAO
    public static final String FIND_ROLE_BY_ID = "SELECT * FROM role WHERE id = ?;";
    public static final String FIND_ROLE_BY_NAME = "SELECT * FROM role WHERE name = ?;";

    //For DoctorInfoDAO
    public static final String FIND_DOCTOR_INFO_BY_USER_ID = "SELECT * FROM doctor_info WHERE user_id = ?;";
    public static final String INSERT_DOCTOR_INFO = "INSERT INTO doctor_info(category, user_id) VALUE (?, ?);";
    public static final String FIND_DOCTOR_BY_ID = "SELECT * FROM doctor_info WHERE id = ?;";

    //For RecordDAO
    public static final String FIND_RECORD_BY_PATIENT_ID = "SELECT * FROM record WHERE patient_id = ?;";
    public static final String FIND_RECORD_BY_ID = "SELECT * FROM record WHERE id = ?;";
    public static final String FIND_RECORD_BY_DOCTOR_ID = "SELECT * FROM record WHERE doctor_id = ?;";
    public static final String FIND_RECORD_BY_NURSE_ID = "SELECT * FROM record WHERE nurse_id = ?;";
    public static final String INSERT_RECORD = "INSERT INTO record(patient_id, doctor_id, nurse_id, entry_date) VALUE (?, ?, ?, ?);";
}
