package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
                .orElseThrow();
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

    public List<Animal> ageNotMatchWithPaws(List<Animal> animals) {
        return animals
                .stream()
                .filter(animal -> animal.age() != animal.paws())
                .toList();
    }
}
