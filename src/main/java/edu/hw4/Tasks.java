package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import static edu.hw4.ValidationError.validateAnimal;

public class Tasks {
    //task1
    public List<Animal> sortedByHeight(List<Animal> animals) {
        return animals
                .stream()
                .sorted(Comparator.comparingInt(Animal::height))
                .toList();
    }

    //task2
    public List<Animal> sortedByWeightSomeFirst(List<Animal> animals, int k) {
        return animals
                .stream()
                .sorted(Comparator.comparingInt(Animal::weight).reversed())
                .limit(k)
                .toList();
    }

    //task3
    public Map<Animal.Type, Long> countAnimalsByType(List<Animal> animals) {
        return animals
                .stream()
                .collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
    }

    //task4
    public Animal findAnimalLargestName(List<Animal> animals) {
        return animals
                .stream()
                .max(Comparator.comparing(animal -> animal.name().length()))
                .orElseThrow();
    }

    //task5
    public Animal.Sex findLargestSex(List<Animal> animals) {
        return animals
                .stream()
                .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()))
                .keySet()
                .stream()
                .max(Comparator.naturalOrder())
                .orElseThrow();
    }

    //task6
    public Map<Animal.Type, Animal> heaviestAnimalEveryType(List<Animal> animals) {
        return animals
                .stream()
                .collect(Collectors.toMap(Animal::type, animal -> animal,
                        (a1, a2) -> a1.weight() > a2.weight() ? a1 : a2));
    }

    //task7
    public Animal oldestAnimal(List<Animal> animals) {
        return animals
                .stream()
                .max(Comparator.comparingInt(Animal::age))
                .orElse(null);
    }

    //task8
    public Optional<Animal> heaviestAnimalBelowSomeSm(List<Animal> animals, int k) {
        return animals
                .stream()
                .filter(a -> a.height() < k)
                .max(Comparator.comparingInt(Animal::weight));
    }

    //task9
    public Integer countPawsAll(List<Animal> animals) {
        return animals
                .stream()
                .mapToInt(Animal::paws)
                .sum();
    }

    //task10
    public List<Animal> ageNotMatchWithPaws(List<Animal> animals) {
        return animals
                .stream()
                .filter(animal -> animal.age() != animal.paws())
                .toList();
    }

    //task11
    public List<Animal> findAnimalBitesAboveOneHundredHeight(List<Animal> animals) {
        final int height = 100;
        return animals
                .stream()
                .filter(animal -> animal.height() > height && animal.bites())
                .toList();
    }

    //task12
    public Long countAnimalsWeightMoreThanHeight(List<Animal> animals) {
        return animals
                .stream()
                .filter(animal -> animal.weight() > animal.height())
                .count();
    }

    //task13
    public List<Animal> findAnimalsNameMoreTwoWords(List<Animal> animals) {
        return animals
                .stream()
                .filter(animal -> animal.name().length() > 2)
                .toList();
    }

    //task14
    public Boolean hasAnimalTallerThenK(List<Animal> animals, int k) {
        return animals
                .stream()
                .anyMatch(animal -> animal.height() > k);
    }

    //task15
    public Integer sumWeightFromKToLYears(List<Animal> animals, int k, int l) {
        return animals
                .stream()
                .filter(animal -> animal.age() > k && animal.age() < l)
                .mapToInt(Animal::weight)
                .sum();
    }

    //task16
    public List<Animal> sortedAnimalsByTypeThenBySexThenByName(List<Animal> animals) {
        return animals
                .stream()
                .sorted(Comparator
                        .comparing(Animal::type)
                        .thenComparing(Animal::sex)
                        .thenComparing(Animal::name))
                .toList();
    }

    //task17
    public Boolean isSpiderBiteMoreThanDog(List<Animal> animals) {
        if (animals.stream().anyMatch(animal -> animal.type().equals(Animal.Type.SPIDER))
                && animals.stream().anyMatch(animal ->  animal.type().equals(Animal.Type.DOG))) {
            long spiderCount = animals
                    .stream()
                    .filter(animal -> animal.bites() && animal.type().equals(Animal.Type.SPIDER))
                    .count();
            long dogCount = animals
                    .stream()
                    .filter(animal -> animal.bites() && animal.type().equals(Animal.Type.DOG))
                    .count();
            return spiderCount > dogCount;
        }
        return false;
    }

    //task18
    public Animal findHeaviestFishInSomeLists(List<List<Animal>> animalsLists) {
        return animalsLists
                .stream()
                .flatMap(List::stream)
                .filter(animal -> animal.type().equals(Animal.Type.FISH))
                .max(Comparator.comparingInt(Animal::weight))
                .orElse(null);
    }

    //task19
    public Map<String, Set<ValidationError>> containsErrorAnimal(List<Animal> animals) {
        return animals
                .stream()
                .collect(Collectors.toMap(Animal::name, ValidationError::validateAnimal));
    }

    //task20
    public Map<String, String> editedLastTask(List<Animal> animals) {
        return animals.stream().collect(Collectors.toMap(
                Animal::name,
                animal -> {
                    Set<ValidationError> error = validateAnimal(animal);
                    Set<String> properties = new TreeSet<>();
                    for (var i : error) {
                        properties.add(i.type.toString());
                    }

                    return String.join(", ", properties);
                }
        ));
    }
}
