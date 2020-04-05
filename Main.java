public class Main {

    static int task1(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    static boolean task2(int a, int b) {
        if (a + b >= 10 && a + b <= 20) {
            return true;
        } else {
            return false;
        }
    }

    static void task3(int a) {
        if (a >= 0) {
            System.out.println("Введенное число - положительное.");
        } else {
            System.out.println("Введенное число - отрицательное.");
        }
    }

    static boolean task4(int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    static void task5(String name) {
        System.out.println("Привет, " + name + "!");
    }

    static void task6(int a) {
        if (a % 400 == 0) {
            System.out.println("Данный год является високосным.");
        } else if (a < 100 && a % 4 == 0) {
            System.out.println("Данный год является високосным.");
        }
        else if (a >= 100 && a % 4 == 0 && a % 100 != 0) {
            System.out.println("Данный год является високосным.");
        } else {
            System.out.println("Данный год не является високосным.");
        }
    }

    public static void main(String[] args) {

        System.out.println(task1(2, 4, 6, 2));
        System.out.println(task2(5,6));
        task3(-12);
        System.out.println(task4(-5));
        task5("Вася");
        task6(2020);

    }

}
