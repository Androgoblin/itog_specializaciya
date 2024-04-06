
import controller.AnimalRegistry;
import model.*;
import view.ConsoleInterface;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();

        Dog rumba = new Dog("Rumba", "2018-01-01", List.of("Sit", "Stay"));
        Cat white = new Cat("White", "2024-01-02", List.of("Sit", "jump"));
        Hamster ruza = new Hamster("Ruza", "2023-12-23", List.of("Run"));
        Dog bull = new Dog("Bull", "2017-01-07", List.of("Sit", "Sleep"));
        Cat samurai = new Cat("Samurai", "2023-01-10", List.of("Sit", "Voice"));
        Hamster rudy = new Hamster("Rudy", "2001-12-01", List.of("Roll", "brake"));
        Dog belka = new Dog("Belka", "2010-11-11", List.of("Sit", "Stay"));
        Cat bugs = new Cat("Bugs", "2011-11-11", List.of("Voice", "die", "Jump"));
        Horse bolt = new Horse("Bolt", "2009-09-09", List.of("freeze", "lynx"));
        Camel sushi = new Camel("Sushi", "2008-08-08", List.of("Run", "lie"));
        Donkey idiot = new Donkey("Idiot", "2024-09-09", List.of("stay", "Voice"));
        Horse bork = new Horse("Bork", "2011-05-05", List.of("Gait", "barrier"));
        Camel dundy = new Camel("Dundy", "2018-12-12", List.of("stay", "Sit"));
        Donkey burbon = new Donkey("Burbon", "2019-01-23", List.of("home", "stay", "Kick"));
        Horse saber = new Horse("Blaze", "2000-02-01", List.of("Gait", "Jump", "Gallop"));
        Camel boat = new Camel("Boat", "2006-08-14", List.of("lie7", "Run"));

        registry.addAnimal(rumba);
        registry.addAnimal(white);
        registry.addAnimal(ruza);
        registry.addAnimal(bull);
        registry.addAnimal(samurai);
        registry.addAnimal(rudy);
        registry.addAnimal(belka);
        registry.addAnimal(bugs);
        registry.addAnimal(bolt);
        registry.addAnimal(sushi);
        registry.addAnimal(idiot);
        registry.addAnimal(bork);
        registry.addAnimal(dundy);
        registry.addAnimal(burbon);
        registry.addAnimal(saber);
        registry.addAnimal(boat);

        ConsoleInterface consoleInterface = new ConsoleInterface(registry);
        consoleInterface.start();
    }
}