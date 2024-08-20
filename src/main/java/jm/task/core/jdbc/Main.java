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

//        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
//            public void run() {
//                try {
//                    Class<?> c = Class.forName("jm.task.core.jdbc.dao.UserDaoJDBCImpl");
//                    Field field = c.getDeclaredField("connection");
//                    field.setAccessible(true);
//                    Object fieldValue = field.get(c);
//                    Method method = fieldValue.getClass().getDeclaredMethod("close");
//                    method.invoke(fieldValue);
//                } catch (ClassNotFoundException | NoSuchFieldException e) {
//                    throw new RuntimeException(e);
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e);
//                } catch (NoSuchMethodException e) {
//                    throw new RuntimeException(e);
//                } catch (InvocationTargetException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }, "Shutdown-thread"));
    }
}
