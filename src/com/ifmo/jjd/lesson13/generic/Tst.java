package com.ifmo.jjd.lesson13.generic;

public class Tst {
    public static void main(String[] args) {
        User user = new User();
        UserDao userDao = new UserDao(user);
        userDao.save();
        userDao.getAll();
    }
}

interface Dao<T, ID> {
    T save();
    T update(ID id);
    T delete(ID id);
    T getById(ID id);
    T[] getAll();
}

class User {}

class UserDao implements Dao<User, Integer> {
    private User user;

    public UserDao(User user) {
        this.user = user;
    }

    @Override
    public User save() {
        return null;
    }

    @Override
    public User update(Integer integer) {
        return null;
    }

    @Override
    public User delete(Integer integer) {
        return null;
    }

    @Override
    public User getById(Integer integer) {
        return null;
    }

    @Override
    public User[] getAll() {
        return new User[0];
    }
}