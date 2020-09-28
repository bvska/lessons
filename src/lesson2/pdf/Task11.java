package lesson2.pdf;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) { // 42
        Scanner scanner = new Scanner(System.in);
        int rnd, xx, yesNo = 0, min = 1, max = 100;
        rnd = (min + max + 1) / 2;
        while (yesNo == 0) {
            System.out.println("это число " + rnd + "?");
            yesNo = scanner.nextInt();
            if (yesNo == 1) {
                System.out.println("Угадал");
            } else {
                System.out.println("число больше Х?");
                xx = scanner.nextInt();
                if (xx == 1) min = rnd;
                else max = rnd;
                rnd =  (min + max + 1) / 2;
            }
        }
    }
}
