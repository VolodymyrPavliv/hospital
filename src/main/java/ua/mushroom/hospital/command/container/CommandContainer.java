package ua.mushroom.hospital.command.container;

import ua.mushroom.hospital.command.Command;

public interface CommandContainer {
    Command get(String uri);
}
