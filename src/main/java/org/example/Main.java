package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] array1 =  {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String[][] array2 =  {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] array3 =  {
                {"1", "2", "3", "4"},
                {"5", "6", "s", "8"},
                {"9", "10", "11", "12"},
                {"13", "y", "15", "16"}
        };

        try {
            System.out.println(sumStringMatrix(array3));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

        try {
            String[] value = array2[16];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static int sumStringMatrix(String[][] matrix) throws MyArraySizeException, MyArrayDataException {
        if (matrix == null || matrix.length != 4) {
            throw new MyArraySizeException("Массив должен иметь размер 4x4. Получено строк: " + (matrix == null ? 0 : matrix.length));
        }

        int sum = 0;

        for(int i = 0; i < matrix.length; i++){
            if (matrix[i] == null || matrix[i].length != 4) {
                throw new MyArraySizeException("Массив должен иметь размер 4x4. В строке " + i + " количество столбцов: " +
                        (matrix[i] == null ? 0 : matrix[i].length));
            }
            for(int j = 0; j < matrix[i].length; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, matrix[i][j]);
                }
            }
        }

        return sum;
    }
}