package dao;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao {

    Connection  connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(){

        String sql = "CREATE TABLE IF NOT EXISTS User (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "login TEXT NOT NULL);";
        try {
            DriverManager.registerDriver(new JDBC());
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Создали таблицу User");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean add(Object obj) {
        if (obj instanceof User){
            User newUser = (User) obj;
            String insert  = "INSERT INTO User ( login)" +
                    "VALUES (?);";
            try {
                PreparedStatement statement = connection.prepareStatement(insert );
                statement.setString(1, newUser.getLogin());

                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void delete(int id) {
        String delete = "DELETE FROM User WHERE id=?;";
        try {
            PreparedStatement statement = connection.prepareStatement(delete);
            statement.setInt(1,id);
            statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void update(int id, Object obj) {
        String update = "UPDATE User SET id=?, login=? WHERE id=?";
        if (obj instanceof User){
            User newUser = (User) obj;
            try {
                PreparedStatement statement = connection.prepareStatement(update );
                statement.setInt(1, newUser.getId());
                statement.setString(2,newUser.getLogin());
                statement.setInt(3, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Object> getAll() {
        String getAl = "SELECT * FROM User;";
        List<Object> userList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(getAl );
            ResultSet resultSet = statement.executeQuery();
            for (int i = 0; resultSet.next(); i++) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public Object getById(int id) {
        String sql  = "SELECT * FROM User WHERE id = ?;";
        User resUser = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql );
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            User userId = new User();
            while (resultSet.next()) {
                userId.setId(resultSet.getInt("id"));
                userId.setLogin(resultSet.getString("login"));
            }
            resUser = userId;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resUser;
    }
}
