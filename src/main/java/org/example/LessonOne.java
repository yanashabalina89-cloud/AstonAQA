package org.example;

import java.util.Arrays;

public class LessonOne {
    public static void main(String[] args) {
        System.out.println("Exercise 1:");
        printThreeWords();

        System.out.println("\nExercise 2:");
        checkSumSign();

        System.out.println("\nExercise 3:");
        printColor();

        System.out.println("\nExercise 4:");
        compareNumbers();

        System.out.println("\nExercise 5:");
        System.out.println(compareSum(10,5));

        System.out.println("\nExercise 6:");
        positiveOrNegative(-1999);

        System.out.println("\nExercise 7:");
        System.out.println(isNegative(-1958));

        System.out.println("\nExercise 8:");
        printString("I love coffee and Java!", 10);

        System.out.println("\nExercise 9:");
        System.out.println(isLeapYear(1004));

        System.out.println("\nExercise 10:");
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(swap(array1)));

        System.out.println("\nExercise 11:");
        System.out.println(Arrays.toString(fillArray(100)));

        System.out.println("\nExercise 12:");
        int[] array2 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(changeArray(array2)));

        System.out.println("\nExercise 13:");
        int n = 11;
        int [][] array3 = fillMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array3[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nExercise 14:");
        System.out.println(Arrays.toString(createArray(7, 8)));
    }

    /*
    1. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова:
    Orange, Banana, Apple
     */
    public static void printThreeWords(){
        System.out.println("Orange\nBanana\nApple");
    }

    /*
    2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b,
    и инициализируйте их любыми значениями, которыми захотите. Далее метод должен просуммировать эти переменные,
    и если их сумма больше или равна 0, то вывести в консоль сообщение “Сумма положительная”, в противном случае -
    “Сумма отрицательная”;
     */
    public static void checkSumSign(){
        int a = 1989;
        int b = 2025;
        System.out.println((a + b < 0) ? "Сумма отрицательная" : "Сумма положительная");
    }

    /*
    3. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением.
    Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”,
    если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”,
    если больше 100 (100 исключительно) - “Зеленый”;
     */
    public static void printColor(){
        int value = 50;
        if (value <= 0)
            System.out.println("Красный");
        else if (value <= 100)
            System.out.println("Желтый");
        else
            System.out.println("Зеленый");
    }

    /*
    4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми
     значениями, которыми захотите. Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”,
     в противном случае “a < b”;
     */
    public static void compareNumbers(){
        int a = 1967;
        int b = 2016;
        System.out.println((a >= b) ? "a >= b" : "a < b");
    }

    /*
    5. Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах
     от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
     */
    public static boolean compareSum(int a, int b){
        return a + b >= 10 && a + b <= 20;
    }

    /*
    6. Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль,
     положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
     */
    public static void positiveOrNegative(int a){
        System.out.println((a < 0) ? "Отрицательное число" : "Положительное число");
    }

    /*
    7. Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true,
    если число отрицательное, и вернуть false если положительное.
    Замечание: ноль считаем положительным числом.
     */
    public static boolean isNegative(int a){
        return a < 0;
    }

    /*
    8. Напишите метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль
     указанную строку, указанное количество раз.
     */
    public static void printString(String str, int count){
        for (int i = 0; i < count; i++)
            System.out.println(str);
    }

    /*
    9. Напишите метод, который определяет, является ли год високосным, и возвращает boolean
    (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го,
    при этом каждый 400-й – високосный.
     */
    public static boolean isLeapYear(int year){
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }

    /*
    10. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    public static int[] swap(int[] array){
        for (int i = 0; i < array.length; i++)
            array[i] = 1 - array[i];
        return array;
    }

    /*
    11. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
     */
    public static int[] fillArray(int n){
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++)
            array[i] = i + 1;
        return array;
    }

    /*
    12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
     */
    public static int[] changeArray(int[] array){
        for (int i = 0; i < array.length; i++)
            if (array[i] < 6) array[i] *= 2;
        return array;
    }

    /*
    13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
    Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны,
    то есть [0][0], [1][1], [2][2], ..., [n][n];
     */
    public static int[][] fillMatrix(int n){
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++){
            array[i][i] = 1;
            array[i][n - 1 - i] = 1;
        }
        return array;
    }

    /*
    14. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив
    типа int длиной len, каждая ячейка которого равна initialValue
     */
    public static int[] createArray(int len, int initialValue){
        int[] array = new int[len];
        for (int i = 0; i < len; i++)
            array[i] = initialValue;
        return array;
    }
}


