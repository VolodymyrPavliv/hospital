package ua.mushroom.hospital.dao;

import ua.mushroom.hospital.entities.Assignment;

import java.util.List;

public interface AssignmentDAO {
    List<Assignment> findByRecordId(int recordId);
    boolean addAssignment(Assignment assignment);
}
