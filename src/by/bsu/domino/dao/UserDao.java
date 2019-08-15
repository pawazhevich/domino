package by.bsu.domino.dao;


import by.bsu.domino.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

public class UserDao extends Dao<User>{
    private static final String ALL_FIELDS = " user_id, user_login, user_name, password ";
    private static final String USER_TABLE = " user ";

    private Connection connection;

    public UserDao(){
        connection = MySQLConnector.getConnection();
    }

    @Override
    public void insert(User user) {
        try{
            Statement statement = connection.createStatement();
            String query = "INSERT INTO " + USER_TABLE + "(user_login, user_name, password) VALUES " +
                    "('" + user.getLogin() + "','" + user.getUsername() + "','" + user.getPassword() + "')";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getById(int id) {
        try{
            Statement statement = connection.createStatement();
            String query = "SELECT " + ALL_FIELDS + " FROM " + USER_TABLE + " WHERE user_id = '"+id+"'";
            ResultSet resultSet = statement.executeQuery(query);

            resultSet.next();
            String login = resultSet.getString("user_login");
            String username = resultSet.getString("user_name");
            String password = resultSet.getString("password");

            return new User(id, login, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(User user) {
        try{
            Statement statement = connection.createStatement();
            String query = "UPDATE " + USER_TABLE + "SET user_login = '" + user.getLogin() + "', user_name = '" + user.getUsername() +
                    "', password = '" + user.getPassword() + "' WHERE user_id = '" + user.getId() + "'";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        try{
            Statement statement = connection.createStatement();
            String query = "DELETE FROM " + USER_TABLE + "WHERE id = '" + user.getId() + "'";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<>();

        try{
            Statement statement = connection.createStatement();
            String query = "SELECT " + ALL_FIELDS + " FROM " + USER_TABLE;
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int id = resultSet.getInt("user_id");
                String login = resultSet.getString("user_login");
                String username = resultSet.getString("user_name");
                String password = resultSet.getString("password");

                users.add(new User(id, login, username, password));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    /**
     * method checks is the user with login and password exists. If so, returns this user, else returns null
    */
    //TODO rework this method
    public Optional<User> isExist(String login, String password){
        Optional<User> user = Optional.empty();
        try{
            Statement statement = connection.createStatement();
            String query = "SELECT " + ALL_FIELDS + "FROM " +USER_TABLE+ " WHERE user_login = '" + login
                    + "' AND password = '" + password + "'";
            ResultSet resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                int id = resultSet.getInt("user_id");
                String username = resultSet.getString("user_name");
                user = Optional.of(new User(id, login, username, password));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
