package com.ifmo.jjd.lesson15.collection;

import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        Student student1 = new Student("Петр", "Алексеев", 18);
        Student student2 = new Student("Екатерина", "Еремина", 20);
        Student student3 = new Student("Денис", "Попов", 22);
        Student student4 = new Student("Петр", "Попов", 22);

        // переопределить методы toString, equals и hashCode в классе Student
        // Колекции используются для хранения наборов данных, различаются:
        // 1. безопасностью использования в многопоточных средах
        // 2. возможностью хранить дублирующиеся элементы
        // 3. возможностью хранить элементы в том порядке, в которм они
        // были добавлены в коллекцию
        // 4. возможностью хранить элементы в отсортированном виде
        // и тп

        System.out.println("---LinkedList---");
        // Особенности LinkedList
        // 1. порядок элементов гарантирован
        // 2. можно хранить null
        // 3. допускает хранение дублирующихся элементов

        // объекту list будут доступны только методы, перечиленные
        // в интерфейсе List
        List<Student> list = new LinkedList<>();
        // будут collection будут доступны только методы, перечиленные
        // в интерфейсе Collection
        Collection<Student> collection = new LinkedList<>();

        LinkedList<Student> students = new LinkedList<>();
        // добавление элемента в конец списка
        students.add(student1);
        students.add(student2);
        students.add(student1);
        // добавление элемента на указанную позицию
        students.add(1, student3);
        // обращение к несуществующему индексу:
        // java.lang.IndexOutOfBoundsException
        // students.add(90, student3);
        students.addFirst(null); // добавление в начало списка
        students.addLast(student2); // добавление в конец списка

        System.out.println(students);

        System.out.println(students.size()); // размер списка

        // получение элементов:
        // java.lang.IndexOutOfBoundsException, если индекса не существует
        System.out.println(students.get(0)); // по индексу

        // java.util.NoSuchElementException, если элемент не найден
        System.out.println(students.getFirst()); // первого

        // java.util.NoSuchElementException, если элемент не найден
        System.out.println(students.getLast()); // последнего

        // удаление элементов
        students.removeFirst(); // удаление первого
        students.removeLast(); // удаление последнего
        students.remove(student4); //
        students.remove(null);
        students.remove(1);

        System.out.println("после удаления: " + students);

        System.out.println("---ArrayList---");
        // В большинстве случаев предпочтение отдется ArrayList,
        // а не LinkedList
        // Особенности ArrayList:
        // 1. реализован на основе массива
        // 2. можно хранить null
        // 3. допускает хранение дублирующихся элементов
        // 4. порядок элементов гарантирован

        // по умолчанию создается массив на 10 элементов
        ArrayList<Student> studentArrayList = new ArrayList<>();
        // можно сразу задать изначальную емкость
        studentArrayList = new ArrayList<>(30);
        System.out.println(studentArrayList.size()); // 0
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(1, student1);
        studentArrayList.add(null);

        System.out.println(studentArrayList.size()); // 4

        studentArrayList.trimToSize();
        System.out.println(studentArrayList.size()); // 4

        // получить часть списка, указав
        // [начальную; конечную) позиции
        System.out.println("sublist: " +
                studentArrayList.subList(1, 3)); // List

        // получение элементов по индексу
        System.out.println(studentArrayList.get(2));

        studentArrayList.remove(1); // ссылка
        studentArrayList.remove(student1); // true - false

        Student[] arr = {student1, student2};
        studentArrayList.removeAll(Arrays.asList(arr));

        System.out.println("после удаления: " + studentArrayList);

        // метод remove(Object o) использует метод equals

        arr = new Student[] {student1, student2};
        studentArrayList.addAll(Arrays.asList(arr));

        // TODO::
        //  ArrayList vs LinkedList:
        //  добавление, получение, удаление
        //  начало списка
        //  середина списка
        //  конец списка
        //  System.currentTimeMillis();

        // ArrayList из элементов LinkedList
        studentArrayList = new ArrayList<>(students);
        // LinkedList из элементов ArrayList
        students = new LinkedList<>(studentArrayList);

        System.out.println("---Set---");
        // Особенности Set:
        // 1. используется для хранения уникальных элементов
        // 2. обязательно дб переопределены методы equals и hashCode

        // Особенности HashSet:
        // 1. основан на hash таблице
        // 2. порядок хранения элементов может отличаться от порядка добавления
        // 3. можно хранить null (всегда будет на 1м месте)

        // Особенности LinkedHashSet:
        // 1. основан на hash таблице
        // 2. порядок хранения элементов не отличается от порядка добавления
        // 3. медленне, чем HashSet
        // 4. можно хранить null

        HashSet<Student> studentHashSet = new HashSet<>();
        studentHashSet = new HashSet<>(studentArrayList);
        studentHashSet.add(student1); // studentHashSet.addAll(students);
        studentHashSet.remove(student2); // studentHashSet.removeAll()

        System.out.println(studentHashSet);

        // Особенности TreeSet
        // 1. хранит объекты в отсортированном порядке
        // 2. основан на алгоритме красно-черного дерева
        // 3. нельзя хранить null

        // для добавления элементов в TreeSet необходимо:
        // 1. чтобы класс (экземпляры которого будут храниться в сете)
        // реализовал интерфейс Comparable и его метод compareTo

        // 2. пердать в конструктор TreeSet объект типа Comparator
        TreeSet<Student> studentTreeSet = new TreeSet<>();
        studentTreeSet.add(student1);
        studentTreeSet.add(student2);
        System.out.println(studentTreeSet.size()); // 1

        Comparator<Student> studentComparator = new NameComparator()
                .thenComparing(new AgeComparator());
        TreeSet<Student> studentTreeSet2 = new TreeSet<>(studentComparator);
        studentTreeSet2.add(student1);
        studentTreeSet2.add(student2);

//        Collections.sort(students, studentComparator);

        // перебор коллекции
        for (Student student: students) {
            System.out.println(student.getAge());
            student.setSurname("SURNAME");
            // java.util.ConcurrentModificationException
            // students.remove(student);
        }

         // Collections.copy();
        // iterator -  ссылка на итератор коллекции students
        Iterator<Student> iterator = students.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getAge() < 18) {
                iterator.remove();
            }
        }

    }

}
