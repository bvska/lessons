public class FirstLesson {
    //  ctrl + /   однострочной комментарий
   /*
     ctrl + shift + /   многострочный комментарий
    */
    // ctrl + alt + L выравнивание кода


    // точка входа в программу
    // метод main  (psvm + Enter)
    public static void main(String[] args) {
        // sout
        // консольный вывод
        System.out.println("FirstLesson");

        // Типы данных:
        //1. примитивные типы данных
        //2. ссылочные типы данных

        //1. примитивные типы данных
        // для хранения целых чисел
        // тип byte (1 байт) от -128 до 127

        // объявление переменных
        // тип_данных имя_переменной;
        byte byteVar;
        byteVar = 35; // присвоили переменной значение 35


        byteVar = 12; // переопределили значение переменной

        byte byteVar2 = 10;

        byte byteVar3, byteVar4;
        byte byteVar5 = 12, byteVar6 = 22;

//        byte byteVar;

        // short (2 байта) от -32768 до 32767
        short shortVar = -155;

        // int (4 байта) -2147483648 до 2147483647
        int intVar = 5340;
        int intVar2 = 1_000_000;
        int intVar3 = 1000000;

        // long (8 байт)
        long longVar = 3000000000L;  // L l

        // long longVar = 3000000000 воспринимается,
        // как int, поэтому нужно явно указать
        // long longVar = 3000000000L;

        // числа с плавающей точкой
        // float (4 байта)

        float floatVar = 5.7f; // F f

        // double (8 байт)
        double doubleVar = 10.88;

        // char (2 байта)
        // до 0 до 65535

        // boolean true / false
        boolean trueVar = true;
        boolean falseVar = false;

        // Приведение типов:
        // автоматическое приведение типов
        byte someByte = 100;
        int someInt = someByte;

        // явное приведение типов
        someInt = 200;
        someByte = (byte) someInt;

        // операторы

        // операторы присваивания
        // = | += | -= | *= | /= | %=

        someByte = 3;
        // someByte = someByte * 7;
        someByte *= 7;

        someInt = 10;
        someInt = someInt + 20;
        someInt += 20;

        System.out.println(someInt);

        // арифметические операторы
        // + | - | * | / | % (остаток от деления)

        int a = 10;
        int b = 90;

        int c= a + b;
        // sout
        System.out.println(c); // 100

        short x = 56;
        short y = 77;

        // short z = x + y;
        int res = x + y;

        short z = (short) (x + y);


        int n = 100;
        double m = -200.6;

        //int zeroDiv = n / 0;
        //System.out.println(zeroDiv);

        double zeroDiv2 = m / 0;
        System.out.println(zeroDiv2);

        System.out.println(zeroDiv2 + 90);

        a = 7;
        b = 2;
        c = a / b;

        System.out.println(c);



        // операторы сравнения
        // результат работы операторов сравнения true или false
        // < | > | <= | >= | != | ==

        System.out.println( 6 < 22 ); // true
        System.out.println( 6 > 22 ); // false
        System.out.println( 55 >= 55 ); // true
        System.out.println( 55 <= 55  ); // true
        System.out.println( 2 != 55  ); // true
        System.out.println( 2 == 55  ); // false

        System.out.println(9 % 3); // 0
        System.out.println(9 % 2); // 1

        // тернарный оператор ?
        //переменная = (условие) ? выражение 1 : выражение 2;
        int k = 4;
        int l = 8;

        int result = (k < l) ? k + l : k - l;

        // дана переменная типа int
        // если значение переменной четное, тернарный оператор
        // возвращает результат деления этой переменной на 2,
        // в противном случае результат умножения на 2
        // результат вывести в консоль




    }
}
