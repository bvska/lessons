package lesson2.pdf;

import java.util.Scanner;


public class T1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // int chiclo = 100;
        int rcase;
        boolean flag = true, eflag = true, af = true, bf = true;
        int lc = 0, uc = 100;
        //lc = 0;
        //uc = 100;
        int lc2 = lc, uc2 = uc;
        // int uc2 = uc;
        //String b;
        int chiclo = (uc + lc) / 2;
        String b = "Chislo - " + chiclo + "?";
        System.out.println(b);
        int num = scanner.nextInt();
        if (num == 1) flag = false;
        while (flag) {
            rcase = (int) (Math.random() * 3);
            switch (rcase) {
                case 0:
                    bf = true;
                    if (af == false) break; // лучше заменить на if (!af)
                    b = "Chislo > " + chiclo + "?";
                    System.out.println(b);
                    num = scanner.nextInt();
                    if (num == 1) {
                        if (chiclo == (uc2 - 1)) flag = false;
                        lc = chiclo;
                        chiclo = (uc + lc) / 2;
                        eflag = false;
                        break;
                    }
                    af = false;
                    break;
                case 1:
                    af = true;
                    if (!bf) break;
                    b = "Chislo < " + chiclo + "?";
                    System.out.println(b);
                    num = scanner.nextInt();
                    if (num == 1) {
                        if (chiclo == (lc2 + 1)) flag = false;
                        uc = chiclo;
                        chiclo = (uc + lc) / 2;
                        eflag = false;
                        break;
                    }
                    bf = false;
                    break;
                case 2:
                    if (eflag == true) break; // лучше заменить на if (eflag)
                    b = "Chislo = " + chiclo + "?";
                    System.out.println(b);
                    eflag = true;
                    af = true;
                    bf = true;
                    num = scanner.nextInt();
                    if (num == 1) {
                        flag = false;

                    }
                    break;

            }
        }


    }
}
