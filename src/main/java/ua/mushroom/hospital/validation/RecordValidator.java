package ua.mushroom.hospital.validation;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class RecordValidator {
    private static final String ID_REGEX = "^[0-9]+$";

    public boolean addRecord(String doctorId, String nurseId, Date entryDate, HttpServletRequest req) {
        if(doctorId.isEmpty() || nurseId.isEmpty() || entryDate == null) {
            req.setAttribute("emptyCredentials", true);
            return false;
        }

        if(!doctorId.matches(ID_REGEX) || !nurseId.matches(ID_REGEX)) {
            req.setAttribute("incorrectId", true);
            return false;
        }
        return true;
    }
}
