package dao;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User("PackMen");
        UserDao userDao = new UserDao();
//        userDao.createTable();
//        System.out.println(  userDao.add(user) ? "Добавили пользователя" + user : "Не добавили пользователя" + user);
        List<Object>  userList = userDao.getAll();
        System.out.println(userList);
//        User user1 = (User) userDao.getById(1);
//        System.out.println(user1);
//        userDao.delete(2);
//        userList = userDao.getAll();
//        System.out.println(userList);
        userDao.update(3, new User(3,"Simpson"));
        userList = userDao.getAll();
        System.out.println(userList);
    }
}
