package ua.mushroom.hospital.command.container;

import ua.mushroom.hospital.command.Command;
import ua.mushroom.hospital.command.HomeCommand;
import ua.mushroom.hospital.command.LoginCommand;
import ua.mushroom.hospital.command.LogoutCommand;
import ua.mushroom.hospital.command.admin.*;
import ua.mushroom.hospital.command.doctor.DoctorAssignmentsCommand;
import ua.mushroom.hospital.command.doctor.DoctorCommand;
import ua.mushroom.hospital.command.doctor.DoctorRecordCommand;
import ua.mushroom.hospital.command.doctor.DoctorRecordsCommand;
import ua.mushroom.hospital.command.nurse.NurseAssignmentsCommand;
import ua.mushroom.hospital.command.nurse.NurseCommand;
import ua.mushroom.hospital.command.nurse.NurseRecordCommand;
import ua.mushroom.hospital.command.nurse.NurseRecordsCommand;
import ua.mushroom.hospital.command.patient.PatientAssignmentsCommand;
import ua.mushroom.hospital.command.patient.PatientCommand;
import ua.mushroom.hospital.command.patient.PatientRecordCommand;
import ua.mushroom.hospital.command.patient.PatientRecordsCommand;
import ua.mushroom.hospital.constants.PathConstants;
import ua.mushroom.hospital.constants.ViewConstants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetCommandContainer implements CommandContainer{
    private final Map<String, Command> commands = new HashMap<>();

    public GetCommandContainer() {
        commands.put(PathConstants.LOGIN, (req, res) -> forward(req, res, ViewConstants.LOGIN_VIEW));
        commands.put(PathConstants.REGISTER, (req, res) -> forward(req, res, ViewConstants.REGISTER_VIEW));
        commands.put(PathConstants.ADD_RECORD, (req, resp) -> forward(req, resp, ViewConstants.ADD_RECORD_VIEW));
        commands.put(PathConstants.ADD_INIT_DIAGNOSIS, (req, resp) -> forward(req, resp, ViewConstants.ADD_INIT_DIAGNOSIS));
        commands.put(PathConstants.ADD_FINAL_DIAGNOSIS, (req, resp) -> forward(req, resp, ViewConstants.ADD_FINAL_DIAGNOSIS));
        commands.put(PathConstants.HOME_PAGE, new HomeCommand());
        commands.put(PathConstants.ADMIN_PAGE, new AdminCommand());
        commands.put(PathConstants.USER_LIST_PAGE, new UserListCommand());
        commands.put(PathConstants.DOCTOR_PAGE, new DoctorCommand());
        commands.put(PathConstants.NURSE_PAGE, new NurseCommand());
        commands.put(PathConstants.PATIENT_PAGE, new PatientCommand());
        commands.put(PathConstants.LOGOUT, new LogoutCommand());
        commands.put(PathConstants.ADMIN_RECORD_PAGE, new AdminRecordCommand());
        commands.put(PathConstants.DOCTOR_RECORD_PAGE, new DoctorRecordCommand());
        commands.put(PathConstants.NURSE_RECORD_PAGE, new NurseRecordCommand());
        commands.put(PathConstants.NURSE_RECORDS_PAGE, new NurseRecordsCommand());
        commands.put(PathConstants.NURSE_ASSIGNMENTS_PAGE, new NurseAssignmentsCommand());
        commands.put(PathConstants.PATIENT_RECORD_PAGE, new PatientRecordCommand());
        commands.put(PathConstants.PATIENT_RECORDS_PAGE, new PatientRecordsCommand());
        commands.put(PathConstants.PATIENT_ASSIGNMENTS_PAGE, new PatientAssignmentsCommand());
        commands.put(PathConstants.USER_DETAILS_PAGE, new UserDetailsCommand());
        commands.put(PathConstants.RECORD_LIST_PAGE, new RecordListCommand());
        commands.put(PathConstants.ASSIGNMENT_LIST_PAGE, new AssignmentListCommand());
        commands.put(PathConstants.DOCTOR_RECORDS_PAGE, new DoctorRecordsCommand());
        commands.put(PathConstants.DOCTOR_ASSIGNMENTS_PAGE, new DoctorAssignmentsCommand());
    }

    @Override
    public Command get(String uri) {
        Command command = commands.get(uri);
        if(command == null) {
            return commands.get(PathConstants.HOME_PAGE);
        }
        return command;
    }

    private static void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
        request.getRequestDispatcher(path).forward(request, response);
    }
}
