package lesson5;

import java.util.Arrays;
import java.util.Objects;

public class StringLesson {
    public static void main(String[] args) {
        // char - один 16 битный символ Unicode
        // от 0 до 65536 / от '\u0000' до '\uffff'

        // можно задать:
        char char1 = 'J'; // сам символ в одинарных кавычках
        char char2 = 74; // номер символа
        char char3 = '\u0044'; // шеснадцатиричное представление
        // в escape последовательности
        System.out.print(char1); // J
        System.out.print(char2); // J
        System.out.print(char3); // D

        System.out.println("\nСтроки");
        // Строка - упорядоченная последовательность символов
        // Строки - объекты (ссылочный тип) класса String
        // Строки задаются:
        //     в ""
        //     используя new String() использовать, если создание через ""
        //     не подходит
        // Строки нельзя изменить, можно только создать новую
        // на основе существующей
        // Все строковые литералы,
        // например System.out.println("Строки"); реализованы
        // как экземпляры String

        char[] jjdChars = {'\u004A', '\u004A', '\u0044'};
        String jjdString = new String(jjdChars);
        jjdString = "\u004A\u004A\u0044";
        System.out.println(jjdString); // JJD
        System.out.println(jjdString.length()); // 3
        System.out.println(jjdString.codePoints().count()); // 3

        char[] frogChars = {'\uD83D', '\uDC38'};
        String frogString = new String(frogChars);
        frogString = "\uD83D\uDC38";
        System.out.println(frogString); // 🐸
        System.out.println(frogString.length()); // 2
        System.out.println(frogString.codePoints().count()); // 1

        // каждый символ Unicode может быть представлен
        // одним или парой (суррогатная пара) чаров

        // хранение строк до java 9: массив char[] в кодировке UTF-16,
        // при этом каждый char был представлен двумя байтами

        // хранение строк начиная с java9 (компактные строки):
        // массив byte[] + кодировка UTF-16 или LATIN1

        System.out.println("Пул строк");
        // пул строк (находится в heap памяти) хранит только одну
        // копию каждого строкового литерала
        String string1 = "Строка";
        String string2 = "Строка";
        String string3 = new String("Строка");

        System.out.println(string1 == string2); // true
        System.out.println(string1 == string3); // false

        System.out.println("Метод intern()");
        String internStr = string3.intern(); // сохранение строки
        // в пуле строк/возвращение ссылки на существующий объект
        System.out.println(string1 == internStr); // true
        System.out.println(string3 == internStr); // false
        System.out.println(string2 == internStr); // true

        System.out.println("Сравнение строк - equals()");
        string1 = "Строка";
        string2 = "Строка";
        System.out.println(string1.equals(string2)); // true
        System.out.println("строка".equals(string1)); // false
        System.out.println("строка".equalsIgnoreCase(string1)); // true

        // вариант "строка".equals(string1) лучше, чем
        // string1.equals("строка")

        String nullString = null;
        System.out.println("строка".equals(nullString)); // false
        //System.out.println(nullString.equals("строка")); // java.lang.NullPointerException

        System.out.println(nullString == null); // true
        System.out.println(null != null); // false
        System.out.println(Objects.nonNull(nullString)); // false
        System.out.println(Objects.isNull(nullString)); // true

        // дан массив animals {"кот", "пёс", "гусь"}
        // создать новый массив
        // (количество элементов, больше чем у animals в 2 раза)
        // заполнить его рандомными значениями из массива animals

        String[] animals = {"кот", "пёс", "гусь"};
        String[] newArr = new String[animals.length * 2];

        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = animals[(int) (Math.random() * animals.length)];
        }
        System.out.println(Arrays.toString(newArr));

        System.out.println("Конкатенация строк");
        string1 = "Java";
        string2 = "Python";

        // 1 вариант: +
        String concatStr = string1 + " :: " + string2;
        System.out.println(concatStr);

        // 2 вариант: строка.concat()
        concatStr = string1.concat(" :: ").concat(string2);
        System.out.println(concatStr);

        // 3 выриант: String.join(раздельтель, строка1, строка2, строкаN);
        concatStr = String.join(" :: ", string1, string2);
        System.out.println(concatStr);

        System.out.println("Буферизированные строки");
        concatStr = "";
        for (int i = 0; i < 10; i++) {
            concatStr += i + " ";
        }
        System.out.println(concatStr);

        // StringBuilder - работает быстрее, но не является потокобезопасным
        // StringBuffer - работает медленнее, но потокобезопасен

        StringBuilder sb = new StringBuilder(string1);
        sb.append(" :: ").append(string2);
        concatStr = sb.toString();
        System.out.println(concatStr);

        concatStr = "";
        sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i).append(" ");
        }
        concatStr = sb.toString();
        System.out.println(concatStr);

        // сравнение строк
        // C:1057 c:1089
        System.out.println("строка".compareTo("строка")); // 0
        System.out.println("строка".compareTo("Cтрока")); // 32
        System.out.println("Строка".compareTo("строка")); // -32
        System.out.println("строка".compareToIgnoreCase("Cтрока")); // 0

        // start / end
        string1 = "JJD";
        System.out.println(string1.startsWith("JJ")); // true
        System.out.println(string1.startsWith("D", 2)); // true
        System.out.println(string1.endsWith("d")); // false

        // приведение к регистру
        string1 = string1.toLowerCase();
        string1 = string1.toUpperCase();

        // замена
        string1 = "JJD";
        string1 = string1.replace("J", "!"); // !!D
        System.out.println(string1);
        string1 = "JJD";
        string1 = string1.replaceAll("J", "!"); // !!D
        System.out.println(string1);
        string1 = "JJD";
        string1 = string1.replaceFirst("J", "!");
        System.out.println(string1);

        System.out.println(string1.contains("D"));

        string1 = "Java, Python, PHP";
        String[] strings = string1.split(", ");
        System.out.println(Arrays.toString(strings));

        // убрать пробелы trim / strip / stripLeading / stripTrailing
        System.out.println("\u3000");
        System.out.println("\u0020");
        // trim - убирает пространсво меньше или равно u0020
        // strip (J11) - убирает любое пространсво
        // stripLeading (J11) - убирает любое пространсво (начало строки)
        // stripTrailing (J11) - убирает любое пространсво (конец строки)

        System.out.printf("строка '%s', '%f'\n", " qwe  ".trim(), 34.44);
        System.out.printf("строка '%f'\n", 11.6);
        System.out.printf("строка '%d'\n", 566);

    }
}
