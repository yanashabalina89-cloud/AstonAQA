package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] array =  {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            sumStringMatrix(array);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    public static int sumStringMatrix(String[][] matrix) throws MyArraySizeException, MyArrayDataException {
        if (matrix == null || matrix.length != 4) {
            throw new MyArraySizeException("Массив должен иметь размер 4x4.");
        }
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            if (matrix[i] == null || matrix[i].length != 4) {
                throw new MyArraySizeException("Массив должен иметь размер 4x4. В строке " + i + " количество столбцов: " +
                        (matrix[i] == null ? 0 : matrix[i].length));
                }
            for(int j = 0; j < matrix[i].length; j++){
                int element = Integer.parseInt(matrix[i][j]);
                sum += element;
            }
        }
        return sum;
    }
}