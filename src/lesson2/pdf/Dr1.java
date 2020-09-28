package lesson2.pdf;

import java.util.Scanner;

public class Dr1 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ваше число равно 50?");
        int a = scanner.nextInt();
        if (a == 1) {
            System.out.println("Победа");
        } else if (a == 0) {
            System.out.println("Ваше число меньше 50?");
            int b = scanner.nextInt();
            if (b == 1) {
                int c = 1;
                while (c < 50) {
                    System.out.println("Ваше число " + c);
                    int c1 = scanner.nextInt();
                    if (c1 == 1) {
                        System.out.println("Победа");
                        break;

                    } else if (c1 == 0) {
                        c++;
                    }
                }
            } else if (b == 0) {
                System.out.println("Ваше число больше 50?");
                int d = scanner.nextInt();
                if (d == 0) {
                    System.out.println("Error");
                } else if (d == 1) {
                    int d1 = 51;
                    while (d1 <= 100) {
                        System.out.println("Ваше число " + d1);
                        int d2 = scanner.nextInt();
                        if (d2 == 0) {
                            d1++;
                        } else if (d2 == 1) {
                            System.out.println("Победа");
                            break;
                        }
                    }
                }
            }
        }
    }
}
