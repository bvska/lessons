package com.ifmo.jjd.lesson23;

import com.ifmo.jjd.lesson22.Course;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
/*
             Stream API - набор методов для работы с данными, как с потоком.
             Позволяет представить различные наборы данных в виде потока,
             а далее: сортировать их, фильтровать, осуществлять поиск по различным критериям,
             кроме этого позволяет создавать новые потоки, создавать коллекции и мапы из потока данных и тд
         */
         /*
             Stream никогда НЕ ХРАНИТ ДАННЫЕ.
             Для сохранения данных из Stream нужно использовать специальные методы.
             Stream никогда НЕ ИЗМЕНЯЕТ ИСТОЧНИК (коллекцию, массив и тд), из которого он создан, все преобразования происходят только в потоках.
             В своей работе методы stream используют лямбда выражения.
         */

         /*
             Для работы с потоками данных необходимо:
             1. получить данные в виде потока - объект типа Stream
             2. выполнить промежуточные операции с потоком данных
             (промежуточные операции обрабатывают данные и возвращают Stream объект)
             3. выполнить терминальную (конечную) операцию
             (терминальная операция обрабатывает данные и завершает работу потока)
             Без терминальной операции промежуточные операции не начнут выполняться!!!
         */

        /*
             Например, получили объект stream, далее выполняем
             промежуточные операции
             stream.операция1() - вернет преобразованный объект stream
                   .операция2() - вернет преобразованный объект stream
                   .операция3()  - вернет преобразованный объект stream
                   .терминальнаяОперация(); // запускает промежуточные операции, данные обрабатываются, стрим закрывается
             основные терминальные операции: forEach / findFirst / findAny / xxxMatch / min / max / collect

         */

         /*
            Методы получения Stream объектов:
             * из коллекций collection.stream();
             * из массива Arrays.stream(arr);
             * из файла Files.lines(path_to_file);
             * из строки string.chars();
             * используя builder:
             * Stream.builder().add(obj1).add(obj2).add(objN).build();
             * Stream.of(1, 4, 7); любой набор данных
         */
         /*
         Распространенные промежуточные операции:
             * filter принимает на вход Predicate, возвращает поток (Stream) с теми объектами, которые удовлетворяют условию
             * map принимает на вход Function, возвращает новый поток (Stream), состоящий из обработанных функцией объектов
             исходного Stream
             * limit принимает на вход int, возвращает новый поток (Stream), состоящий из указанного количества первых объектов
             * skip принимает на вход int, убирает из потока указанной количество первых элементов,
             возвращает новый поток (Stream), состоящий из оставшихся элементов (или пустой Stream)
             * distinct возвращает поток (Stream), состоящий из уникальных объектов
             * sorted возвращает поток (Stream) отсортированных объектов, можно передать компаратор
             * peek принимает на вход Consumer, обрабатывает каждый элемент потока (Stream), возвращает новый поток (Stream)
         */
        /*
        Распространенные терминальные операции:
             * forEach принимает на вход Consumer, применяет переданный метод к каждому объекту потока (Stream),
             порядок Обработки при параллельном выполнении не гарантируется
             * anyMatch принимает на вход Predicate, возвращает true,  если хотя бы один элемент потока соответствует условию
             * allMatch принимает на вход Predicate, возвращает true,  если все элементы потока соответствуют условию
             * noneMatch принимает на вход Predicate, возвращает true,  если ни один элемент потока соответствует условию
             * findFirst возвращает первый элемент потока в Optional контейнере
             * findAny возвращает случайный элемент потока в Optional контейнере
             * min | max принимают на вход компаратор, возвращают минимальный / максимальный элемент потока в Optional контейнере
             * collect принимает на вход Collector, возвращает коллекцию или мапу
         */

        Stream<Integer> integerStream = Stream.of(-504, -312, 12, -1, -45, 0, 0, 23, -9, 1000);
        integerStream.filter(num -> num < 0) //  в Stream останутся только отрицательные элементы
                .map(num -> num * num)
                .limit(3) // вернет новый поток, в который войдут 3 первые элемента предыдущего потока
                .forEach(System.out::println);

        integerStream = Stream.of(-6, -6, 12, 89, 90, 0, 12, 78, 89);
        integerStream.distinct() // в новый поток попадут только уникальные элементы
                .sorted() // сортирует в натуральном порядке
                .forEach(System.out::println);

        // anyMatch - хотя бы один | allMatch - каждый | noneMatch - ни один
        integerStream = Stream.of(78, 811, 903, -133, 0);
        System.out.println(integerStream.anyMatch(num -> num == 0));
        integerStream = Stream.of(78, 811, 903, -133, 0);
        System.out.println(integerStream.allMatch(num -> num > 300));
        integerStream = Stream.of(78, 811, 903, -133, 0);
        System.out.println(integerStream.noneMatch(num -> num > 1000));

        // findFirst - вернет первый элемент в Optional контейнере
        // findAny - вернет произвольный элемент в Optional контейнере

        // Optional - null safe container, J8

        String[] colors = {"white", "black", "green", "yellow", "brown"};

        String firstColor = Arrays.stream(colors)
                .skip(1)
                .filter(color -> color.startsWith("b"))
                .findFirst().orElse("default"); // .get()

        System.out.println(firstColor);

        boolean isPresent = Arrays.stream(colors).findFirst().isPresent();

        // import ...lesson22.Course;
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());

        System.out.println(courses);

        // min | max

        Course minByPrice = courses.stream() // поток из элементов коллекции
                .min(Comparator.comparing(Course::getPrice))
                .orElse(Course.getInstance());


        System.out.println(minByPrice);

        // max максимальный по продолжительности
        Course maxDuration = courses.stream()
                .min(Comparator.comparing(Course::getDuration).reversed())
//                .max(Comparator.comparing(Course::getDuration))
                .orElse(Course.getInstance());

        System.out.println(maxDuration);

        // Получим массив курсов дороже 20000
        Course[] coursesArr = courses.stream()
                .filter(course -> course.getPrice() > 20000)
                .toArray(Course[]::new); // ссылка на конструктор массива Course[]
                // toArray() Object[]
        System.out.println(Arrays.toString(coursesArr));

        // увеличим стоимость курсов продолжительностью < 3 на 5000,
        // получим List
        List<Course> courseList = courses.stream()
                .filter(course -> course.getDuration() < 3)
                .peek(course -> course.setPrice(course.getPrice() + 5000)) // изменение
                .collect(Collectors.toList()); // Collectors.toSet()


        ArrayList<Course> courseArrayList = courses.stream()
                .distinct()
                .sorted(Comparator.comparing(Course::getName))
                .collect(Collectors.toCollection(ArrayList::new)); // ссылка на конструктор любой коллекции

        // получим мапу
        colors = new String[]{"white", "blue", "black", "green", "red", "white"};

        Map<String, Integer> mapFromArr = Arrays.stream(colors)
                .collect(Collectors.toMap(
                        Function.identity(), // Function elem -> elem  ключи
                        String::length, // Function elem -> elem.length() значения
                        Integer::sum // BinaryOperator (val1, val2) -> val1 + val2
                ));
        System.out.println(mapFromArr);


        // flatMap | map
        String[][] strings = {
                {"45", "-7", "89", "10", "89"},
                {"12", "122", "65", "122"},
                {"67", "89", "-1", "200", "3"},
        };

        String[][] stringsMap = Arrays.stream(strings)
                .map(arr -> Arrays.stream(arr).distinct().sorted().toArray(String[]::new))
                .toArray(String[][]::new);
        System.out.println(Arrays.deepToString(stringsMap));

        String[] strings1FlatMap = Arrays.stream(strings)
                .flatMap(arr -> Arrays.stream(arr).distinct().sorted())
                .sorted() //
                .toArray(String[]::new);
        System.out.println(Arrays.deepToString(strings1FlatMap));








    }

}
