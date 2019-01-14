package dao;

import org.sqlite.JDBC;

import java.sql.*;
import java.util.List;

public class ArticleDao implements Dao{

    Connection  connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:lesson8.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(){

        String sql = "CREATE TABLE IF NOT EXISTS Article (" +
                "id INTEGER PRIMARY KEY  NOT NULL," +
                "title TEXT NOT NULL," +
                "idUser INTEGER NOT NULL);";
        try {
            DriverManager.registerDriver(new JDBC());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            System.out.println(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean add(Object obj) {
        if (obj instanceof Article){
            Article newArticle = (Article) obj;
            String sql = "INSERT INTO Article (id, title,idUser)" +
                    "VALUES (?, ?,?);";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setInt(1, newArticle.getId());
                statement.setString(2, newArticle.getTitle());
                statement.setInt(3, newArticle.getIdUser());

                int row = statement.executeUpdate();
                System.out.println(row);
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

    }

    @Override
    public void update(int id, Object obj) {

    }

    @Override
    public List<Object> getAll() {

        return null;
    }

    @Override
    public Object getById(int id) {

        return null;
    }
}
