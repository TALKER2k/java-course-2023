package edu.hw7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

public class Task3Part2 {
    private static final ReadWriteLock LOCK = new ReentrantReadWriteLock();

    public record Person(int id, String name, String address, String phoneNumber) {}

    interface PersonDatabase {
        void add(Person person);

        void delete(int id);

        List<Person> findByName(String name);

        List<Person> findByAddress(String address);

        List<Person> findByPhone(String phone);
    }

    public static class LockedPersonDatabase  implements PersonDatabase {
        private final Map<Integer, Person> peopleMap;

        public LockedPersonDatabase() {
            this.peopleMap = new HashMap<>();
        }

        @Override
        public void add(Person person) {
            LOCK.writeLock().lock();
            if (!peopleMap.containsKey(person.id())) {
                peopleMap.put(person.id(), person);
            }
            LOCK.writeLock().unlock();
        }

        @Override
        public void delete(int id) {
            LOCK.writeLock().lock();
            peopleMap.remove(id);
            LOCK.writeLock().unlock();
        }

        @Override
        public List<Person> findByName(String name) {
            LOCK.readLock().lock();
            try {
                return peopleMap.values().parallelStream()
                        .filter(person -> person.name().equals(name))
                        .collect(Collectors.toList());
            } finally {
                LOCK.readLock().unlock();
            }
        }

        @Override
        public synchronized List<Person> findByAddress(String address) {
            LOCK.readLock().lock();
            try {
                return peopleMap.values().parallelStream()
                        .filter(person -> person.address().equals(address))
                        .collect(Collectors.toList());
            } finally {
                LOCK.readLock().unlock();
            }
        }

        @Override
        public synchronized List<Person> findByPhone(String phone) {
            LOCK.readLock().lock();
            try {
                return peopleMap.values().parallelStream()
                        .filter(person -> person.phoneNumber().equals(phone))
                        .collect(Collectors.toList());
            } finally {
                LOCK.readLock().unlock();
            }
        }
    }
}
