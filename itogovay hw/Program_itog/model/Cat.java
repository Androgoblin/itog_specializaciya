package model;

import java.util.List;

public class Cat extends Pet {
    public Cat(String name, String birthDate, List<String> commands) {
        super(name, birthDate, commands);
    }

    @Override
    public List<String> listCommands() {
        return getCommands();
    }

    @Override
    public String getType() {
        return "Cat";
    }
}