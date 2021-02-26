package ua.mushroom.hospital.command.container;

import ua.mushroom.hospital.command.Command;

/**
 * Container of commands interface
 *
 * @author Volodymyr Pavliv
 */
public interface CommandContainer {
    Command get(String uri);
}
