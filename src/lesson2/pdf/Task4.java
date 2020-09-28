package lesson2.pdf;

public class Task4 {

    public static void main(String[] args) {

        int min = 10;
        int max = 500;

        int i = 1;
        while (i <= 5) {
            int chislo = min + (int) (Math.random() * (max - min + 1));
            System.out.println("Сгенерированное число: " + chislo);

            if (chislo < 25 || chislo > 200) {
                System.out.println("Число: " + chislo + "содержится в интервале");
            } else {
                System.out.println("Число не содержится в интервале");

            }
            i++;
        }

    }
}
