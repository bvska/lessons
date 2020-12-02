package com.ifmo.jjd.lesson28;

import java.util.Arrays;

public class TstInner {
    public static void main(String[] args) {
        User user = new User("qwe", User.Level.HIGH);
        User.Account account = user.new Account(200);
        System.out.println(account.getInfo());

        User.Account someAccount = new User("asd", User.Level.MEDIUM).new Account(100);

        Student student = new Student("Кирилл");
        Student.Exam math = new Student.Exam("математика", 4);
        Student.Exam rl = new Student.Exam("русский язык", 3);

        student.getExams().addAll(Arrays.asList(math, rl));
        student.passInfo();

        math.examInfo();
        rl.examInfo();

    }
}
