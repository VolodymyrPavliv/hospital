package ua.mushroom.hospital.validation;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * The validator for Record entity
 *
 * @author Volodymyr Pavliv
 *
 */
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

    public boolean addInitDiagnosis(String initialDiagnosis, HttpServletRequest req) {
        if(initialDiagnosis.isEmpty()) {
            req.setAttribute("emptyInitialDiagnosis", true);
            return false;
        }

        return true;
    }

    public boolean addFinalDiagnosis(String finalDiagnosis, Date date, HttpServletRequest req) {
        if(finalDiagnosis.isEmpty() || date == null) {
            req.setAttribute("emptyFinalDiagnosis", true);
            return false;
        }

        return true;
    }
}
