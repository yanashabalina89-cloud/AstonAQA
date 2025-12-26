package org.example;

import java.util.*;

public class PhoneBook {
    private final Map<Integer, Person> persons = new HashMap<>();
    private int nextId = 1;

    public static class Person {
        private final int id;
        private final String surname;
        private final Set<String> phones;

        public Person(int id, String surname) {
            this.id = id;
            this.surname = surname;
            this.phones = new HashSet<>();
        }

        public void addPhone(String phone) {
            phones.add(phone);
        }

        public int getId() { return id; }
        public String getSurname() { return surname; }
        public Set<String> getPhones() { return new HashSet<>(phones); }
    }

    public int addPerson(String surname) {
        Person person = new Person(nextId++, surname);
        persons.put(person.getId(), person);
        return person.getId();
    }

    public void addPhone(int personId, String phone) {
        Person person = persons.get(personId);
        if (person == null) {
            throw new IllegalArgumentException("Человек с ID " + personId + " не найден");
        }
        person.addPhone(phone);
    }

    public List<String> getPhonesBySurname(String surname) {
        List<String> allPhones = new ArrayList<>();
        for (Person person : persons.values()) {
            if (person.getSurname().equals(surname)) {
                allPhones.addAll(person.getPhones());
            }
        }
        return allPhones;
    }

    public void printAll() {
        for (Person p : persons.values()) {
            System.out.println("ID: " + p.getId() + ", Фамилия: " + p.getSurname() + ", Телефоны: " + p.getPhones());
        }
    }
}
