package lesson2.pdf;

public class Task5 {

    public static void main(String[] args) {

        int ticketNumber = 444;
        String text;

        switch (ticketNumber) {
            case 111:
            case 222:
            case 333:
                text = "Книга";
                break;
            case 444:
            case 555:
                text = "Телефон";
                break;
            case 777:
                text = "Ноутбук";
                break;
            default:
                text = "Приза нет";
        }
        System.out.println(text);
    }
}
