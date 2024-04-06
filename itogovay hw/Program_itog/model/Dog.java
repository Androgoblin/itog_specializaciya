package model;

import java.util.List;

public class Dog extends Pet {
    public Dog(String name, String birthDate, List<String> commands) {
        super(name, birthDate, commands);
    }

    @Override
    public List<String> listCommands() {
        return getCommands();
    }

    @Override
    public String getType() {
        return "Dog";
    }
}