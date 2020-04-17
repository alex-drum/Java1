package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameXO {

    enum Type {
        X, O, DEFAULT
    }

    private final static Type empty = Type.DEFAULT;

    private final static char EMPTY = '_';
    private final static char DOT_X = 'X';
    private final static char DOT_O = 'O';
    private final static int VICTORY_CONDITION = 4;
    public static int[][] userX = new int[1][25]; // сохраняем Х-координаты  ходов игрока
    public static int[][] userY = new int[1][25]; // сохраняем Y-координаты ходов игрока

    public static char[][] getInitMap(int size) {
        char[][] map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = EMPTY;
            }
        }
        return map;
    }
    public static void printMap(char [][] map) {
        int size = map.length;
        System.out.print("   ");
        for (int i = 0; i < map.length; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < map.length; j++) {
                System.out.print("|" + map[i][j]);
            }
            System.out.println("|");
        }
    }
    public static void humanTurn(char [][] map, int x, int y) {
        x--; y--;
        map[x][y] = DOT_X;
    }
    private static boolean isCellValid(char[][] map, int x, int y) {
        x--; y--;
        int size = map.length;
        if (x >= 0 && x < size && y >= 0 && y < size) {
            return map[x][y] == EMPTY;
        }
        return false;
    }


         // TODO: Доделать проверку, есть ошибки в диагоналях, есть ошибки в горизонталях/вертикалях
         //  (4Х даже не подряд считает как победу
    private static boolean checkVictory(char[][] map, char dot, int victoryCondition) {
        // TODO: 14.04.2020
        // Check horizontals and verticals:
        for (int i = 0; i < map.length; i++) {
            int counterHor = 0, counterVert = 0;
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == dot) counterHor++;
                if (map[j][i] == dot) counterVert++;
            }
            if (counterHor == victoryCondition || counterVert == victoryCondition) return true;
        }

        // check diagonals
        for (int i = 0; i < map.length - (victoryCondition - 1); i++) {  // check central diagonals
            int diagCounter = 0;
            for (int j = 0, k = map.length - 1; j <= victoryCondition ; j++, k--) {
                if (map[j][j] == dot ||
                    map[j][k] == dot)
                    diagCounter++;
            }
            diagCounter = 0;
            // TODO: Доделать проверку диагоналей, не всегда считает корректно
            for (int j = 1, k = map.length - 1; j <= victoryCondition; j++, k--) {     //check side diagonals
                if (map[j-1][j] == dot ||
                    map[j][j-1] == dot ||
                    map[j-1][k-1] == dot ||
                    map[j][k] == dot)
                    diagCounter++;
            }
            if (diagCounter == victoryCondition) {
                return true;
            }
        }
        return false;
    }

    private static void robotTurn(char[][] map, int userCounter, int[][] userX, int[][] userY) {
        // TODO: 14.04.2020 random

        int robotX;
        int robotY;

        for (int i = (userCounter - 1); i > (userCounter - 2); i--) {
            if (userCounter == 1) {
                robotX = getRandom(userX[0][i]);
                robotY = getRandom(userY[0][i]);
                if (map[robotX][robotY] != EMPTY) {
                    robotTurn(map, userCounter, userX, userY);
                }
                if (
                    map[robotX][robotY] == EMPTY) {
                    map[robotX][robotY] = DOT_O;
                    return;
                }
            }
            else {
                robotX = getRobotCoordinate(userX[0][i], userX[0][i - 1]);
                robotY = getRobotCoordinate(userY[0][i], userY[0][i - 1]);
                if (map[robotX][robotY] == EMPTY) {
                    map[robotX][robotY] = DOT_O;
                    return;
                }
            }
        }
    }

    private static int getRobotCoordinate(int userLastCoordinate, int userPrevCoordinate) {
        int robotCoordinate;

//  TODO: 17.04.2020 Дописать условия сравнения двух последовательных Х, когда они не находяться рядом друг с другом
        if (userLastCoordinate == 0 &&
                userLastCoordinate > userPrevCoordinate) {
            robotCoordinate = userPrevCoordinate - 1;
            return robotCoordinate;
        }
        if (userLastCoordinate == 0 &&
            userLastCoordinate < userPrevCoordinate) {
            robotCoordinate = userPrevCoordinate - 1;
            return robotCoordinate;
        }
        if (userLastCoordinate == 4 &&
            userLastCoordinate < userPrevCoordinate) {
            robotCoordinate = userLastCoordinate - 1;
            return robotCoordinate;
        }
        if (userLastCoordinate == 4 &&
                userLastCoordinate > userPrevCoordinate) {
            robotCoordinate = userLastCoordinate;
            return robotCoordinate;
        }
        if (userLastCoordinate == userPrevCoordinate) {
            robotCoordinate = userLastCoordinate;
            return robotCoordinate;
        }
        if (userLastCoordinate > userPrevCoordinate) {
            robotCoordinate = userLastCoordinate + 1;
            return robotCoordinate;
        }
        if (userLastCoordinate < userPrevCoordinate) {
            robotCoordinate = userLastCoordinate - 1;
            return robotCoordinate;
        }
        return 0;
    }

    public static int getRandom (int userCoordinate) {
        int min = userCoordinate - 1;
        int max = userCoordinate + 1;
        int rand;

        if (userCoordinate == 0) {
            rand = 1;
        } else if (userCoordinate == 4) {
            rand = 3;
        }
        else {
            rand = min + (int)(Math.random() * ((max - min) + 1));
        }

        System.out.println(rand);
        return rand;
    }





    public static void startGame() {
        int userCounter = 0;
        char [][] map = getInitMap(5);
        System.out.println("Приветствую вас в игре Крестики Нолики!");
        System.out.println("Перед вами поле:");
        printMap(map);
        System.out.println("Вы играете Крестиками!");
        System.out.println("Чтобы сделать ход, введите номер строки и номер столбца на поле:");
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Ваш ход:");
            int x = in.nextInt(), y = in.nextInt();

            if (isCellValid(map, x, y)) {
                humanTurn(map, x, y);
                printMap(map);
                userX[0][userCounter] = x-1;
                userY[0][userCounter] = y-1;
                userCounter++;

                // TODO: 14.04.2020 отследить ничью
                if (noEmptyCells(map)) {
                    System.out.println("Ничья!");
                    System.out.println("Хотите сыграть еще раз? (1 - Да, 2 - Нет).");
                    int isNewGame = in.nextInt();
                    if (isNewGame == 1) {
                        startGame();
                    } else {
                        System.out.println("До свиданья!");
                        return;
                    }
                }

                if (checkVictory(map, DOT_X, VICTORY_CONDITION)) {
                    System.out.println("Вы победили!");
                    // TODO: 14.04.2020 что делать дальше???
                    System.out.println("Хотите сыграть еще раз? (1 - Да, 2 - Нет).");
                    int isNewGame = in.nextInt();
                    if (isNewGame == 1) {
                        startGame();
                    } else {
                        System.out.println("До свиданья!");
                        return;
                    }
                }

                System.out.println("Ход компьютера:");
                robotTurn(map, userCounter, userX, userY);
                printMap(map);
                if (checkVictory(map, DOT_O, VICTORY_CONDITION)) {
                    System.out.println("Вы проиграли.");
                    // TODO: 14.04.2020 что делать дальше???
                    System.out.println("Хотите сыграть еще раз? (1 - Да, 2 - Нет).");
                    int isNewGame = in.nextInt();
                    if (isNewGame == 1) {
                        startGame();
                    } else {
                        System.out.println("До свиданья!");
                        break;
                    }
                }
//                printMap(map);
            } else {
                System.out.println("Введены некорректные данные! Введите еще раз");
                // TODO: 14.04.2020 user friendly help comments
            }
        }
    }

    private static boolean noEmptyCells(char[][] map) {
        boolean isFull;
        isFull = Arrays.asList(map).contains(EMPTY);
        System.out.println(isFull);
        return isFull;
//        for (char[] line: map) {
//            for (char cell: line) {
//                if (cell = EMPTY)
//            }
//
//        }
    }

    public static void main(String[] args) {

        startGame();

    }

}