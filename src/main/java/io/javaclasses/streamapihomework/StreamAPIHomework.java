package io.javaclasses.streamapihomework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

@SuppressWarnings({"MagicNumber", "UnsecureRandomNumberGeneration"})
class StreamAPIHomework {

    private StreamAPIHomework() {
    }

    public static void main(String[] args) {

        Java7StyleSolution();

        System.out.println();

        Java8StyleSolution();
    }

    private static void Java7StyleSolution() {

        Collection<Person> personList = new ArrayList<>();

        PersonType[] personTypes = PersonType.values();

        for (int i = 0; i < 1000; i++) {

            personList.add(new Person(
                    Integer.toString(i),
                    "Denis",
                    (int) (Math.random() * 50 + 20),
                    (int) (Math.random() * 20 + 1),
                    (int) (Math.random() * 1000 + i * 1000),
                    personTypes[i % 2]));
        }

        Collection<Person> resultSet = new HashSet<>();

        for (Person person : personList) {

            if (person.getPersonType() == PersonType.USEFUL) {

                if (person.getAge() < 30) {

                    if (person.getSalary() > 1000) {

                        resultSet.add(person);
                    }
                }
            }
        }

        int point = 0;

        Iterator<Person> it = resultSet.iterator();

        while (it.hasNext() && point < 5) {

            System.out.println(it.next());
            point++;
        }


    }

    private static void Java8StyleSolution() {

        Collection<Person> personList = new ArrayList<>();

        PersonType[] personTypes = PersonType.values();

        for (int i = 0; i < 1000; i++) {

            personList.add(new Person(
                    Integer.toString(i),
                    "Peter",
                    (int) (Math.random() * 50 + 20),
                    (int) (Math.random() * 20 + 1),
                    (int) (Math.random() * 1000 + i * 1000),
                    personTypes[i % 2]));
        }
        
        personList.stream()
                .distinct()
                .filter(person -> person.getAge()<30)
                .filter(person -> person.getSalary()>1000)
                .filter(person -> person.getPersonType()!=PersonType.USELESS)
                .limit(5)
                .sorted(Person::compareTo)
                .forEach(System.out::println);
    }

}

/*
Print NOT useless persons with names and ids,
 which age below 30 and salary more than 1000 sorted by experience (ASC).
  Should be printed only the 5 first persons. All the duplicates should be cleaned.
The solution must be in Java 7 and Java 8 (with the Stream API) styles.

 */



