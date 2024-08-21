package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();

        userService.createUsersTable();
        userService.saveUser("19382", "1kdjishd", (byte) 11);
        userService.saveUser("29382", "2kdjishd", (byte) 22);
        userService.saveUser("39382", "3kdjishd", (byte) 33);
        userService.saveUser("49382", "4kdjishd", (byte) 44);

        userService.removeUserById(1);
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }
        userService.dropUsersTable();











//        userService.createUsersTable();
//        for (int i = 1; i <= 4; i++) {
//            userService.saveUser("test" + i, "testtest" + i, (byte) i);
//        }
//        userService.removeUserById(1);
//        for (User user : userService.getAllUsers()) {
//            System.out.println(user);
//        }
//        userService.cleanUsersTable();
//        userService.dropUsersTable();
//        userService.closeConnection();
    }
}
