package edu.hw4;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task {

    private Task() {
    }

    // task1
    static public List<Animal> sortAnimalsByHeight(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparingInt(Animal::height)).toList();
    }

    // task2
    static public List<Animal> sortAnimalsByWeight(List<Animal> animals, int k) {
        return animals.stream().sorted(Comparator.comparingInt(Animal::weight).reversed()).limit(k).toList();
    }

    // task3
    static public Map<Animal.Type, Integer> counterForTypesOfAnimals(List<Animal> animals) {
        return animals.stream().collect(Collectors.groupingBy(Animal::type)).entrySet().stream()
            .map((Map.Entry<Animal.Type, List<Animal>> entry) -> Map.entry(entry.getKey(), entry.getValue().size()))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue
            ));
    }

    // task4
    static public Animal animalWithLongestName(List<Animal> animals) {
        return animals.stream().max(Comparator.comparingInt((Animal animal) -> animal.name().length())).get();
    }

    // task5
    static public Animal.Sex whichAreMore(List<Animal> animals) {
        return animals.stream().collect(Collectors.groupingBy(Animal::sex)).entrySet().stream()
            .max(Comparator.comparingInt((Map.Entry<Animal.Sex, List<Animal>> entry) -> entry.getValue().size())).get()
            .getKey();
    }

    // task6
    static public Map<Animal.Type, Animal> heaviestOfAllTypes(List<Animal> animals) {
        return animals.stream().collect(Collectors.groupingBy(Animal::type)).entrySet()
            .stream()
            .map((Map.Entry<Animal.Type, List<Animal>> entry) -> Map.entry(
                entry.getKey(),
                entry.getValue().stream().max(Comparator.comparingInt(Animal::weight)).get()
            )).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue
            ));
    }

    // task7
    static public Animal kthOldestAnimal(List<Animal> animals, int k) {
        return animals.stream().sorted(Comparator.comparingInt(Animal::age).reversed()).limit(k).toList().getLast();
    }

    // task8
    static public Optional<Animal> heaviestAnimalAmongLowerThanK(List<Animal> animals, int k) {
        return animals.stream().filter((Animal animal) -> animal.height() < k)
            .max((Comparator.comparingInt(Animal::weight)));
    }

    // task9
    static public Integer sumOfPaws(List<Animal> animals) {
        return animals.stream().mapToInt(Animal::paws).sum();
    }

    // task10
    static public List<Animal> ageNotEqualsPaws(List<Animal> animals) {
        return animals.stream().filter((Animal animal) -> animal.paws() != animal.age()).toList();
    }

    // task11
    @SuppressWarnings("MagicNumber")
    static public List<Animal> bitesAndHeightMoreThat100(List<Animal> animals) {
        return animals.stream().filter((Animal animal) -> animal.bites() && animal.height() > 100).toList();
    }

    // task12
    static public Integer weightMoreThanHeight(List<Animal> animals) {
        return animals.stream().filter((Animal animal) -> animal.weight() > animal.height()).toList().size();
    }

    // task13
    static public List<Animal> nameWithTreeOrMoreWords(List<Animal> animals) {
        return animals.stream().filter((Animal animal) -> animal.name().split(" ").length > 2).toList();
    }

    // task14
    static public Boolean dogWithHeightMoreThatK(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch((Animal animal) -> animal.type().equals(Animal.Type.DOG) && animal.height() > k);
    }

    // task15

    static public Map<Animal.Type, Integer> sumWeightOfTypesWithAgeKToL(List<Animal> animals, int k, int l) {
        return animals.stream().filter((Animal animal) -> animal.age() >= k && animal.age() <= l)
            .collect(Collectors.groupingBy(Animal::type)).entrySet().stream()
            .map((Map.Entry<Animal.Type, List<Animal>> entry) -> Map.entry(
                entry.getKey(),
                entry.getValue().stream().mapToInt(Animal::weight).sum()
            ))
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue
            ));
    }

    // task16
    static public List<Animal> sortedByTypeSexName(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name)).toList();
    }

    // task17

    static public Boolean spidersBiteMoreThanDogs(List<Animal> animals) {
        return animals.stream().filter((Animal animal) -> animal.type().equals(Animal.Type.DOG) || animal.type().equals(
                Animal.Type.SPIDER)).collect(Collectors.groupingBy(Animal::type)).entrySet().stream()
            .map((Map.Entry<Animal.Type, List<Animal>> entry) -> Map.entry(
                entry.getKey(),
                entry.getValue().stream().filter(
                    Animal::bites).toList().size() * 1.0 / entry.getValue().size()
            )).max(Map.Entry.comparingByValue()).get().getKey().equals(
                Animal.Type.SPIDER);
    }

    // task18
    static public Animal heaviestFish(List<List<Animal>> allAnimals) {
        return allAnimals.stream()
            .map((List<Animal> animals) -> animals.stream().filter((Animal an) -> an.type().equals(
                Animal.Type.FISH)).max(Comparator.comparingInt(Animal::weight)).get())
            .max(Comparator.comparingInt(Animal::weight)).get();
    }

    // task19
    static public Map<String, Set<ValidationError>> animalsWithErrors(List<Animal> animals) {
        return animals.stream().collect(Collectors.toMap(Animal::name, Function.identity())).entrySet().stream()
            .map((Map.Entry<String, Animal> entry) -> {
                Set<ValidationError> errorsSet = new HashSet<>();
                if (entry.getValue().name().isEmpty()) {
                    errorsSet.add(new NameError());
                }
                if (entry.getValue().height() <= 0) {
                    errorsSet.add(new HeightError());
                }
                if (entry.getValue().weight() <= 0) {
                    errorsSet.add(new WeightError());
                }
                if (entry.getValue().age() < 0) {
                    errorsSet.add(new AgeError());
                }
                return Map.entry(entry.getKey(), errorsSet);
            }).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue
            ));
    }

    //task20

    static public Map<String, String> animalWithPrettyOutputError(List<Animal> animals) {
        return animalsWithErrors(animals).entrySet().stream()
            .map((Map.Entry<String, Set<ValidationError>> entry) -> Map.entry(entry.getKey(), String.join(
                    " ",
                    entry.getValue().stream().map(ValidationError::getError).toList()
                )
            )).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue
            ));
    }

}
