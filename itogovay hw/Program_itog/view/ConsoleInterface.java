package view;

import controller.AnimalRegistry;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {
    private AnimalRegistry registry;
    private Scanner scanner;

    public ConsoleInterface(AnimalRegistry registry) {
        this.registry = registry;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listAllAnimals();
                    break;
                case 2:
                    addNewAnimal();
                    break;
                case 3:
                    listAnimalCommands();
                    break;
                case 4:
                    trainCommand();
                    break;
                case 5:
                    deleteAnimal();
                    break;
                case 6:
                    listAnimalsByBirthDate();
                    break;
                case 7:
                    listTotalAnimalsCount();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Выберите одну из доступных опций снова!");
            }
        } while (choice != 0);
    }

    private void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1 - Список всех животных");
        System.out.println("2 - Добавить новое животное");
        System.out.println("3 - Список команд животного");
        System.out.println("4 - Добавление команды для животного");
        System.out.println("5 - Удаление животного");
        System.out.println("6 - Вывести список животных по дате рождения");
        System.out.println("7 - Вывести количество животных в реестре");
        System.out.println("0 - Выход");
        System.out.print("Выберите действие: ");
    }

    private void listAllAnimals() {
        registry.listAllAnimals();
    }

    private void addNewAnimal() {
        System.out.println("Выберите номер тип животного:");
        System.out.println("1 - Собака");
        System.out.println("2 - Кошка");
        System.out.println("3 - Хомяк");
        System.out.println("4 - Лошадь");
        System.out.println("5 - Верблюд");
        System.out.println("6 - Осел");
        System.out.print("Введите номер типа животного: ");
        int animalType = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        System.out.print("Введите дату рождения животного (гггг-мм-дд): ");
        String birthDate = scanner.nextLine();

        List<String> commands = new ArrayList<>();
        boolean addCommand;
        do {
            System.out.print("Введите команду для животного (или 'q' для завершения): ");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("q")) {
                addCommand = false;
            } else {
                commands.add(command);
                System.out.println("Команда \"" + command + "\" добавлена.");
                System.out.print("Добавить еще команду? (yes/no): ");
                String addMore = scanner.nextLine();
                addCommand = addMore.equalsIgnoreCase("yes");
            }
        } while (addCommand);

        switch (animalType) {
            case 1:
                Dog dog = new Dog(name, birthDate, commands);
                registry.addAnimal(dog);
                break;
            case 2:
                Cat cat = new Cat(name, birthDate, commands);
                registry.addAnimal(cat);
                break;
            case 3:
                Hamster hamster = new Hamster(name, birthDate, commands);
                registry.addAnimal(hamster);
                break;
            case 4:
                Horse horse = new Horse(name, birthDate, commands);
                registry.addAnimal(horse);
                break;
            case 5:
                Camel camel = new Camel(name, birthDate, commands);
                registry.addAnimal(camel);
                break;
            case 6:
                Donkey donkey = new Donkey(name, birthDate, commands);
                registry.addAnimal(donkey);
                break;
            default:
                System.out.println("Неверный типа животного.");
                break;
        }

        System.out.println("Новое животное добавлено в реестр.");
    }

    private void listAnimalCommands() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        Animal animal = registry.findAnimalByName(name);
        if (animal != null) {
            System.out.println("Команды для " + name + ":");
            List<String> commands = animal.listCommands();
            for (String command : commands) {
                System.out.println(command);
            }
        } else {
            System.out.println("Животное с именем " + name + " не найдено.");
        }
    }

    private void trainCommand() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        Animal animal = registry.findAnimalByName(name);
        if (animal != null) {
            System.out.print("Введите новую команду для животного: ");
            String newCommand = scanner.nextLine();
            animal.addCommand(newCommand);
            System.out.println("Новая команда \"" + newCommand + "\" успешно добавлена для " + name);
        } else {
            System.out.println("Животное с именем " + name + " не найдено.");
        }
    }

    private void deleteAnimal() {
        System.out.print("Введите имя животного для удаления: ");
        String name = scanner.nextLine();
        boolean removed = registry.deleteAnimalByName(name);
        if (removed) {
            System.out.println("Животное с именем " + name + " успешно удалено из реестра.");
        } else {
            System.out.println("Животное с именем " + name + " не найдено в реестре.");
        }
    }

    private void listTotalAnimalsCount() {
        int totalAnimalsCount = registry.getTotalAnimalsCount();
        System.out.println("Общее количество животных в реестре: " + totalAnimalsCount);
    }

    private void listAnimalsByBirthDate() {
        registry.listAnimalsByBirthDate();
    }
}