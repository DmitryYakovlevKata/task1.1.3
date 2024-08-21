package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        for (int i = 1; i <= 4; i++) {
            userService.saveUser("test" + i, "testtest" + i, (byte) i);
        }
        userService.removeUserById(1);
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
        userService.closeConnection();
    }
}
