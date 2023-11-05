package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import static edu.hw4.Animal.Type;
import static edu.hw4.Animal.Sex;
import static edu.hw4.Task.ageNotEqualsPaws;
import static edu.hw4.Task.animalWithLongestName;
import static edu.hw4.Task.animalsWithErrors;
import static edu.hw4.Task.bitesAndHeightMoreThat100;
import static edu.hw4.Task.counterForTypesOfAnimals;
import static edu.hw4.Task.dogWithHeightMoreThatK;
import static edu.hw4.Task.heaviestAnimalAmongLowerThanK;
import static edu.hw4.Task.heaviestFish;
import static edu.hw4.Task.heaviestOfAllTypes;
import static edu.hw4.Task.kthOldestAnimal;
import static edu.hw4.Task.nameWithTreeOrMoreWords;
import static edu.hw4.Task.sortAnimalsByHeight;
import static edu.hw4.Task.sortAnimalsByWeight;
import static edu.hw4.Task.sortedByTypeSexName;
import static edu.hw4.Task.spidersBiteMoreThanDogs;
import static edu.hw4.Task.sumOfPaws;
import static edu.hw4.Task.sumWeightOfTypesWithAgeKToL;
import static edu.hw4.Task.weightMoreThanHeight;
import static edu.hw4.Task.whichAreMore;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {

    static Random rd = new Random();

    static Animal dog1 = new Animal("dog1", Type.DOG, Sex.M, 1, 100, 5, true);
    static Animal dog2 = new Animal("dog2", Type.DOG, Sex.F, 3, 120, 8, true);

    static Animal dog3 = new Animal("dog3 Jonh Paul", Type.DOG, Sex.M, 5, 70, 3, false);
    static Animal cat1 = new Animal("cat1", Type.CAT, Sex.F, 0, 30, 3, false);
    static Animal cat2 = new Animal("cat2", Type.CAT, Sex.M, 7, 50, 10, false);
    static Animal cat3 = new Animal("cat3", Type.CAT, Sex.F, 12, 60, 9, false);
    static Animal bird1 = new Animal("bird Ann Smith", Type.BIRD, Sex.F, 10, 10, 1, false);
    static Animal bird2 = new Animal("bird2", Type.BIRD, Sex.M, 4, 5, 2, false);
    static Animal fish1 = new Animal("fish1", Type.FISH, Sex.F, 13, 2, 2, false);
    static Animal fish2 = new Animal("fish Mary", Type.FISH, Sex.F, 12, 2, 1, false);
    static Animal spider1 = new Animal("spider1", Type.SPIDER, Sex.F, 120, 1, 1, true);
    static Animal spider2 = new Animal("spiderLoooooooooongName", Type.SPIDER, Sex.M, 20, 1, 0, false);

    static List<Animal> myListOfAnimals = getListOfAnimals();

    static List<Animal> getListOfAnimals() {
        List<Animal> myListOfAnimals = new ArrayList<>();
        myListOfAnimals.add(dog1);
        myListOfAnimals.add(dog2);
        myListOfAnimals.add(dog3);
        myListOfAnimals.add(cat1);
        myListOfAnimals.add(cat2);
        myListOfAnimals.add(cat3);
        myListOfAnimals.add(bird1);
        myListOfAnimals.add(bird2);
        myListOfAnimals.add(fish1);
        myListOfAnimals.add(fish2);
        myListOfAnimals.add(spider1);
        myListOfAnimals.add(spider2);
        return myListOfAnimals;
    }

    @Test
    void sortAnimalsByHeightTest() {
        List<Animal> expectedList = myListOfAnimals;

        expectedList.sort(Comparator.comparingInt(Animal::height));

        assertEquals(expectedList, sortAnimalsByHeight(myListOfAnimals));
    }

    @Test
    void sortAnimalsByWeightTest() {
        List<Animal> expectedList = myListOfAnimals;
        expectedList.sort(Comparator.comparingInt(Animal::weight).reversed());

        int k = rd.nextInt(expectedList.size());
        expectedList = expectedList.subList(0, k);

        assertEquals(expectedList, sortAnimalsByWeight(myListOfAnimals, k));
    }

    @Test
    void counterForTypesOfAnimalsTest() {
        Map<Type, Integer> expectedMap = Map.of(Type.DOG, 3, Type.CAT, 3, Type.BIRD, 2, Type.SPIDER, 2, Type.FISH, 2);

        assertEquals(expectedMap, counterForTypesOfAnimals(myListOfAnimals));
    }

    @Test
    void animalWithLongestNameTest() {
        assertEquals(spider2, animalWithLongestName(myListOfAnimals));
    }

    @Test
    void whichAreMoreTest() {
        assertEquals(Sex.F, whichAreMore(myListOfAnimals));
    }

    @Test
    void heaviestOfAllTypesTest() {
        Map<Animal.Type, Animal> expectedMap = new HashMap<>();
        expectedMap.put(Type.DOG, dog2);
        expectedMap.put(Type.CAT, cat2);
        expectedMap.put(Type.BIRD, bird2);
        expectedMap.put(Type.FISH, fish1);
        expectedMap.put(Type.SPIDER, spider1);

        assertEquals(expectedMap, heaviestOfAllTypes(myListOfAnimals));
    }

    @Test
    void kthOldestAnimalTest() {
        List<Animal> expectedList = myListOfAnimals;
        expectedList.sort(Comparator.comparingInt(Animal::age).reversed());

        int k = rd.nextInt(expectedList.size());

        assertEquals(expectedList.get(k - 1), kthOldestAnimal(myListOfAnimals, k));
    }

    @Test
    void heaviestAnimalAmongLowerThanKTest() {

        List<Animal> expectedList = new ArrayList<>();

        int k = rd.nextInt(200);

        for (Animal an : myListOfAnimals) {
            if (an.height() < k) {
                expectedList.add(an);
            }
        }

        Animal expectedAnimal = null;

        if (!expectedList.isEmpty()) {
            expectedAnimal = Collections.max(expectedList, Comparator.comparingInt(Animal::weight));
        }

        assertEquals(Optional.ofNullable(expectedAnimal), heaviestAnimalAmongLowerThanK(myListOfAnimals, k));
    }

    @Test
    void sumOfPawsTest() {

        int expectedSum = 0;
        for (Animal animal : myListOfAnimals) {
            expectedSum += animal.paws();
        }

        assertEquals(expectedSum, sumOfPaws(myListOfAnimals));
    }

    @Test
    void ageNotEqualsPawsTest() {

        List<Animal> expectedList = new ArrayList<>();

        for (Animal animal : myListOfAnimals) {
            if (animal.paws() != animal.age()) {
                expectedList.add(animal);
            }
        }

        assertEquals(expectedList, ageNotEqualsPaws(myListOfAnimals));
    }

    @Test
    void bitesAndHeightMoreThat100Test() {
        List<Animal> expectedList = new ArrayList<>();

        for (Animal animal : myListOfAnimals) {
            if (animal.bites() && animal.height() > 100) {
                expectedList.add(animal);
            }
        }

        assertEquals(expectedList, bitesAndHeightMoreThat100(myListOfAnimals));
    }

    @Test
    void weightMoreThanHeightTest() {
        int expectednumber = 0;

        for (Animal animal : myListOfAnimals) {
            if (animal.weight() > animal.height()) {
                expectednumber++;
            }
        }

        assertEquals(expectednumber, weightMoreThanHeight(myListOfAnimals));
    }

    @Test
    void nameWithTreeOrMoreWordsTest() {
        List<Animal> expectedList = new ArrayList<>();
        for (Animal animal : myListOfAnimals) {
            if (animal.name().split(" ").length > 2) {
                expectedList.add(animal);
            }
        }

        assertEquals(expectedList, nameWithTreeOrMoreWords(myListOfAnimals));
    }

    @Test
    void dogWithHeightMoreThatKTest() {
        boolean answer = false;
        int k = rd.nextInt(200);
        for (Animal animal : myListOfAnimals) {
            if (animal.type().equals(Type.DOG) && animal.height() > k) {
                answer = true;
                break;
            }
        }

        assertEquals(answer, dogWithHeightMoreThatK(myListOfAnimals, k));
    }

    @Test
    void sumWeightOfTypesWithAgeKToLTest() {

        List<Animal> listWithKToLAge = new ArrayList<>();

        int l = rd.nextInt(20);
        int k = rd.nextInt(l);

        for (Animal animal : myListOfAnimals) {
            if (animal.age() >= k && animal.age() <= l) {
                listWithKToLAge.add(animal);
            }
        }

        Map<Animal.Type, Integer> expectedMap =
            new HashMap<>();

        for (Animal animal : listWithKToLAge) {

            if (expectedMap.get(animal.type()) != null) {
                expectedMap.replace(animal.type(), expectedMap.get(animal.type()) + animal.weight());
            } else {
                expectedMap.put(animal.type(), animal.weight());
            }
        }

        assertEquals(expectedMap, sumWeightOfTypesWithAgeKToL(myListOfAnimals, k, l));

    }

    @Test
    void sortedByTypeSexNameTest() {
        List<Animal> expectedList = myListOfAnimals;

        expectedList.sort(Comparator.comparing(Animal::type).thenComparing(Animal::sex).thenComparing(Animal::name));

        assertEquals(expectedList, sortedByTypeSexName(myListOfAnimals));
    }

    @Test
    void spidersBiteMoreThanDogsTest() {

        int dogs = 0;
        int dogsBite = 0;
        int spiders = 0;
        int spidersBite = 0;

        for (Animal animal : myListOfAnimals) {
            if (animal.type().equals(Type.DOG)) {
                dogs++;
                if (animal.bites()) {
                    dogsBite++;
                }
            } else if (animal.type().equals(Type.SPIDER)) {
                spiders++;
                if (animal.bites()) {
                    spidersBite++;
                }
            }
        }

        assertEquals(spidersBite / spiders > dogsBite / dogs, spidersBiteMoreThanDogs(myListOfAnimals));
    }

    @Test
    void heaviestFishTest() {

        List<List<Animal>> listOfLists = new ArrayList<>();
        listOfLists.add(myListOfAnimals);
        listOfLists.add(myListOfAnimals);

        Animal heavyFish = new Animal("heavy fish", Type.FISH, Sex.M, 10, 10, 100, true);

        listOfLists.add(List.of(heavyFish));

        assertEquals(heavyFish, heaviestFish(listOfLists));

    }

    @Test
    void animalsWithErrorsTest() {
        List<Animal> animalWithErrorsList = new ArrayList<>();
        animalWithErrorsList.add(new Animal("", Type.DOG, Sex.M, -1, 0, 20, false));
        animalWithErrorsList.add(new Animal("fish", Type.FISH, Sex.M, 0, -20, 0, false));
        animalWithErrorsList.add(new Animal("cat", Type.CAT, Sex.F, -1, 0, -99, false));

        Map<String, Set<ValidationError>> expectedMap = new HashMap<>();

        HashSet<ValidationError> set1 = new HashSet<>();
        set1.add(new AgeError());
        set1.add(new NameError());
        set1.add(new HeightError());

        expectedMap.put("", set1);

        HashSet<ValidationError> set2 = new HashSet<>();
        set2.add(new WeightError());
        set2.add(new HeightError());

        expectedMap.put("fish", set2);

        HashSet<ValidationError> set3 = new HashSet<>();
        set3.add(new AgeError());
        set3.add(new WeightError());
        set3.add(new HeightError());
        expectedMap.put("cat", set3);

        Map<String, Set<ValidationError>> actualMap = animalsWithErrors(animalWithErrorsList);

        assertEquals(expectedMap, actualMap);

    }

}
