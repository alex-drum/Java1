import java.util.Arrays;

public class Main {


    // Method for Task 6
    static Boolean checkBalance (int [] arr) {
        int leftSum = 0, rightSum = 0;
        Boolean balance = false;
        for (int i = 0; i < (arr.length - 1); i++) {
            leftSum += arr[i];
            for (int k = (i + 1); k < arr.length; k++) {
                rightSum += arr[k];
            }
            if (leftSum == rightSum) {
                balance = true;
                System.out.println("Совпадение найдено на " + (i + 1) + "-й итерации.");
                System.out.println("Balance: " + balance + ".");
                return balance;
            } else {
                balance = false;
            }
            rightSum = 0;
        }
        if (!balance) {
            System.out.println("Совпадений не обнаружено");
            System.out.println("Balance: " + balance + ".");
        }
        return balance;
    }

    // Method for Task 7
    static int[] shiftArray(int [] arr, int shiftNumber) {
        int buffer;
        for (int i = 0; i < shiftNumber; i++) {
            buffer = arr[arr.length - 1];
            for (int k = (arr.length - 2); k >= 0; k--) {
                arr[k + 1] = arr[k];
            }
            arr[0] = buffer;
        }
        System.out.println("Массив с сдвинутыми значениями: " + Arrays.toString(arr) + ";");
        return arr;
    }


    public static void main(String[] args) {

        // Task 1
        System.out.println("Задача № 1");
        int [] arr1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Начальный массив - \t\t  " + Arrays.toString(arr1));
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 0) {
                arr1[i] = 1;
            } else {
                arr1[i] = 0;
            }
        }
        System.out.println("Конвертированный массив - " + Arrays.toString(arr1));
        System.out.println("\n");

        // Task 2
        System.out.println("Задача № 2");
        int [] arr2 = new int[8];
        for (int i = 0, j = 0; i < arr2.length; i++, j += 3) {
            arr2[i] = j;
        }
        System.out.println(Arrays.toString(arr2));
        System.out.println("\n");

        // Task 3
        System.out.println("Задача № 3");
        int [] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Начальный массив -    " + Arrays.toString(arr3));
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] *= 2;
            }
        }
        System.out.println("Обработанный массив - " + Arrays.toString(arr3));
        System.out.println("\n");

        // Task 4
        System.out.println("Задача № 4");
        int [] [] arr4 = new int[5] [5];
        String layout = new String();
        for (int i = 0, k = 4; i < 5; i++, k--) {
            for (int j = 0; j < 5; j++) {
                if (j == i || j == k) {
                    arr4 [i] [j] = 1;
                } else {
                    arr4 [i] [j] = 0;
                }
                layout += arr4 [i] [j] + "  ";
            }
            System.out.println(layout);
            layout = "";
        }
        System.out.println("\n");

        // Task 5
        System.out.println("Задача № 5");
        int [] arr5 = {210, 2, 18, 5, -5, 64, 33, 102, 22};
        System.out.println("Заданный массив чисел: " + Arrays.toString(arr5) + ";");
        int min = arr5[0], max = arr5[0];
        for (int i = 0; i < (arr5.length - 1); i++) {
            if (min > arr5[i + 1]) {
                min = arr5[i + 1];
            }
            if (max < arr5[i + 1]) {
                max = arr5[i + 1];
            }
        }
        System.out.println("Минимальное число в массиве - " + min + ";");
        System.out.println("Максимальное число в массиве - " + max + ";");
        System.out.println("\n");


        // Task 6
        System.out.println("Задача № 6");
        int [] arr6 = {1, 2, 3, 4, 5, 10, 3, 2};
        System.out.println("Заданный массив чисел: " + Arrays.toString(arr6) + ";");
        checkBalance(arr6);
        System.out.println("\n");


        // Task 7
        System.out.println("Задача № 7");
        int [] arr7 = {1, 2, 3, 4, 5};
        int shiftNumber = 3;
        System.out.println("Начальный массив: " + Arrays.toString(arr7) + ";");
        System.out.println("На какое количество позиций сдвинуть значения: " + shiftNumber + ";");
        shiftArray(arr7, shiftNumber);

    }
}
