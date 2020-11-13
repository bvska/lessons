package com.ifmo.jjd.lesson21;

public class SomeClass {
    public static void main(String[] args) {
        // побитовые операторы | & ~ <<
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(4));
        System.out.println(Integer.toBinaryString(2));

        // 1000 | 0100
        // 1000
        // 0100
        // 1100

        // 1000 & 0100
        // 1000
        // 0100
        // 0000

        // ~1000 -> 0111

        User user = new User();
        // установить разрешения на файлы (0001) и видео (1000)
        user.setPerm(Permissions.FILE | Permissions.VIDEO); // 1001

        // проверим наличие разрешения на работу с AUDIO (0100)
        // 1001 & 0100 -> 0000 != 0100
        if ((user.getPerm() & Permissions.AUDIO) != Permissions.AUDIO) {
            System.out.println("У Вас нет доступа к аудио файлам");
        } else {
            System.out.println("Доступ открыт");
        }

        // удаление разрешения (& ~) на работу с FILE 0001
        // 1001 & ~0001 -> 1001 & 1110 -> 1000
        user.setPerm(user.getPerm() & ~Permissions.FILE);
    }
}

class User {
    private int perm;

    public int getPerm() {
        return perm;
    }

    public void setPerm(int perm) {
        this.perm = perm;
    }
}

class Permissions {
    // отсутствие разрешений - 0000
    // наличие всех разрешений - 1111
    // 1 << 3 биты числа 1 сдвигаем на 3 ячейки
    // (3 раза умножили 1 на 2)
    public static final int FILE = 1; // 1 - 0001
    public static final int PHOTO = 1 << 1; // 2 - 0010
    public static final int AUDIO = 1 << 2; // 4 - 0100
    public static final int VIDEO = 1 << 3; // 8 - 1000
}
