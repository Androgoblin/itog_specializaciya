package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private String name;
    private String birthDate;
    List<String> commands;

    public Animal(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public abstract List<String> listCommands();

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String newCommand) {
        commands.add(newCommand);
    }

    public abstract String getType();
}
