package ua.mushroom.hospital.db.dao;

import ua.mushroom.hospital.db.entity.Assignment;

import java.util.List;

public interface AssignmentDAO {
    List<Assignment> findByRecordId(int recordId);
    boolean addAssignment(Assignment assignment);
}
