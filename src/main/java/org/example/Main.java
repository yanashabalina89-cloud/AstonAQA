package org.example;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        exercise1();
        //exercise2();
    }
    public static void exercise1(){
        Set<Student> students = new HashSet<>();

        Student student1 = new Student("Иван Иванов", "Группа А", 1);
        student1.addGrade("Математика", 5);
        student1.addGrade("Физика", 4);
        student1.addGrade("История", 3);

        Student student2 = new Student("Петр Петров", "Группа Б", 2);
        student2.addGrade("Математика", 2);
        student2.addGrade("Физика", 3);
        student2.addGrade("История", 2);

        Student student3 = new Student("Мария Сидорова", "Группа А", 1);
        student3.addGrade("Математика", 4);
        student3.addGrade("Физика", 4);
        student3.addGrade("История", 5);

        Student student4 = new Student("Алексей Смирнов", "Группа В", 3);
        student4.addGrade("Математика", 3);
        student4.addGrade("Физика", 3);
        student4.addGrade("История", 4);

        Student student5 = new Student("Петр Петров", "Группа А", 2);
        student5.addGrade("Математика", 5);
        student5.addGrade("Физика", 5);
        student5.addGrade("История", 4);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        System.out.println("Все студенты:");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();

        Student.removeUnderperformingStudents(students);
        System.out.println("Студенты после удаления (средний балл >= 3):");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();

        Student.promoteStudents(students);
        System.out.println("Студенты после перевода на следующий курс:");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println();

        System.out.println("Студенты 2 курса:");
        Student.printStudents(students, 2);
    }

    public static void exercise2(){
        PhoneBook book = new PhoneBook();
        int person1 = book.addPerson("Иванов");
        book.addPhone(person1, "+79001111111");
        book.addPhone(person1, "+79001112222");
        int person2 = book.addPerson("Сидоров");
        book.addPhone(person2, "+79001234567");
        int person3 = book.addPerson("Петров");
        book.addPhone(person3, "+79255550199");
        int person4 = book.addPerson("Сидоров");
        book.addPhone(person4, "+79169876543");

        book.printAll();
        System.out.println();
        System.out.println(book.getPhonesBySurname("Сидоров"));
    }

}
