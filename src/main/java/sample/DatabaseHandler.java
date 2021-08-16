package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + "/" + dbName + "?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        System.out.println("connection OK");
        return dbConnection;

    }

    public void addUser(Tour tour) {

        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + "," +
                Const.USERS_DESTINATION + "," + Const.USERS_PRICE + "," +
                Const.USERS_HOTEL + "," + Const.USERS_TRIP + "," + Const.USERS_SHOPPING + ")" +
                "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, tour.getFirstName());
            prSt.setString(2, tour.getLastName());
            prSt.setString(3, tour.getDestination());
            prSt.setInt(4, tour.getPrice());
            prSt.setString(5, tour.getHotel());
            prSt.setString(6, tour.getTrip());
            prSt.setString(7, tour.getShopping());
            System.out.println("inserted successfully");

            prSt.executeUpdate();
            ResultSet resultSet = prSt.executeQuery("SELECT * FROM " + Const.USER_TABLE);
            display(resultSet);
            System.out.println("updated");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void selectUser(Tour tour) {
        ResultSet resSet;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_FIRSTNAME + "=? AND " + Const.USERS_LASTNAME + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, tour.getFirstName());
            prSt.setString(2, tour.getLastName());

            System.out.println("selected successfully");

            resSet = prSt.executeQuery();
            display(resSet);
            System.out.println("updated");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void deleteUser(Tour tour) {
        String delete = "DELETE FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_FIRSTNAME + "=? AND " + Const.USERS_LASTNAME + "=? AND " + Const.USERS_DESTINATION + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(delete);
            prSt.setString(1, tour.getFirstName());
            prSt.setString(2, tour.getLastName());
            prSt.setString(3, tour.getDestination());

            System.out.println("deleted successfully");

            prSt.executeUpdate();
            ResultSet resultSet = prSt.executeQuery("SELECT * FROM " + Const.USER_TABLE);
            display(resultSet);
            System.out.println("updated");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(Tour tour) {
        String update = "UPDATE " + Const.USER_TABLE + " SET " + Const.USERS_DESTINATION + " =?, " + Const.USERS_PRICE + " =?, " + Const.USERS_HOTEL + " =?, " + Const.USERS_TRIP + " =?, " + Const.USERS_SHOPPING + " =? " + " WHERE " + Const.USERS_FIRSTNAME + "=? AND " + Const.USERS_LASTNAME + "=?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(update);
            prSt.setString(1, tour.getDestination());
            prSt.setInt(2, tour.getPrice());
            prSt.setString(3, tour.getHotel());
            prSt.setString(4, tour.getTrip());
            prSt.setString(5, tour.getShopping());
            prSt.setString(6, tour.getFirstName());
            prSt.setString(7, tour.getLastName());
            System.out.println("inserted successfully");

            prSt.executeUpdate();
            ResultSet resultSet = prSt.executeQuery("SELECT * FROM " + Const.USER_TABLE);
            display(resultSet);
            System.out.println("updated");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void display(ResultSet resultSet) throws SQLException {

        while (resultSet.next()) {

            int id = resultSet.getInt(1);
            String firstName = resultSet.getString(2);
            String lastName = resultSet.getString(3);
            String destination = resultSet.getString(4);
            int price = resultSet.getInt(5);
            String hotel = resultSet.getString(6);
            String trip = resultSet.getString(7);
            String shopping = resultSet.getString(8);
            System.out.printf("%d, %s, %s, %s, %d, %s, %s, %s \n", id, firstName, lastName, destination, price, hotel, trip, shopping);
        }
    }

}
