package com.openai.chat;

import com.openai.chat.model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
    private Connection connection;

    // pripojenie k databáze
    // konstruktor triedy UserDAO
    public UserDAO() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/kniznica_db"; // zmeňte URL a názov databázy podľa potreby
        String username = "root"; // zmeňte používateľské meno podľa potreby
        String password = "password"; // zmeňte heslo podľa potreby
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Spojenie s databázou je v poriadku!");
    }

    // vytvorenie záznamu
    public void create(User user) throws SQLException {
        String sql = "INSERT INTO pouzivatelia (name, email) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.executeUpdate();
    }

    // načítanie záznamu podľa ID
    public User read(int id) throws SQLException {
        String sql = "SELECT * FROM pouzivatelia WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet result = statement.executeQuery();

        if (result.next()) {
            User user = new User();
            user.setId(result.getInt("id"));
            user.setName(result.getString("name"));
            user.setEmail(result.getString("email"));
            return user;
        } else {
            return null;
        }
    }

    // načítanie všetkých záznamov
    public ArrayList<User> readAll() throws SQLException {
        String sql = "SELECT * FROM pouzivatelia";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        ArrayList<User> users = new ArrayList<User>(); // vytvorili sme prazdny ArrayList, ktory bude obsahovat pouzivatelov, cize User
        while (result.next()) {
            User user = new User();
            user.setId(result.getInt("id"));
            user.setName(result.getString("name"));
            user.setEmail(result.getString("email"));
            users.add(user); // naplneneho pouzivatela ulozime do ArrayList
        }
        return users;
    }




    // aktualizácia záznamu
    public void update(User user) throws SQLException {
        String sql = "UPDATE pouzivatelia SET name = ?, email = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getName());
        statement.setString(2, user.getEmail());
        statement.setInt(3, user.getId());
        statement.executeUpdate();
    }


    // vymazanie záznamu podľa ID
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM pouzivatelia WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

}
