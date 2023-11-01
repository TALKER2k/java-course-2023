package edu.hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
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
            101,
            5,
            true
    );
    private static final Animal FISH = new Animal(
            "Fish",
            Animal.Type.FISH,
            Animal.Sex.M,
            10,
            10,
            35,
            false
    );

    private static final Animal INCORRECT_ANIMAL = new Animal(
            "",
            null,
            null,
            -10,
            -10,
            -10,
            false
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

    @Test
    void findAnimalBitesAboveOneHundredHeightTest() {
        List<Animal> animals = new ArrayList<>(List.of(SPIDER, CAT, SPIDER_BROTHER, DOG));
        List<Animal> bitesAnimals;

        bitesAnimals = tasks.findAnimalBitesAboveOneHundredHeight(animals);

        assertThat(List.of(SPIDER_BROTHER)).isEqualTo(bitesAnimals);
    }

    @Test
    void countAnimalsWeightMoreThanHeightTest() {
        List<Animal> animals = new ArrayList<>(List.of(SPIDER, CAT, SPIDER_BROTHER, DOG));
        Long weightMoreThanHeightAnimals;

        weightMoreThanHeightAnimals = tasks.countAnimalsWeightMoreThanHeight(animals);

        assertThat(2L).isEqualTo(weightMoreThanHeightAnimals);
    }

    @Test
    void findAnimalsNameMoreTwoWordsTest() {
        List<Animal> animals = new ArrayList<>(List.of(SPIDER, CAT, SPIDER_BROTHER, DOG));
        List<Animal> animalsNameMoreTwoWords;

        animalsNameMoreTwoWords = tasks.findAnimalsNameMoreTwoWords(animals);

        assertThat(animals).isEqualTo(animalsNameMoreTwoWords);
    }

    @Test
    void hasAnimalTallerThenKTest() {
        List<Animal> animals = new ArrayList<>(List.of(SPIDER, CAT, SPIDER_BROTHER, DOG));
        Boolean hasAnimalTallerThenK1;
        Boolean hasAnimalTallerThenK2;
        final int k1 = 10;
        final int k2 = 110;

        hasAnimalTallerThenK1 = tasks.hasAnimalTallerThenK(animals, k1);
        hasAnimalTallerThenK2 = tasks.hasAnimalTallerThenK(animals, k2);

        assertThat(true).isEqualTo(hasAnimalTallerThenK1);
        assertThat(false).isEqualTo(hasAnimalTallerThenK2);
    }

    @Test
    void sumWeightFromKToLYearsTest() {
        List<Animal> animals = new ArrayList<>(List.of(SPIDER, CAT, SPIDER_BROTHER, DOG));
        Integer sumWeightFromKToLYears;
        final int k = 2;
        final int l = 6;
        final int resultSumWeight = 26;

        sumWeightFromKToLYears = tasks.sumWeightFromKToLYears(animals, k, l);

        assertThat(resultSumWeight).isEqualTo(sumWeightFromKToLYears);
    }

    @Test
    void sortedAnimalsByTypeThenBySexThenByNameTest() {
        List<Animal> animals = new ArrayList<>(List.of(SPIDER, CAT, SPIDER_BROTHER, DOG));
        List<Animal> sortedList;

        sortedList = tasks.sortedAnimalsByTypeThenBySexThenByName(animals);

        assertThat(List.of(CAT, DOG, SPIDER_BROTHER, SPIDER)).isEqualTo(sortedList);
    }

    @Test
    void isSpiderBiteMoreThanDogTest() {
        List<Animal> animals1 = new ArrayList<>(List.of(SPIDER, CAT, SPIDER_BROTHER, DOG));
        List<Animal> animals2 = new ArrayList<>(List.of(SPIDER, CAT));
        Boolean result1;
        Boolean result2;

        result1 = tasks.isSpiderBiteMoreThanDog(animals1);
        result2 = tasks.isSpiderBiteMoreThanDog(animals2);

        assertThat(true).isEqualTo(result1);
        assertThat(false).isEqualTo(result2);
    }

    @Test
    void findHeaviestFishInSomeListsTest() {
        List<Animal> animals1 = new ArrayList<>(List.of(SPIDER, CAT));
        List<Animal> animals2 = new ArrayList<>(List.of(SPIDER_BROTHER, DOG, FISH));
        Animal heaviestFish;

        heaviestFish = tasks.findHeaviestFishInSomeLists(List.of(animals1, animals2));

        assertThat(FISH).isEqualTo(heaviestFish);
    }

    @Test
    void containsErrorAnimalTest() {
        List<Animal> animals = List.of(INCORRECT_ANIMAL);
        Map<String, Set<ValidationError>> returnedExceptions;

        returnedExceptions = tasks.containsErrorAnimal(animals);

        assertThat(true).isEqualTo(returnedExceptions.containsKey(""));
    }

    @Test
    void task20Test() {
        List<Animal> animalsWithIncorrectData = List.of(INCORRECT_ANIMAL);
        String correctLine = "AGE, HEIGHT, NAME, SEX, TYPE, WEIGHT";
        String resultErrors;

        resultErrors = tasks.editedLastTask(animalsWithIncorrectData).get("");

        assertThat(resultErrors).isEqualTo(correctLine);
    }
}
