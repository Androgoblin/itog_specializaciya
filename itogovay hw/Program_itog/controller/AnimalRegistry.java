package controller;

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnimalRegistry {
    private List<Animal> animals;

    public AnimalRegistry() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void addNewAnimal(int animalType, String name, String birthDate, List<String> commands) {
        Animal newAnimal = null;
        switch (animalType) {
            case 1:
                newAnimal = new Dog(name, birthDate, commands);
                break;
            case 2:
                newAnimal = new Cat(name, birthDate, commands);
                break;
            case 3:
                newAnimal = new Hamster(name, birthDate, commands);
                break;
            case 4:
                newAnimal = new Horse(name, birthDate, commands);
                break;
            case 5:
                newAnimal = new Camel(name, birthDate, commands);
                break;
            case 6:
                newAnimal = new Donkey(name, birthDate, commands);
                break;
            default:
                System.out.println("Неверный тип животного.");
        }
        if (newAnimal != null) {
            animals.add(newAnimal);
            System.out.println("Новое животное добавлено в реестр.");
        }
    }

    public void listAllAnimals() {
        if (animals.isEmpty()) {
            System.out.println("Реестр животных пуст.");
            return;
        }

        System.out.println("Список всех животных:");
        for (Animal animal : animals) {
            System.out.println("Имя: " + animal.getName() + ", Тип: " + animal.getType());
            listAnimalCommands(animal.getName());
            System.out.println();
        }
    }

    public void listAnimalCommands(String name) {
        Animal animal = findAnimalByName(name);
        if (animal != null) {
            System.out.println("Команды для " + name + ":");
            for (String command : animal.getCommands()) {
                System.out.println(command);
            }
        } else {
            System.out.println("Животное с именем " + name + " не найдено.");
        }
    }

    public boolean deleteAnimalByName(String name) {
        Animal animal = findAnimalByName(name);
        if (animal != null) {
            animals.remove(animal);
            System.out.println("Животное с именем " + name + " удалено из реестра.");
            return true;
        } else {
            System.out.println("Животное с именем " + name + " не найдено.");
            return false;
        }
    }

    public Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }

    public int getTotalAnimalsCount() {
        return animals.size();
    }

    public void listAnimalsByBirthDate() {
        Collections.sort(animals, Comparator.comparing(Animal::getBirthDate));

        System.out.println("Список животных по дате рождения:");
        for (Animal animal : animals) {
            System.out.println(animal.getName() + " (" + animal.getBirthDate() + ")");
        }
    }
}