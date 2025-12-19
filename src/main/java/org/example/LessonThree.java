package org.example;

import org.example.Animals.Animal;
import org.example.Animals.Bowl;
import org.example.Animals.Cat;
import org.example.Animals.Dog;
import org.example.Figures.Circle;
import org.example.Figures.Rectangle;
import org.example.Figures.Triangle;

import java.awt.*;
import java.util.ArrayList;

public class LessonThree {
    public static void main(String[] args) {
        // Exercise 1
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<Dog> dogs = new ArrayList<>();

        cats.add(new Cat("Барсик"));
        cats.add(new Cat("Мурзик"));
        cats.add(new Cat("Абрикосик"));

        cats.get(0).swim(2);
        cats.get(1).run(200);

        dogs.add(new Dog("Ральф"));
        dogs.add(new Dog("Рекс"));

        dogs.get(0).swim(9);
        dogs.get(1).run(501);

        System.out.println(Animal.getCount());
        System.out.println(Cat.getCount());
        System.out.println(Dog.getCount());

        Bowl bowl = new Bowl(50);
        cats.get(0).eat(15, bowl);
        cats.get(1).eat(20, bowl);
        cats.get(2).eat(20, bowl);

        for (Cat cat : cats) {
            System.out.println(cat.getName() + ((cat.getSatiety()) ? " сыт" : " голоден"));
        }

        bowl.addFood(10);
        cats.get(2).eat(10, bowl);
        System.out.println(cats.get(2).getName() + ((cats.get(2).getSatiety()) ? " сыт" : " голоден"));

        // Exercise 2
        System.out.println("\nТреугольник:");
        double[] triangleSides = {3, 4, 5};
        Triangle triangle = new Triangle(triangleSides, Color.blue, Color.CYAN);
        triangle.getInformation();

        System.out.println("\nПрямоугольник:");
        double width = 12.0;
        double height = 5.0;
        Rectangle rect = new Rectangle(width, height, Color.BLACK, Color.GRAY);
        rect.getInformation();

        System.out.println("\nКруг:");
        double radius = 7.0;
        Circle circle = new Circle(radius, Color.GREEN, Color.ORANGE);
        circle.getInformation();
    }
}
