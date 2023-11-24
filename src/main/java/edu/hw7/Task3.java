package edu.hw7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task3 {
    public record Person(int id, String name, String address, String phoneNumber) {}

    interface PersonDatabase {
        void add(Person person);

        void delete(int id);

        List<Person> findByName(String name);

        List<Person> findByAddress(String address);

        List<Person> findByPhone(String phone);
    }

    public static class SynchronizedPersonDatabase  implements PersonDatabase {
        private final Map<Integer, Person> peopleMap;

        public SynchronizedPersonDatabase() {
            this.peopleMap = new HashMap<>();
        }

        @Override
        public synchronized void add(Person person) {
            if (!peopleMap.containsKey(person.id())) {
                peopleMap.put(person.id(), person);
            }
        }

        @Override
        public synchronized void delete(int id) {
            peopleMap.remove(id);
        }

        @Override
        public synchronized List<Person> findByName(String name) {
            return peopleMap.values().parallelStream()
                    .filter(person -> person.name.equals(name))
                    .collect(Collectors.toList());
        }

        @Override
        public synchronized List<Person> findByAddress(String address) {
            return peopleMap.values().parallelStream()
                    .filter(person -> person.address.equals(address))
                    .collect(Collectors.toList());
        }

        @Override
        public synchronized List<Person> findByPhone(String phone) {
            return peopleMap.values().parallelStream()
                    .filter(person -> person.phoneNumber.equals(phone))
                    .collect(Collectors.toList());
        }
    }
}
