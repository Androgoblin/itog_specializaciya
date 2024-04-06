package model;

import java.util.List;

public abstract class Pet extends Animal {
    public Pet(String name, String birthDate, List<String> commands) {
        super(name, birthDate);
        this.commands.addAll(commands);
    }

    @Override
    public List<String> listCommands() {
        return commands;
    }
}