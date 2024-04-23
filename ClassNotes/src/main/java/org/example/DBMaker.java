package org.example;

import java.sql.*;
import java.sql.SQLException;


public class DBMaker {
    public static void main(String dbName, String itemName, String itemNote) throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(dbName);
            String itemInsert = "INSERT INTO dbtable VALUES (?, ?)";
            PreparedStatement insertItem = connection.prepareStatement(itemInsert);

            insertItem.setString(1, itemName);
            insertItem.setString(2, itemNote);

            insertItem.executeUpdate();
            insertItem.close();
            connection.close();

            showDB(dbName);
        } catch (SQLException e) {
            System.out.println("An item already has that name.");
            Main.dbMaker();
        }
    }

    static void dbCreation(String filename) throws SQLException {
        Connection connection = DriverManager.getConnection(filename);
        Statement statement = connection.createStatement();

        String newDBTable = "CREATE TABLE IF NOT EXISTS dbtable (item text, note text)";
        statement.execute(newDBTable);

        connection.close();
        statement.close();
    }

    static void showDB(String filename){
        try{
            Connection connection = DriverManager.getConnection(filename);
            Statement statement = connection.createStatement();

            String showAll = "SELECT * FROM dbtable ORDER BY item";
            ResultSet show = statement.executeQuery(showAll);

            while(show.next()){
                String itemName = show.getString("item");
                String itemNote = show.getString("note");
                System.out.printf("Item name: %s   Item note: %s\n", itemName, itemNote);
            }
            connection.close();
            statement.close();
            show.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
