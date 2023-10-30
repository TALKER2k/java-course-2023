package edu.hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TasksTest {
    Tasks tasks = new Tasks();
    private static final Animal DOG = new Animal(
            "first",
            Animal.Type.DOG,
            Animal.Sex.F,
            4,
            5,
            15,
            false
    );
    private static final Animal CAT = new Animal(
            "second",
            Animal.Type.CAT,
            Animal.Sex.M,
            5,
            3,
            10,
            true
    );
    private static final Animal SPIDER = new Animal(
            "third",
            Animal.Type.SPIDER,
            Animal.Sex.F,
            3,
            1,
            1,
            true
    );

    private static final Animal SPIDER_BROTHER = new Animal(
            "brother",
            Animal.Type.SPIDER,
            Animal.Sex.F,
            6,
            3,
            5,
            true
    );

    @Test
    void sortedByHeightTest() {
        List<Animal> animals = new ArrayList<>(List.of(DOG, CAT, SPIDER));
        List<Animal> animalsSorted = new ArrayList<>(List.of(SPIDER, CAT, DOG));

        List<Animal> returnedAnimals;

        returnedAnimals = tasks.sortedByHeight(animals);

        assertThat(returnedAnimals).isEqualTo(animalsSorted);
    }

    @Test
    void sortedByWeightSomeFirstTest() {
        List<Animal> animals = new ArrayList<>(List.of(SPIDER, CAT, DOG));
        List<Animal> animalsSorted = new ArrayList<>(List.of(DOG, CAT));

        List<Animal> returnedAnimals;
        final int k = 2;

        returnedAnimals = tasks.sortedByWeightSomeFirst(animals, k);

        assertThat(returnedAnimals).isEqualTo(animalsSorted);
    }

    @Test
    void countAnimalsByTypeTest() {
        List<Animal> animals = new ArrayList<>(List.of(SPIDER, CAT, DOG));
        Map<Animal.Type, Long> animalsByType = new HashMap<>(Map.of(
                Animal.Type.CAT, 1L,
                Animal.Type.SPIDER, 1L,
                Animal.Type.DOG, 1L
        ));

        Map<Animal.Type, Long> returnedAnimals;

        returnedAnimals = tasks.countAnimalsByType(animals);

        assertThat(returnedAnimals).isEqualTo(animalsByType);
    }

    @Test
    void findAnimalLargestNameTest() {
        List<Animal> animals = new ArrayList<>(List.of(SPIDER, CAT, DOG));

        Animal returnedAnimal;

        returnedAnimal = tasks.findAnimalLargestName(animals);

        assertThat(returnedAnimal).isEqualTo(CAT);
    }

    @Test
    void findLargestSexTest() {
        List<Animal> animals = new ArrayList<>(List.of(SPIDER, CAT, DOG));
        Animal.Sex largestSex;

        largestSex = tasks.findLargestSex(animals);

        assertThat(Animal.Sex.F).isEqualTo(largestSex);
    }

    @Test
    void heaviestAnimalEveryTypeTest() {
        List<Animal> animals = new ArrayList<>(List.of(SPIDER_BROTHER, CAT, DOG, SPIDER));
        Map<Animal.Type, Animal> result = new HashMap<>(Map.of(
                Animal.Type.DOG, DOG,
                Animal.Type.SPIDER, SPIDER_BROTHER,
                Animal.Type.CAT, CAT
        ));
        Map<Animal.Type, Animal> resultHeaviesAnimals;

        resultHeaviesAnimals = tasks.heaviestAnimalEveryType(animals);

        assertThat(result).isEqualTo(resultHeaviesAnimals);
    }

    @Test
    void oldestAnimalTest() {
        List<Animal> animals = new ArrayList<>(List.of(SPIDER, CAT, SPIDER_BROTHER, DOG));
        Animal oldestAnimal;

        oldestAnimal = tasks.oldestAnimal(animals);

        assertThat(SPIDER_BROTHER).isEqualTo(oldestAnimal);
    }

    @Test
    void heaviestAnimalBelowSomeSmTest() {
        List<Animal> animals = new ArrayList<>(List.of(SPIDER, CAT, SPIDER_BROTHER, DOG));
        final int k = 4;
        Optional<Animal> heaviestAnimal;

        heaviestAnimal = tasks.heaviestAnimalBelowSomeSm(animals, k);

        assertThat(Optional.of(CAT)).isEqualTo(heaviestAnimal);
    }

    @Test
    void countPawsAllTest() {
        List<Animal> animals = new ArrayList<>(List.of(SPIDER, CAT, SPIDER_BROTHER, DOG));
        final int pawsAll = 24;
        Integer countPaws;

        countPaws = tasks.countPawsAll(animals);

        assertThat(pawsAll).isEqualTo(countPaws);
    }

    @Test
    void ageNotMatchWithPawsTest() {
        List<Animal> animals = new ArrayList<>(List.of(SPIDER, CAT, SPIDER_BROTHER, DOG));
        List<Animal> ageNotMatchWithPaws;

        ageNotMatchWithPaws = tasks.ageNotMatchWithPaws(animals);

        assertThat(List.of(SPIDER, CAT, SPIDER_BROTHER)).isEqualTo(ageNotMatchWithPaws);
    }
}
