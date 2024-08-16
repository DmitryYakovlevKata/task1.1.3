package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        userDao.saveUser("test1", "testtest1", (byte) 1);
        userDao.saveUser("test2", "testtest2", (byte) 2);
        userDao.saveUser("test3", "testtest3", (byte) 3);
        userDao.saveUser("test4", "testtest4", (byte) 4);

        userDao.removeUserById(2);
        for (User user : userDao.getAllUsers()) {
            System.out.println(user);
        }
    }
}
