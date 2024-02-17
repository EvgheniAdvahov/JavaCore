package ru.geekbrains.core.lesson2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final int WIN_COUNT = 4; // Выигрышная комбинация
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;

    /**
     * Инициализация объектов игры
     */
    static void initialize() {
        fieldSizeX = 5;
        fieldSizeY = 5;
        field = new char[fieldSizeX][fieldSizeY];

        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Печать текущего состояния игрового поля
     */
    static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print("-" + (i + 1));
        }
        System.out.println("-");

        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Ход игрока (человека)
     */
    static void humanTurn() {
        int x;
        int y;
        do {
            System.out.print("Введите координаты хода X и Y\n(от 1 до 3) через пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Ход игрока (компьютера)
     */
    static void aiTurn() {
        if (AiHorizontalCheck()) {
            return;
        }
        if (AiVerticalCheck()) {
            return;
        }
        if (AiMainDiagonalCheck()) {
            return;
        }
        if (AiSecondDiagonalCheck()) {
            return;
        }
        //        ########################
        int i;
        int j;
        do {
            i = random.nextInt(fieldSizeX);
            j = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(i, j));
        field[i][j] = DOT_AI;
    }

    /**
     * Проверка AI по горизонтали
     */
    static boolean AiHorizontalCheck() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                // pattern *XX*
                if (y - 1 >= 0 && y + 2 < fieldSizeY) {
                    if (field[x][y] == DOT_HUMAN
                            && field[x][y + 1] == DOT_HUMAN
                            && field[x][y + 2] == DOT_EMPTY
                            && field[x][y - 1] == DOT_EMPTY) {
                        field[x][y - 1] = DOT_AI;
                        return true;
                    }
                }
                // pattern XXX*
                if (y + 3 < fieldSizeY) {
                    if (field[x][y] == DOT_HUMAN
                            && field[x][y + 1] == DOT_HUMAN
                            && field[x][y + 2] == DOT_HUMAN
                            && field[x][y + 3] == DOT_EMPTY) {
                        field[x][y + 3] = DOT_AI;
                        return true;
                    }
                }
                // pattern XX*XX
                if (y + 4 <= fieldSizeY) {
                    if (field[x][y] == DOT_HUMAN
                            && field[x][y + 1] == DOT_HUMAN
                            && field[x][y + 2] == DOT_EMPTY
                            && field[x][y + 3] == DOT_HUMAN
                            && field[x][y + 4] == DOT_HUMAN
                    ) {
                        field[x][y + 2] = DOT_AI;
                        return true;
                    }
                }
                // pattern *XXX
                if (y - 1 >= 0 && y + 2 < fieldSizeY) {
                    if (field[x][y] == DOT_HUMAN
                            && field[x][y + 1] == DOT_HUMAN
                            && field[x][y + 2] == DOT_HUMAN
                            && field[x][y - 1] == DOT_EMPTY
                    ) {
                        field[x][y - 1] = DOT_AI;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Проверка AI по вертикали
     */
    static boolean AiVerticalCheck() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                // pattern *
                //         X
                //         X
                //         *
                if (x - 1 >= 0 && x + 2 < fieldSizeX) {
                    if (field[x][y] == DOT_HUMAN
                            && field[x + 1][y] == DOT_HUMAN
                            && field[x + 2][y] == DOT_EMPTY
                            && field[x - 1][y] == DOT_EMPTY) {
                        field[x - 1][y] = DOT_AI;
                        return true;
                    }
                }
                // pattern X
                //         X
                //         X
                //         *
                if (x + 3 < fieldSizeX) {
                    if (field[x][y] == DOT_HUMAN
                            && field[x + 1][y] == DOT_HUMAN
                            && field[x + 2][y] == DOT_HUMAN
                            && field[x + 3][y] == DOT_EMPTY) {
                        field[x + 3][y] = DOT_AI;
                        return true;
                    }
                }
                // pattern X
                //         X
                //         *
                //         X
                //         X
                if (x + 4 <= fieldSizeX) {
                    if (field[x][y] == DOT_HUMAN
                            && field[x + 1][y] == DOT_HUMAN
                            && field[x + 2][y] == DOT_EMPTY
                            && field[x + 3][y] == DOT_HUMAN
                            && field[x + 4][y] == DOT_HUMAN
                    ) {
                        field[x + 2][y] = DOT_AI;
                        return true;
                    }
                }
                // pattern *
                //         X
                //         X
                //         X
                // pattern *XXX
                if (x - 1 >= 0 && x + 2 < fieldSizeX) {
                    if (field[x][y] == DOT_HUMAN
                            && field[x + 1][y] == DOT_HUMAN
                            && field[x + 2][y] == DOT_HUMAN
                            && field[x - 1][y] == DOT_EMPTY
                    ) {
                        field[x - 1][y] = DOT_AI;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Проверка AI по главной диагонали
     */
    static boolean AiMainDiagonalCheck() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                // pattern   *
                //         X
                //       X
                //     *
                if (y - 2 >= 0 && y + 1 < fieldSizeY && x + 2 < fieldSizeX && x - 1 >= 0) {
                    if (field[x][y] == DOT_HUMAN
                            && field[x + 1][y - 1] == DOT_HUMAN
                            && field[x + 2][y - 2] == DOT_EMPTY
                            && field[x - 1][y + 1] == DOT_EMPTY
                    ) {
                        field[x - 1][y + 1] = DOT_AI;
                        return true;
                    }
                }
                // pattern   X
                //         X
                //       X
                //     *
                if (x + 3 < fieldSizeX && y - 3 >= 0) {
                    if (field[x][y] == DOT_HUMAN
                            && field[x + 1][y - 1] == DOT_HUMAN
                            && field[x + 2][y - 2] == DOT_HUMAN
                            && field[x + 3][y - 3] == DOT_EMPTY
                    ) {
                        field[x + 3][y - 3] = DOT_AI;
                        return true;
                    }
                }
                // pattern    X
                //          X
                //        *
                //      X
                //    X
                if (x + 4 < fieldSizeX && y - 4 >= 0) {
                    if (field[x][y] == DOT_HUMAN
                            && field[x + 1][y - 1] == DOT_HUMAN
                            && field[x + 2][y - 2] == DOT_EMPTY
                            && field[x + 3][y - 3] == DOT_HUMAN
                            && field[x + 4][y - 4] == DOT_HUMAN
                    ) {
                        field[x + 2][y - 2] = DOT_AI;
                        return true;
                    }
                }
                // pattern   *
                //         X
                //       X
                //     X
                if (x + 2 < fieldSizeX && y - 2 >= 0 && x - 1 >= 0 && y + 1 < fieldSizeY) {
                    if (field[x][y] == DOT_HUMAN
                            && field[x + 1][y - 1] == DOT_HUMAN
                            && field[x + 2][y - 2] == DOT_HUMAN
                            && field[x - 1][y + 1] == DOT_EMPTY
                    ) {
                        field[x - 1][y + 1] = DOT_AI;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Проверка AI по второстепенной диагонали
     */
    static boolean AiSecondDiagonalCheck() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                // pattern   *
                //             X
                //               X
                //                 *
                if (x - 1 >= 0 && y - 1 >= 0 && x + 2 < fieldSizeX && y + 2 < fieldSizeY) {
                    if (field[x][y] == DOT_HUMAN
                            && field[x + 1][y + 1] == DOT_HUMAN
                            && field[x + 2][y + 2] == DOT_EMPTY
                            && field[x - 1][y - 1] == DOT_EMPTY
                    ) {
                        field[x - 1][y - 1] = DOT_AI;
                        return true;
                    }
                }
                // pattern   X
                //             X
                //               X
                //                 *
                if (x + 3 < fieldSizeX && y + 3 < fieldSizeY) {
                    if (field[x][y] == DOT_HUMAN
                            && field[x + 1][y + 1] == DOT_HUMAN
                            && field[x + 2][y + 2] == DOT_HUMAN
                            && field[x + 3][y + 3] == DOT_EMPTY
                    ) {
                        field[x + 3][y + 3] = DOT_AI;
                        return true;
                    }
                }
                // pattern   X
                //             X
                //               *
                //                 X
                //                   X
                if (x + 4 < fieldSizeX && y + 4 < fieldSizeY) {
                    if (field[x][y] == DOT_HUMAN
                            && field[x + 1][y + 1] == DOT_HUMAN
                            && field[x + 2][y + 2] == DOT_EMPTY
                            && field[x + 3][y + 3] == DOT_HUMAN
                            && field[x + 4][y + 4] == DOT_HUMAN
                    ) {
                        field[x + 2][y + 2] = DOT_AI;
                        return true;
                    }
                }
                // pattern   *
                //             X
                //               X
                //                 X
                if (x - 1 >= 0 && y - 1 >= 0 && x + 2 < fieldSizeX && y + 2 < fieldSizeY) {
                    if (field[x][y] == DOT_HUMAN
                            && field[x + 1][y + 1] == DOT_HUMAN
                            && field[x + 2][y + 2] == DOT_HUMAN
                            && field[x - 1][y - 1] == DOT_EMPTY
                    ) {
                        field[x - 1][y - 1] = DOT_AI;
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * Проверка, является ли ячейка игрового поля пустой
     *
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка валидности координат хода
     *
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Поверка на ничью (все ячейки игрового поля заполнены фишками человека или компьютера)
     *
     * @return
     */
    static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }

    /**
     * TODO: Переработать в рамках домашней работы
     * Метод проверки победы
     *
     * @param dot фишка игрока
     * @return результат проверки победы
     */
    static boolean checkWin(char dot) {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                // Проверка по горизонтали
                if (checkWin1(x, y, dot))
                    return true;
                // Проверка по вертикалям
                if (checkWin2(x, y, dot))
                    return true;
                // Проверка по диагонали вниз
                if (checkWin3(x, y, dot))
                    return true;
                // Проверка по диагонали вверх
                if (checkWin4(x, y, dot))
                    return true;
            }
        }

//        // Проверка по трем горизонталям
//        if (field[0][0] == dot && field[0][1] == dot && field[0][2] == dot) return true;
//        if (field[1][0] == dot && field[1][1] == dot && field[1][2] == dot) return true;
//        if (field[2][0] == dot && field[2][1] == dot && field[2][2] == dot) return true;
//
//        // Проверка по трем вертикалям
//        if (field[0][0] == dot && field[1][0] == dot && field[2][0] == dot) return true;
//        if (field[0][1] == dot && field[1][1] == dot && field[2][1] == dot) return true;
//        if (field[0][2] == dot && field[1][2] == dot && field[2][2] == dot) return true;
//
//        // Проверка по двум диагоналям
//        if (field[0][0] == dot && field[1][1] == dot && field[2][2] == dot) return true;
//        if (field[0][2] == dot && field[1][1] == dot && field[2][0] == dot) return true;

        return false;
    }

    static boolean checkWin1(int x, int y, char dot) {
        if (y + 3 < fieldSizeY) {
            if (field[x][y] == dot && field[x][y + 1] == dot && field[x][y + 2] == dot && field[x][y + 3] == dot)
                return true;
        }
        return false;
    }

    static boolean checkWin2(int x, int y, char dot) {
        if (x + 3 < fieldSizeX) {
            if (field[x][y] == dot && field[x + 1][y] == dot && field[x + 2][y] == dot && field[x + 3][y] == dot)
                return true;
        }
        return false;
    }

    static boolean checkWin3(int x, int y, char dot) {
        if (x + 3 < fieldSizeY && y + 3 < fieldSizeX) {
            if (field[x][y] == dot && field[x + 1][y + 1] == dot && field[x + 2][y + 2] == dot && field[x + 3][y + 3] == dot)
                return true;
        }
        return false;
    }

    static boolean checkWin4(int x, int y, char dot) {
        if (x - 3 >= 0 && y + 3 < fieldSizeY) {
            if (field[x][y] == dot && field[x - 1][y + 1] == dot && field[x - 2][y + 2] == dot && field[x - 3][y + 3] == dot)
                return true;
        }
        return false;
    }


    /**
     * Проверка состояния игры
     *
     * @param dot фишка игрока
     * @param s   победный слоган
     * @return состояние игры
     */
    static boolean checkState(char dot, String s) {
        if (checkWin(dot)) {
            System.out.println(s);
            return true;
        } else if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        // Игра продолжается
        return false;
    }

    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkState(DOT_AI, "AI победил!"))
                    break;
            }
            System.out.print("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }
    }

}
