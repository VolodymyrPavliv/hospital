package ua.mushroom.hospital.db.dao.impl;

import ua.mushroom.hospital.constants.SQLConstants;
import ua.mushroom.hospital.db.dao.AssignmentDAO;
import ua.mushroom.hospital.db.ConnectionPool;
import ua.mushroom.hospital.db.entity.Assignment;
import ua.mushroom.hospital.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AssignmentDAOImpl implements AssignmentDAO {
    @Override
    public List<Assignment> findByRecordId(int recordId) {
        List<Assignment> assignments = new ArrayList<>();
        ResultSet resultSet = null;
        PreparedStatement statement = null;

        try (Connection connection = ConnectionPool.getConnection()) {
            statement = connection.prepareStatement(SQLConstants.FIND_ASSIGNMENT_BY_RECORD_ID);
            statement.setInt(1, recordId);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Assignment a = mapAssignment(resultSet);

                assignments.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtils.close(resultSet);
            DBUtils.close(statement);
        }

        return assignments;
    }

    @Override
    public boolean addAssignment(Assignment assignment) {
        PreparedStatement statement = null;
        try (Connection connection = ConnectionPool.getConnection()){
            statement = connection.prepareStatement(SQLConstants.INSERT_ASSIGNMENT, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, assignment.getType());
            statement.setString(2, assignment.getDescription());
            statement.setInt(3,assignment.getUserId());
            statement.setDate(4, assignment.getDate());
            statement.setInt(5, assignment.getRecordId());

            statement.execute();
            return true;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
            DBUtils.close(statement);
        }
        return false;
    }

    private Assignment mapAssignment(ResultSet resultSet) throws SQLException {
        Assignment assignment = new Assignment();

        assignment.setId(resultSet.getInt("id"));
        assignment.setDate(resultSet.getDate("date"));
        assignment.setDescription(resultSet.getString("description"));
        assignment.setType(resultSet.getString("type"));
        assignment.setRecordId(resultSet.getInt("record_id"));
        assignment.setUserId(resultSet.getInt("user_id"));

        return assignment;
    }
}
