package lesson2;



public class DecisionMakingStatements {
    public static void main(String[] args) {
        // if else
        /*
        if (условие1) {
            набор инструкций выполнится, если условие1 true
        } else if (условие2) {
            набор инструкций выполнится, если условие1 false
            и условие2 true
        } else if (условие3) {
            набор инструкций выполнится, если все предыдущие условия
            false и условие3 true
        } else {
            набор инструкций выполнится, если все предыдущие условия false
        }
        * */
        int state = 1;
        // 0 - вывести на экран "Закрытие приложения"
        // 1 - вывести на экран "Запуск приложения"
        // в остальных случаях "Ошибка статуса"

        if (state == 0) System.out.println("Закрытие приложения");
        else if (state == 1) System.out.println("Запуск приложения");
        else System.out.println("Ошибка статуса");

        if (state == 0) {
            System.out.println("Закрытие приложения");
        } else if (state == 1) {
            System.out.println("Запуск приложения");
        } else {
            System.out.println("Ошибка статуса");
        }

        // логические операторы
        // && и
        // || или
        // ! не
        // ^ исключающее или
        /*int state = 0;
        int code = 600;
        (state == 0 && code > 100) // false
        age = 30;
        exp = 10;
        (age > 30 && exp > 7) // false
        (age > 30 || exp > 7) // true
        !(age > 30 || exp > 7) // false
        isClosed = false;
        !isClosed // true
        (state == 0 ^ code > 100)  // false
        ((state == 0 ^ code > 100) || (age > 90 && z > 0))*/

        int count = 60;
        // 100 - 90 правильных ответов: 5
        // 89 - 60 правильных ответов: 4
        // 59 - 40 правильных ответов: 3
        // 39 - 0 правильных ответов: 2

        if (count > 100 || count < 0){
            System.out.println("Ошибка ввода");
        } else if (count <= 100 && count >= 90) {
            // 5
        } else if (count >= 60 && count < 90){
            // 4
        } else if (count >= 40 && count < 60) {
            // 3
        } else {
            // 2
        }

        /*
        switch (переменная/выражение) {
            case значение1/выражение1:
                инструкции;
                break;
           case значение2/выражение2:
           case значение3/выражение3:
                инструкции;
                break;
          case значение4/выражение4:
                инструкции;
                break;
          default:
              инструкции;
              break;
        }

        выражение/переменная могут быть:
        byte (Byte), short (Short), char (Character),
        int (Integer), String, enum (перечисления)
        выражение сравнивается с case
        при найденном совпадении switch выполнит инструкции
        от соответствующего case до первого break или
        конца конструкции switch
        */

        int sum = 10000;
        int code = 5698;

        // 4653 - скидка 30%
        // 5698, 5111 - скидка 20%
        // 6922, 6113, 6099 - скидка 10%
        // в остальных случаях скидки нет
        // Вывести сумму с учетом скидки




















    }
}
