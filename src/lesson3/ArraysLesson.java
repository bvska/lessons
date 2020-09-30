package lesson3;

import java.util.Arrays;

public class ArraysLesson {
    public static void main(String[] args) {
        // массивы предназначены для хранения данных
        // одного типа
        // длина массива задается при его создании
        // длину массива нельзя изменить

        // Объявление переменной массива: тип_данных[] имя_переменной
        int[] ints1;
        // int ints1[];

        // Создание массива
        // new int[длина_массива];
        ints1 = new int[5];
        // создан массив на 5 элементов типа int и заполнен
        // значениями по умолчанию
        // целые чила: 0
        // числа с плавающей точкой: 0.0
        // boolean: false
        // char: '\u0000' ()
        // ссылочные типы: null
        int[] ints2 = {45, 90, 12, -88, 54, 8, -221};

        // ints2 = {45, 90, 12, -88, 54, 8, -221};
        ints2 = new int[]{45, 12, 8, -221};

        // доступ к элементам массива осуществляется по индексу:
        // имя_массива[индекс]
        int ints2Elem = ints2[3]; // получили элемент по индексу 3
        // из массива ints2
        ints2[1] = 4147;

        // обращение к несуществующему элементу массива
        // приведет к java.lang.ArrayIndexOutOfBoundsException

        // длина массива
        System.out.println(ints2.length); // 4 int

        // вывод в консоль
        // System.out.println(ints2);
        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(ints2));

        // перебор элементов массива
        ints2 = new int[]{60, -80, 0, 200, 44};

        // iter + Enter
        for (int elem : ints2) {
            System.out.println("elem = " + elem);
            elem *= 2; // нельзя изменить значение элементов массива
        }
        System.out.println(Arrays.toString(ints2));

        // fori
        ints2 = new int[]{60, -80, 0, 200, 44};

        for (int i = 0; i < ints2.length; i++) {
            System.out.println("ints2[i] = " + ints2[i]);
            ints2[i] = 90;
        }
        System.out.println(Arrays.toString(ints2));

        // сравнение массивов
        ints1 = new int[]{60, -80, 0, 200, 44};
        ints2 = new int[]{60, 80, 0, 200, 44};

        System.out.println(Arrays.equals(ints1, ints2));
        // compare, compareUnsigned, mismatch
        System.out.println(Arrays.compareUnsigned(ints1, ints2));
        ;

        // сортировка массива
        Arrays.sort(ints1); // Arrays.sort(ints1, [from, to));
        Arrays.parallelSort(ints2);

        // поиск в отсортированном массиве
        ints1 = new int[]{-90, -10, 0, 12, 45, 1231};
        System.out.println(Arrays.binarySearch(ints1, -10)); // 1
        System.out.println(Arrays.binarySearch(ints1, 89)); // -6
        System.out.println(Arrays.binarySearch(ints1, -91)); // -1

        // копирование массивов
        ints1 = new int[]{60, -80, 0, 200, 44, 90, 111};
        // int[] newInts = ints1;
        // вариант 1 имя_массива.clone()
        int[] cloneInts = ints1.clone();
        // 2 вариант System.arraycopy(
        // из_какого_массива, с_какого_индекса
        // в какой_массив
        // на_какую_позицию
        // количество_элементов
        // );
        int[] newInts = new int[15];
        System.arraycopy(ints1, 0, newInts, 4, 3);
        System.out.println(Arrays.toString(newInts));

        // 3 вариант Arrays.copyOf()
        ints1 = new int[]{60, -80, 0, 200, 44, 90, 111};
        int[] copyInts = Arrays.copyOf(ints1, 3);
        System.out.println(Arrays.toString(copyInts));

        int[][] ints3 = new int[3][4];
        // [[0,0,0,0], [0,0,0,0], [0,0,0,0]]
        System.out.println(Arrays.deepToString(ints3));

        int[][] ints4 = new int[3][];
        // [null, null, null]
        // [[0], [0,0], [0,0,0]]
        ints4[0] = new int[1];
        ints4[1] = new int[2];
        ints4[2] = new int[3];

        int[][] ints5 = {
                {2, 3, 45},
                {6, 7, 81, 8},
                {16, -7, 801, 228}
        };

        for (int i = 0; i < ints5.length; i++) {
            System.out.println(Arrays.toString(ints5[i]));
            for (int j = 0; j < ints5[i].length; j++) {
                System.out.println(ints5[i][j]);
                ints5[i][j] *= ints5[i][j];
            }
        }

    }
}
