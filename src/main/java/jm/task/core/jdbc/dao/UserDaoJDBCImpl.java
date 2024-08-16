package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Connection connection = new Util().getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE IF NOT EXISTS Users " +
                    "(id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(50), " +
                    "lastName VARCHAR(50), " +
                    "age TINYINT)";
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        Connection connection = new Util().getConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "DROP TABLE IF EXISTS Users";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Connection connection = new Util().getConnection();
        try {
            String query = "INSERT INTO Users " +
                    "(name, lastName, age) " +
                    "VALUES (?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            connection.close();
            System.out.printf("User с именем — %s добавлен в базу данных\n", name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        Connection connection = new Util().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Users WHERE id = ?;");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        Connection connection = new Util().getConnection();
        List<User> list = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Users;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public void cleanUsersTable() {
        Connection connection = new Util().getConnection();
        try {
            Statement statement = connection.createStatement();
            String query1 = "DROP TABLE IF EXISTS Users";
            String query2 = "CREATE TABLE IF NOT EXISTS Users " +
                    "(id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(50), " +
                    "lastName VARCHAR(50), " +
                    "age TINYINT)";
            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
