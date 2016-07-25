package ru.sbt;

import ru.sbt.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random(System.currentTimeMillis());
        List<Person> persons = new ArrayList<>();
        createPersons(persons);

        int countMaryy = 0;
        do {
            Person marryOnePerson = persons.get(random.nextInt(persons.size()));
            Person marryTwoPerson = persons.get(random.nextInt(persons.size()));
            System.out.print(marryOnePerson + " сватается " + marryTwoPerson);
            boolean isMarry = marryOnePerson.marry(marryTwoPerson);
            if (isMarry) {
                countMaryy++;
            }
            System.out.println(isMarry ? " поженились." : " не получилось.");
        } while (countMaryy <= 7);

        System.out.println("\nRandom marry ...\n");
        printPersons(persons);
        System.out.println("\nRandom divorce ...\n");

        int countDivorce = 0;
        do {
            Person divorcePerson = persons.get(random.nextInt(persons.size()));
            System.out.print(divorcePerson);
            boolean isDivorce = divorcePerson.divorce();
            if (isDivorce) {
                countDivorce++;
                System.out.println(" Развод.");
            } else {
                System.out.println(" Отказ в разводе.");
            }
        } while (countDivorce <= 3);

        System.out.println("\nResult\n");
        printPersons(persons);
    }

    private static void createPersons(List<Person> persons) {
        persons.add(new Person(("Варвара"), false));
        persons.add(new Person(("Денис"), true));
        persons.add(new Person(("Ирина"), false));
        persons.add(new Person(("Кирилл"), true));
        persons.add(new Person(("Настасья"), false));
        persons.add(new Person(("Олег"), true));
        persons.add(new Person(("Светлана"), false));
        persons.add(new Person(("Федор"), true));
        persons.add(new Person(("Юлия"), false));
        persons.add(new Person(("Михаил"), true));
        persons.add(new Person(("Василиса"), false));
        persons.add(new Person(("Ларион"), true));
        persons.add(new Person(("Анастасия"), false));
        persons.add(new Person(("Глеб"), true));
        persons.add(new Person(("Катерина"), false));
        persons.add(new Person(("Виктор"), true));
        persons.add(new Person(("Татьяна"), false));
        persons.add(new Person(("Иван"), true));
        persons.add(new Person(("Дарья"), false));
        persons.add(new Person(("Александр"), true));
    }

    private static void printPersons(List<Person> persons) {
        for (int i = 0; i < 20; i++) {
            System.out.println(persons.get(i));
        }
    }
}
