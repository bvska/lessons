package com.ifmo.jjd.lesson22;

import com.ifmo.jjd.lesson7.King;
import com.ifmo.jjd.lesson7.Knight;

import java.util.Comparator;
import java.util.function.Function;

public class LambdaCollections {
    public static void main(String[] args) {
        University university = new University();
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());

        System.out.println(university.getCourses());

        // компараторы
        // реализация метода int compare(T o1, T o2)
        // int compare(Course o1, Course o2)
        Comparator<Course> byName = (c1, c2) ->
                c2.getName().compareTo(c1.getName());
        university.getCourses().sort(byName); // Comparator

        // принимает на вход объект типа Function: R apply(T t)
        byName = Comparator.comparing(course -> course.getName());

        byName = Comparator.comparing(Course::getName);

        university.getCourses().sort(byName);

        university.getCourses().sort(
                Comparator.comparing(Course::getName)
                .thenComparing(Course::getDuration)
                .thenComparing(Course::getPrice)
        );
        // удалить, если продолжительность < 2
        university.getCourses().removeIf(course -> course.getDuration() < 2);
        // forEach(Consumer<? super T> action):
        // Consumer void accept(T t)
        university.getCourses().forEach(System.out::println);
        university.getCourses().forEach(course -> course.setDuration(666));

    }
}
//class ByName implements Comparator<Course>{
//
//    @Override
//    public int compare(Course o1, Course o2) {
//        return o2.getName().compareTo(o1.getName());
//    }
//}

