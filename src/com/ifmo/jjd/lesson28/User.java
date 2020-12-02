package com.ifmo.jjd.lesson28;

public class User {
    private Level level;
    private String login;

    public User(String login, Level level) {
        this.level = level;
        this.login = login;
    }


    public class Account {
        private static final int MAX_BALANCE = 500;
        private float balance;

        public Account(int balance) {
            this.balance = balance + User.this.level.getCount();
        }

        public String getInfo(){
            return "Пользователь: " + User.this.login + "; " +
                    "Баланс: " + balance + ".";
        }

        public User getUser(){
            return User.this;
        }
    }

    public enum Level{
        HIGH(10), MEDIUM(5), LOW(0);

        private  int count;
        Level(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }
    }
}