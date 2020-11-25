### Занятие 1
1. [Объявление пепеременных, примитивные типы данных, приведение типов](src/lesson1/FirstLesson.java)

#### Обратите внимание на:
1. Последовательность выполнения java программы
2. Что такое JVM, JDK, JRE
3. Переменные 
4. Примитивные типы данных (их размеры и особенности)
5. Приведение типов (автоматическое и явное)
6. Основные операторы

### Занятие 2. 
Операторы управления / Control flow statements:
1. Ветвления / the decision-making statements (if, if-else, switch)
2. Циклы /  the looping statements (for, while, do-while)
3. Операторы ветвления / the branching statements (break, continue)

#### Домашнее задание (никуда не выкладывайте, будем разбирать в начале следующего все вместе):
1. Пользователь! загадывает число в диапазоне от [1 до 100], программа пытается его угадать 
(используйте метод бинарного поиска - деление отрезка на 2). <br> 
Программа может задавать пользователю вопросы: Число равно X? / Число больше X? / Число меньше X? и в зависимоти от ответа пользователя
принимать решения.  <br>
PS: вместо текстовых  ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА

2. Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8 16 32 64 128 ….
3. Создайте программу, выводящую на экран все неотрицательные элементы последовательности 90 85 80 75 70 65 60 ….

4. Написать код, который будет проверять попало ли случайно сгенерированное целое число из отрезка [10;500] в интервал (25;200) и выводить результат в консоль. <br>
Примеры работы программы: <br> 
Число 345 не содержится в интервале (25;200) <br>
Число 110 содержится в интервале (25;200) <br>

5. Задача на синтаксис switch. Дана целочисленная переменная (номер билета от пользователя): <br>
если ее значение 111, 222 или 333 сообщить пользователю, что он получит "Книгу", <br>
если ее значение 444 или 555 сообщить пользователю, что он получит "Телефон", <br>
если ее значение 777 сообщить пользователю, что он получит "Ноутбук". <br>
В остальных случаях сообщить, что приза нет.

6. Программа загадывает число в диапазоне [1;9] <br>
Пользователь вводит число с клавиатуры  <br>
Программа в зависимости от введенного числа выводит в консоль следующее: <br>
 "загаданное число больше" <br>
 "загаданное число меньше" <br>
 "Вы угадали" (программа завершает работу) <br>
 если введен 0, выводит "выход из программы" (программа завершает работу) <br>

### Занятие 3 - 4.
1. [Массивы](src/lesson3/ArraysLesson.java) 

#### Домашнее задание
1. Заполните массив на N элементов случайным целыми числами и выведете максимальное, минимальное и среднее значение
2. Создайте массив из чётных чисел [2;20] и выведите элементы массива в консоль в обратном порядке (20 18 16 ... 4 2)
3. Создайте массив из 11 случайных целых чисел из отрезка [-1;1], выведите массив в консоль.
Определите какой элемент встречается в массиве чаще всего и выведите информацию об этом в консоль.
Если два каких-то элемента встречаются одинаковое количество раз, то не выводите ничего.
4. Разобрать методы класса Arrays: compare, compareUnsigned, mismatch


### Занятие 5 
[Строки](src/lesson5/StringLesson.java)

### Домашнее задание
1. Заполнить массив <br>
Задать массив на N слов. <br>
В цикле считывать с консоли слова (scanner.nextLine()), и добавлять их в массив (добавлять новое слово в массив можно только, если в нем его еще нет). <br>
В итоге в массиве будут только уникальные слова. <br>
Выход их программы по слову exit (его в массив не добавлять) или если массив заполнен <br>
Перед завершением программы, вывести получившийся массив в консоль <br>
2. Найти количество вхождений одной строки в другую. <br>
Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза <br>
3. Написать функцию, которая проверяет, является ли строка палиндромом. <br>
Палиндром — это число, буквосочетание, слово или текст, которые одинаково читаются по буквам или по словам как слева направо, так и справа налево. <br>
Например, 202 - палиндром / fafaf - палиндром / а роза упала на лапу Азора - палиндром <br>
4. Заменить все буквы в слове на строчные, а первую букву на заглавную <br>
Например, дано hello, получаем Hello / дано HeLLO, получаем Hello <br>
5. Найдите самое длинное слово в предложении, при условии, что в предложении все слова разной длины <br>
Например, в "в предложении все слова разной длины" самое длинное слово "предложении" <br>


### Занятие 6
[Классы и объекты](src/com/ifmo/jjd/lesson6)

### Домашнее задание
1. Описать объектную модель Альпинист, Гора, Группа для восхождения на гору. <br> 
Альпинист создаётся с именем (не менее 3 символов) и адресом проживания (не менее 5 символов). <br> 
Гора создаётся с названием (не менее 4 символов), страной (не менее 4 символов) и высотой (не менее 100 метров) <br> 
Группа для восхождения на гору создаётся со следующими характеристиками: <br> 
    идёт набор в группу или нет; <br> 
    массив альпинистов; <br> 
    гора; <br> 
    должна быть возможность добавить альпиниста в группу, если набор ещё идёт <br> 
В методе main (отдельного класса) создать: <br> 
   3 группы для восхождений на 3 различных горы. <br> 
   В первой группе 3 альпиниста (набор закрыт) <br> 
   Во второй и третьей группах по 2 альпиниста (набор в эти группы закрыт) <br> 
При выполнении задания необходимо обращать внимание на модификаторы доступа и выполнять все необходимые проверки. <br> 

2. Список разрешенных продуктов <br> 
Класс Пищевая Ценность <br> 
Свойства: имя продукта / белки / жиры / углеводы / калории <br> 
Минимум 4 конструктора <br> 
Реализовать необходимые проверки входящих данных <br> 
Создать не менее 4 экземпляров данного класса (объектов) <br> 
Класс Мои Продукты <br> 
Свойства: разрешенное количество белков / жиров / углеводов / калорий / список разрешенных продуктов (массив) <br> 
Реализовать метод, который принимает на вход название продукта и добавляет его в список разрешенных, <br> 
если характеристики продукта полностью соответствуют заявленным разрешениям, <br> 
в противном случае сообщить, по какой причине продукт не может быть добавлен в список <br> 
Реализовать метод, который показывает список разрешенных продуктов <br> 
При выполнении задания необходимо обращать внимание на модификаторы доступа и выполнять все необходимые проверки. <br> 

3. Доработать метод public void addColouring(ColouringBook... books) из класса com.ifmo.jjd.lesson6.ColouringShelf <br> 
Метод должен добавлять несколько объектов (books) в массив colouring <br> 

### Занятие 7
[Наследование и интерфейсы](src/com/ifmo/jjd/lesson7)

### Домашнее задание

Задача "Школа":
        
        Класс Ученик 
        создается со следующими характеристиками:
            имя (тип String)
            возраст (тип int)
            изучаемый предмет (тип String)
            уровень знаний (тип int)
        и методом:
            учиться() - уровень знаний ученика повышается
        
        Класс Учитель 
        создается со следующими харатеристиками:
            имя (тип String)
            возраст (тип int)
            преподаваемый предмет (тип String)
        и методом:
            учить(обучаемый) - тип данных обучаемого определить самостоятельно
        
        Класс Директор 
        создается со следующими харатеристиками:
            имя (тип String)
            возраст (тип int)
        и методами:
            объявить начало занятий()
            объявить окончание занятий занятий()
        
        Класс Школа
        создается со следующими харатеристиками:
            название - задается при создании объекта и не может быть изменено в последствии
            директор - школа не может функционировать без директора
            учителя[] - массив
            ученики[] - массив
        и методом:
            день в школе() - 
                1. директор объявляет начало занятий
                2. учителя учат учеников (предмет учителя и ученика должны совпадать)
                3. директор объявляет окончание занятий
        
        Методы учить() и учиться() необходимо описать в разных интерфейсах
        Общие свойства необходимо вынести в родительские классы (какие определить самостоятельно)
        В классах можно добавлять методы и свойства при необходимости 
      
### Занятие 8
[Ключевые слова final и static](src/com/ifmo/jjd/lesson8/SomeUtils.java)
        
### Занятие 9
[Методы toString, clone, hashCode, equals класса Object](src/com/ifmo/jjd/lesson9)

### Занятие 10
1. [Дата и время. Date и Calendar](src/com/ifmo/jjd/lesson10/calendar)
2. [Дата и время. DateTime API](src/com/ifmo/jjd/lesson10/datetimeapi)


### Занятие 10
1. [Enum](src/com/ifmo/jjd/lesson11)

### Домашнее задание
1. Задача     
    Дано
     1.  enum должностей Position,
     2.  класс User со следующими полями:
         String fulName;
         int salary;
         Position position;
     3. несколько массивов, в каждом массиве будут храниться объекты класса User 
     с одинаковыми должностями
            
     Пользователь вводит свои имя, фамилию и первую букву должности.
     Ваша задача создать объект типа User и поместить его в соответствующий массив.
     
2. Задача: написать enum, который перечисляет планеты Солнечной системы и возвращает 
массу планеты, ее радиус и радиус орбиты.


Занятие 12
1. [Исключения](src/com/ifmo/jjd/lesson12)

### Домашнее задание на исключения:

1. Метод *static void throwException(Status status) throws JarException, FileNotFoundException, AccessDeniedException*
принимает на вход enum и выбрасывает следующие исключения в зависимости от значения status:
    1. если status FILE_NOT_FOUND, выбрасывает FileNotFoundException
    2. если status ACCESS_DENIED, выбрасывает AccessDeniedException
    3. если status JAR_ERROR, выбрасывает JarException.
    
При вызове метода throwException обработать исключения следующим образом:
*FileNotFoundException* - выводить в консоль сообщение исключения(метод getMessage()) + любое дополнительное сообщение,
*AccessDeniedException* - выводить в консоль сообщение исключения (метод getMessage()) и снова выбрасывать exception,
*JarException* - выводить в консоль стек трейс.

enum Status с необходимыми константами нужно создать.

2. Создать массив исключений и заполнить его 9 различными runtime исключениями.
Например,

         try {
             int[] arr = new int[5];
             arr[7] = 12;
         } catch (Exception e) {
             exepArr[0] = e;
         }
и тд         


Занятие 13 [Generic](src/com/ifmo/jjd/lesson13/generic)
1. [Типизированные методы (Generic Methods)](src/com/ifmo/jjd/lesson13/generic/methods)
2. [Типизированные классы (Generic Types)](src/com/ifmo/jjd/lesson13/generic/types)
3. [Ограничения (Bounded Type Parameters)](src/com/ifmo/jjd/lesson13/generic/bounded/type/parameters)
4. [Ограничения (Wildcard)](src/com/ifmo/jjd/lesson13/generic/wildcard)

Занятие 14 [Обертки над примитивами](src/com/ifmo/jjd/lesson14)

Занятие 15
1. [Коллекции](src/com/ifmo/jjd/lesson15/collection)
2. [Компараторы](src/com/ifmo/jjd/lesson15/compare)

### Домашнее задание:
1. [Задания в пакете lesson15/hw](src/com/ifmo/jjd/lesson15/hw)


Занятие 16
1. [Мапы](src/com/ifmo/jjd/lesson16)

### Домашнее задание:
1. [Задания в пакете lesson16/hw](src/com/ifmo/jjd/lesson16/hw)

Занятие 17
1. [Рефлексия и Анотации](src/com/ifmo/jjd/lesson17)

### Домашнее задание:
1. Написать рефлексивный public static String toString(Object o), который принимает на вход объект и выводит информацию по его свойствам в формате:
имя свойства - значение свойства
2. Создать объект, установить значение свойств, вызвать метод, используя рефлексию:
   1. Если класс аннотирован @Config, создать экземпляр данного класса
   2. Если поле данного класса аннотировано @Required, установить значение свойства через сеттер для ранее созданного объекта (имя сеттера = 'set' + ИмяСвойства)
   3. Вызвать метод toString у ранее созданного объекта

Занятие 19
1. [IO: запись в файл / чтение из файла](src/com/ifmo/jjd/lesson19/IOLesson.java)

### Домашнее задание:
1. Написать декораторы для зашифровки / расшифровки байт

Занятие 20
1. [Сериализация / Десериализация](src/com/ifmo/jjd/lesson20)
 
### Домашнее задание:
1. Сохранить состояние юнитов из lesson7  (фермы из дз) в файл, прочитать из файла
2. Изменить код клиента так, что настройки: ip и port он будет получать из properties файла
3. По клиент - серверу (для отправки команд используйте класс SimpleMessage):
    
        Клиент от пользователя принимает список команд:
           /help - пользователь хочет узнать список доступных команд
           /count - пользователь хочет узнать количество клиентов сервера, которые подключались к серверу
           /ping - пользователь хочет узнать время за которое сообщение доходит до сервера и возвращается обратно
           /exit - пользователь хочет выйти из программы (завершение программы)
        
        Сервер принимает, обрабатывает запрос и отправляет ответ на следующие команды:
             /help - список доступных команд
             /count - количество подключений сервера
             /ping - время за которое сообщение доходит до сервера и возвращается обратно   

Занятие 22
1. [Lambda](src/com/ifmo/jjd/lesson22)

### Домашнее задание:
1. Отработать написание лямбда (написать по 2 реализации) для: Predicate, Function, UnaryOperator, BinaryOperator, Consumer
2. Переписать компараторы из lesson15/hw с использованием синтаксиса лямбд
3. Написать реализацию метода public List<Course> filtered(Predicate<Course> filter) класса University. 
4. Использовать реализованный в п.3 метод для получения списков курсов: 

       продолжительностью менее 3х месяцев;
       стоимостью менее 20000;
       курсов с названием JJD;
       продолжительностью менее 3х месяцев и стоимостью менее 20000;
       продолжительностью менее 3х месяцев и стоимостью менее 20000 или курсов с названием JJD;

5. Используя метод foreach увеличить стоимость всех курсов на 10000. 


Занятие 23
1. [Stream API](src/com/ifmo/jjd/lesson23)

### Домашнее задание:
1. [Задание топ 10 слов](src/com/ifmo/jjd/lesson23/task/TopTenWords.java)
2. [Задание Ученики](src/com/ifmo/jjd/lesson23/task/pupils/PupilTask.java)
3. [Задание Транзакции](src/com/ifmo/jjd/lesson23/task/tansactions/TransactionsTask.java)


Занятие 24
1. [Многопоточность 1](src/com/ifmo/jjd/multithreading/lesson24)

Занятие 25
1. [Многопоточность. synchronized](src/com/ifmo/jjd/multithreading/lesson25/sync)
2. [Многопоточность. wait, notify](src/com/ifmo/jjd/multithreading/lesson25/waitnotify)

### Домашнее задание:
1. Задание 'Топ N слов'

        Основной поток читает из файла текст, разбивает его на несколько частей
        Каждый поток получает свою часть, считает количество слов, переносит результат в общую мапу
        Основной поток выводит результат: топ N слов
        
        количество потоков = Runtime.getRuntime().availableProcessors();
        
2. [Задание Transaction](src/com/ifmo/jjd/multithreading/lesson25/task)
        
        Написать реализацию метода run класса Transaction
        
Занятие 26
1. [Блокирующие очереди](src/com/ifmo/jjd/multithreading/lesson26/blocking)

### Домашнее задание:
1. Пиццерия (на блокирующие очереди)
        
          Клиент - поток создает заказ и добавляет в очередь 1 забирает готовые заказы из очереди 3
          Официант - поток забирает заказ из очереди 1 и добавляет в очередь 2
          Повар - поток забирает заказ из очереди 2, готовит - Thread.sleep() и добавляет в очередь 3
          
          Заказ - объект, создаваемый Клиентом
          
          Запускайте программу с разным количеством клиентов, официантов и поваров
        

## Курсовые
1. [Базовый синтаксис и семантика языка](exams/first-fitness.txt) срок сдачи 19 октября 2020 до 18:40
2. [Многопоточность](exams/second-exam.txt) срок сдачи 28 декабря 2020 до 18:40
3. [Реализация шаблона проектирования]
4. [Работа с базами данных с использованием ORM Hibernate]



### Список книг

1. Герберт Шилдт «Java (8/9). Руководство для начинающих»  

2. Герберт Шилдт  «Java. Полное руководство»

3. Сьерра-Бейтс. Изучаем Java (самые самые основы)  Эту книгу сама не читала, но отзывы по ней разные. Кому-то очень нравится, а кто-то ужасе от простоты изложения

4. Блох. Java. Эффективное программирование 

5. Брюс Эккель. Философия Java

6. Хортсманн. Java. Библиотека профессионала, в двух томах (второй том посвящен Java EE)

