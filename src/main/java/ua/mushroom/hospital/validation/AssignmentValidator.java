package ua.mushroom.hospital.validation;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * The validator of Assignment entity
 *
 * @author Volodymyr Pavliv
 *
 */
public class AssignmentValidator {
    public boolean addAssignment(String description, Date date, HttpServletRequest req) {
        if(description.isEmpty() || date == null) {
            req.setAttribute("emptyCredentials", true);
            return false;
        }
        return true;
    }
}
