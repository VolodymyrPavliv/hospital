package ua.mushroom.hospital.command.container;

import ua.mushroom.hospital.command.*;
import ua.mushroom.hospital.command.admin.AddRecordCommand;
import ua.mushroom.hospital.command.admin.UserRegisterCommand;
import ua.mushroom.hospital.command.doctor.AddFinalDiagnosisCommand;
import ua.mushroom.hospital.command.doctor.AddInitialDiagnosisCommand;
import ua.mushroom.hospital.constants.PathConstants;

import java.util.HashMap;
import java.util.Map;

public class PostCommandContainer implements CommandContainer {
    private final Map<String, Command> commands = new HashMap<>();

    public PostCommandContainer() {
        commands.put(PathConstants.HOME_PAGE, new HomeCommand());
        commands.put(PathConstants.LOGIN, new LoginCommand());
        commands.put(PathConstants.REGISTER, new RegisterCommand());
        commands.put(PathConstants.ADD_INIT_DIAGNOSIS, new AddInitialDiagnosisCommand());
        commands.put(PathConstants.ADD_FINAL_DIAGNOSIS, new AddFinalDiagnosisCommand());
        commands.put(PathConstants.ADD_ASSIGNMENT, new AddAssignmentCommand());
        commands.put(PathConstants.REGISTER_USER, new UserRegisterCommand());
        commands.put(PathConstants.ADD_RECORD, new AddRecordCommand());
    }

    @Override
    public Command get(String uri) {
        Command command = commands.get(uri);
        if (command == null) {
            return commands.get(PathConstants.HOME_PAGE);
        }
        return command;
    }
}
